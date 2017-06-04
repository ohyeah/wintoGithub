package winto.com.wintodata;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import butterknife.Unbinder;
import winto.com.wintodata.utils.CommonUtils;
import winto.com.wintodata.utils.KeyboardUtils;
import winto.com.wintodata.utils.ScreenShotUtils;

/**
 * Created by hkun2012 on 2017/5/28.
 */

public class BaseActivity extends AppCompatActivity {
    public static final int RETURN_CODE = 1;
    protected Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // // TODO: 2017/5/28
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (CommonUtils.isNull(unbinder)) {
            unbinder.unbind();
        }
    }

    public View[] getAllEditText() {
        return null;
    }

    private boolean isTouchOnEditText(float x, float y, View[] views) {
        if (views == null) {
            return true;
        }
        if (views != null) {
            for (View v :
                    views) {
                int[] xy = new int[2];
                v.getLocationOnScreen(xy);
                int width = v.getWidth();
                int height = v.getHeight();
                if (x >= xy[0] && x <= xy[0] + width &&
                        y >= xy[1] && y <= xy[1] + height) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            if (!isTouchOnEditText(ev.getRawX(), ev.getRawY(), getAllEditText())) {
                KeyboardUtils.hideKeyboard(this);
            }
        }
        return super.dispatchTouchEvent(ev);
    }


    protected void doScreenShot(BaseActivity activity, View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, RETURN_CODE);
            } else {
                ScreenShotUtils.takeScreenShot(this, view);
            }
        } else {
            ScreenShotUtils.takeScreenShot(this, view);
        }
    }

    protected View getScreenShotButton() {
        return null;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == RETURN_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                ScreenShotUtils.takeScreenShot(this, getScreenShotButton());
            } else {
                Toast.makeText(this, "由于权限未授予，无法保存截屏图片", Toast.LENGTH_LONG).show();
            }
            return;
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
