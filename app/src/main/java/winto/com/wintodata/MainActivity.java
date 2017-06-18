package winto.com.wintodata;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.widget.Toast;

import java.lang.ref.WeakReference;

import butterknife.ButterKnife;
import winto.com.wintodata.utils.CommonUtils;
import winto.com.wintodata.utils.DateCheckUtils;
import winto.com.wintodata.widget.PopupConfirmDialog;

public class MainActivity extends BaseActivity {
    private long exitTime;

    private MyHandler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        getFragmentManager().beginTransaction().replace(R.id.preference_container, new MainFragment()).commit();

        mHandler = new MyHandler(this);
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                if (DateCheckUtils.checkNeedDate(MainActivity.this)) {
                    PopupConfirmDialog.Builder builder = new PopupConfirmDialog.Builder(MainActivity.this);
                    builder.setCanceledOnTouchOutside(false)
                            .setCanForceClose(false)
                            .setHintText("请输入登录密码: ")
                            .setPositiveButton("确认", new PopupConfirmDialog.OnConfirmListener() {
                                @Override
                                public boolean onConfirm(String data) {
                                    try {
                                        if (CommonUtils.getMD5Sum(data) == -1039) {
                                            Toast.makeText(MainActivity.this, "密码校验成功!", Toast.LENGTH_SHORT).show();
                                            DateCheckUtils.saveCheckTime(MainActivity.this);
                                            return true;
                                        } else {
                                            Toast.makeText(MainActivity.this, "密码校验失败!", Toast.LENGTH_SHORT).show();
                                            finish();
                                            return false;
                                        }
                                    } catch (Exception e) {
                                        return false;
                                    }
                                }
                            })
                            .setKeyDisable(false)
                            .createView()
                            .show();
                }
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
                return true;
            } else {
                finish();
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    private static class MyHandler extends Handler {
        private final WeakReference<BaseActivity> mActivity;
        public MyHandler(final BaseActivity activity) {
            mActivity = new WeakReference<BaseActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if (mActivity == null || mActivity.get() == null) {
                return;
            }
        }
    }
}
