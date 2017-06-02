package winto.com.wintodata;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import winto.com.wintodata.utils.CommonUtils;
import winto.com.wintodata.utils.ScreenShotUtils;
import winto.com.wintodata.utils.SharePreferenceUtils;

/**
 * Created by hkun2012 on 2017/5/28.
 */

public class FlowRateActivity extends BaseActivity {
    public static final double TEST = 0.001 * 0.001 * 3600 * 3.14;

    public static final int RETURN_CODE = 1;

    @BindView(R.id.et_q_content) EditText etQContent;
    @BindView(R.id.et_r_content) EditText etRContent;
    @BindView(R.id.et_v_content) EditText etVContent;
    @BindView(R.id.btn_calc) Button btnCalc;
    @BindView(R.id.btn_screenshot) Button btnScreenShot;

    @OnClick(R.id.btn_calc)
    public void onClickCalc() {
        try {
            Log.e("winto", "ddd");
            if (!CommonUtils.isEmptyString(etQContent.getText().toString()) &&
                    !CommonUtils.isEmptyString(etRContent.getText().toString())) {
                double q = Double.valueOf(etQContent.getText().toString());
                double r = Double.valueOf(etRContent.getText().toString());
                double result = (q * 4) / (TEST * r * r);
                Log.e("winto", "q: " + q + "  r: " + r + "  result: " + result);
                etVContent.setText(CommonUtils.FloaRateActivityGetFormatData(result));
            } else {
                Toast.makeText(FlowRateActivity.this, "请检查!", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Log.e("winto", Log.getStackTraceString(e));
            Toast.makeText(FlowRateActivity.this, "请检查输入参数!", Toast.LENGTH_LONG).show();
        }
    }

    @OnClick(R.id.btn_reset)
    public void onClickReset() {
        etQContent.setText("");
        etRContent.setText("");
        etVContent.setText("");
    }

    @OnClick(R.id.btn_screenshot)
    public void onClickScreenShot() {
        doScreenShot(this, btnScreenShot);
    }

    @Override
    protected View getScreenShotButton() {
        return btnScreenShot;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow_rate);
        unbinder = ButterKnife.bind(this);

        ArrayList<String> savedData = SharePreferenceUtils.getAllFlowRateData(FlowRateActivity.this);
        if (savedData != null && savedData.size() == 3) {
            etQContent.setText(savedData.get(0));
            etRContent.setText(savedData.get(1));
            etVContent.setText(savedData.get(2));
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharePreferenceUtils.saveAllFlowRateData(FlowRateActivity.this, etQContent.getText().toString(),
                etRContent.getText().toString(), etVContent.getText().toString());
    }
}
