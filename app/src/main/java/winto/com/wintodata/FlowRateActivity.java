package winto.com.wintodata;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import winto.com.wintodata.utils.CommonUtils;

/**
 * Created by hkun2012 on 2017/5/28.
 */

public class FlowRateActivity extends BaseActivity {
    public static final double TEST = 0.001 * 0.001 * 3600 * 3.14;

    @BindView(R.id.et_q_content)
    EditText etQContent;
    @BindView(R.id.et_r_content)
    EditText etRContent;
    @BindView(R.id.et_v_content)
    EditText etVContent;
    @BindView(R.id.btn_calc)
    Button btnCalc;

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
                etVContent.setText(String.valueOf(result));
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


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow_rate);
        unbinder = ButterKnife.bind(this);
        if (unbinder != null) {
            Log.e("winto", "unbind: " + unbinder);
        } else {
            Log.e("winto", "null");
        }
    }
}
