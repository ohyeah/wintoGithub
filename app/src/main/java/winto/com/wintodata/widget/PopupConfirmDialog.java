package winto.com.wintodata.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import winto.com.wintodata.R;

/**
 * Created by hkun2012 on 2017/6/8.
 */

public class PopupConfirmDialog extends Dialog {
    public PopupConfirmDialog(Context context) {
        super(context);
    }

    public PopupConfirmDialog(Context context, int theme) {
        super(context, theme);
    }

    public static class Builder {
        private Context mContext;
        private String mPositiveButtonText = null;

        private PopupConfirmDialog mDialog;

        private boolean mCanceledOnTouchOutside = false;
        private boolean mKeyDisable = false;

        private OnConfirmListener mClickListener;
        private DialogInterface.OnDismissListener mDismissListner;

        public Builder(Context context) {
            this.mContext = context;
        }

        public Builder setPositiveButtonText(String t, OnConfirmListener listener) {
            this.mPositiveButtonText = t;
            this.mClickListener = listener;
            return this;
        }

        public Builder setCanceledOnTouchOutside(boolean flag) {
            this.mCanceledOnTouchOutside = flag;
            return this;
        }

        public void dismissDialog() {
            mDialog.dismiss();
        }


        public Builder setCanForceClose(boolean can) {
            mCanceledOnTouchOutside = can;
            return this;
        }

        public Builder setKeyDisable(boolean disable) {
            mKeyDisable = disable;
            return this;
        }

        public PopupConfirmDialog createView() {
            LayoutInflater inflater = (LayoutInflater) this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final PopupConfirmDialog dialog = new PopupConfirmDialog(this.mContext, R.style.Dialog);
            View layout =  inflater.inflate(R.layout.dialog_layout, null);

            Display d = dialog.getWindow().getWindowManager().getDefaultDisplay();
            Point p = new Point();
            d.getSize(p);
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams((int)(p.x * 0.8), ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.addContentView(layout, params);

            TextView posButton = (TextView)layout.findViewById(R.id.dialog_positive_button);
            final EditText editText = (EditText)layout.findViewById(R.id.dialog_password);
            if (mPositiveButtonText != null) {
                posButton.setText(mPositiveButtonText);
                if (mClickListener != null) {
                    posButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (editText != null) {
                                if (mClickListener.onConfirm(editText.getText().toString())) {
                                    dialog.dismiss();
                                }
                            }
                        }
                    });
                }
            }



            if (mDismissListner != null) {
                dialog.setOnDismissListener(mDismissListner);
            }
            dialog.setCanceledOnTouchOutside(mCanceledOnTouchOutside);

            if (mKeyDisable) {
                dialog.setCancelable(false);
                dialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
                    @Override
                    public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                        if (keyCode == KeyEvent.KEYCODE_BACK) {
                            return true;
                        }
                        return false;
                    }
                });
            }

            mDialog = dialog;
            return dialog;
        }
    }

    public interface OnConfirmListener {
        public boolean onConfirm(String data);
    }
}
