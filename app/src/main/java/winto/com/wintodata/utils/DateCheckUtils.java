package winto.com.wintodata.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by hkun2012 on 2017/6/8.
 */

public class DateCheckUtils {

    public static final String FILE_NAME = "winto_data";
    public static final String KEY_NEXT = "next_today";

    public static final long INTERNAL = 1000 * 60 * 5;

    public static boolean checkNeedDate(final Context context) {
        SharedPreferences sharedPreferences =  context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        long time = sharedPreferences.getLong(KEY_NEXT, 0);
        Log.d("winto", "time: " + time);
        if (System.currentTimeMillis() < time) {
            Log.d("winto", "return false");
            return false;
        } else {
            Log.d("winto", "return true");
            return true;
        }
    }

    public static void saveCheckTime(final Context context) {
        SharedPreferences.Editor editor = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE).edit();
        editor.putLong(KEY_NEXT, System.currentTimeMillis() + INTERNAL)
                .apply();
    }
}
