package winto.com.wintodata.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;

/**
 * Created by hkun2012 on 2017/6/8.
 */

public class SignatureUtils {

    public static boolean checkSignature(final Context context) {
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_SIGNATURES);
            Signature sign = info.signatures[0];
            Log.d("winto", "hashCode : " + sign.hashCode());
            if (sign.hashCode() == -177014707) {
                return true;
            } else {
                return false;
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.d("winto", Log.getStackTraceString(e));
            return false;
        }
    }
}
