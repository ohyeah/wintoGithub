package winto.com.wintodata.fragment;

import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import winto.com.wintodata.R;
import winto.com.wintodata.utils.CommonUtils;
import winto.com.wintodata.utils.SharePreferenceUtils;

/**
 * Created by hkun2012 on 2017/6/7.
 */

public class FlowRate_2_Fragment extends BaseFragment {
    private static final double TEST = 0.001 * 0.001 * 3600 * 3.14 / 4;

    @BindView(R.id.et_q_content) EditText etQContent;
    @BindView(R.id.et_r_content) EditText etRContent;
    @BindView(R.id.et_v_content) EditText etVContent;
    @BindView(R.id.btn_calc)
    Button btnCalc;

    @OnClick(R.id.btn_calc)
    public void onClickCalc() {
        try {
            Log.e("winto", "ddd");
            if (!CommonUtils.isEmptyString(etVContent.getText().toString()) &&
                    !CommonUtils.isEmptyString(etRContent.getText().toString())) {
                double v = Double.valueOf(etVContent.getText().toString());
                double r = Double.valueOf(etRContent.getText().toString());
                double result = v * r  * r * TEST;
                Log.e("winto", "v: " + v + "  r: " + r + "  result: " + result + " TEST:" + TEST);
                etQContent.setText(CommonUtils.FloaRateActivityGetFormatData(result));
            } else {
                Toast.makeText(getActivity(), "请检查!", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Log.e("winto", Log.getStackTraceString(e));
            Toast.makeText(getActivity(), "请检查输入参数!", Toast.LENGTH_LONG).show();
        }
    }

    @OnClick(R.id.btn_reset)
    public void onClickReset() {
        etQContent.setText("");
        etRContent.setText("");
        etVContent.setText("");
    }

    @Override
    public int getLayoutResource() {
        return R.layout.fragment_flowrate_2;
    }

    @Override
    public void loadData() {
        ArrayList<String> savedData = SharePreferenceUtils.getAllFlowRateData_2(getActivity());
        if (savedData != null && savedData.size() == 3) {
            etVContent.setText(savedData.get(0));
            etRContent.setText(savedData.get(1));
            etQContent.setText(savedData.get(2));
        }
    }

    @Override
    public void saveData() {
        SharePreferenceUtils.saveAllFlowRateData_2(getActivity(), etVContent.getText().toString(),
                etRContent.getText().toString(), etQContent.getText().toString());
    }
}
