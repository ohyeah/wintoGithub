package winto.com.wintodata.utils;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

import winto.com.wintodata.BaseActivity;

/**
 * Created by hkun2012 on 2017/6/3.
 */

public class ScreenShotUtils {
    public static void takeScreenShot(BaseActivity activity, View v) {
        try {
            Bitmap bitmap = null;
            View view = activity.getWindow().getDecorView();
            // 设置是否可以进行绘图缓存
            view.setDrawingCacheEnabled(true);
            // 如果绘图缓存无法，强制构建绘图缓存
            view.buildDrawingCache();
            // 返回这个缓存视图
            bitmap = view.getDrawingCache();

            // 获取状态栏高度
            Rect frame = new Rect();
            // 测量屏幕宽和高
            view.getWindowVisibleDisplayFrame(frame);
            int stautsHeight = frame.top;
            Log.d("jiangqq", "状态栏的高度为:" + stautsHeight);

            DisplayMetrics dm = activity.getResources().getDisplayMetrics();
            int width = dm.widthPixels;
            int height = dm.heightPixels;
            // 根据坐标点和需要的宽和高创建bitmap
            bitmap = Bitmap.createBitmap(bitmap, 0, stautsHeight, width, height - stautsHeight);
            String filename = Environment.getExternalStorageDirectory().getPath() + "/screenshot_" + System.currentTimeMillis() + ".jpg";
            File file = new File(filename);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 40, new FileOutputStream(file));
            activity.sendBroadcast(
                    new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE
                            , Uri.parse("file://" + filename)));
            Toast.makeText(activity, "截屏成功!", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Log.d("winto", Log.getStackTraceString(e));
            Toast.makeText(activity, "截屏失败，请联系开发人员!", Toast.LENGTH_LONG).show();
        }

    }
}
