package winto.com.wintodata;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {
    private long exitTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        getFragmentManager().beginTransaction().replace(R.id.preference_container, new MainFragment()).commit();
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
}
