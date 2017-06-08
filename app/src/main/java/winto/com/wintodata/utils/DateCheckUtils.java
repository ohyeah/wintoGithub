package winto.com.wintodata.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by hkun2012 on 2017/6/8.
 */

public class DateCheckUtils {
    public static final String FILE_NAME = "winto_data";
    public static final String KEY_NEXT = "next_today";
    public static boolean checkNeedDate(final Context context) {
        SharedPreferences sharedPreferences =  context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        long time = sharedPreferences.getLong(KEY_NEXT, 0);
        if (System.currentTimeMillis() < time) {
            return false;
        } else {
            return true;
        }
    }
}
