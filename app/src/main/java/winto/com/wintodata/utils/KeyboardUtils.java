package winto.com.wintodata.utils;

import android.view.inputmethod.InputMethodManager;

import winto.com.wintodata.BaseActivity;

import static android.content.Context.INPUT_METHOD_SERVICE;

/**
 * Created by hkun2012 on 2017/6/3.
 */

public class KeyboardUtils {

    public static void hideKeyboard(BaseActivity activity) {
        if (activity == null)
            return;

        try {
            ((InputMethodManager) activity.getSystemService(INPUT_METHOD_SERVICE))
                    .hideSoftInputFromWindow(activity.getCurrentFocus()
                            .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        } catch (Exception e) {

        }
    }
}
