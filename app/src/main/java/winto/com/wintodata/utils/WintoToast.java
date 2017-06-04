package winto.com.wintodata.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by hkun2012 on 2017/6/4.
 */

public class WintoToast {
    public static void ToastShort(final Context context, String str) {
        try {
            Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {

        }
    }

    public static void ToastLong(final Context context, String str) {
        try {
            Toast.makeText(context, str, Toast.LENGTH_LONG).show();
        } catch (Exception e) {

        }
    }
}
