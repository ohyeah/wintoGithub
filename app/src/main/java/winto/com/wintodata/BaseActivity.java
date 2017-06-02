package winto.com.wintodata;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.Unbinder;
import winto.com.wintodata.utils.CommonUtils;

/**
 * Created by hkun2012 on 2017/5/28.
 */

public class BaseActivity extends AppCompatActivity {

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
}
