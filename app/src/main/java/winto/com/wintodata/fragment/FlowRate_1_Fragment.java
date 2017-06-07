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

import static winto.com.wintodata.FlowRateActivity.TEST;

/**
 * Created by hkun2012 on 2017/6/7.
 */

public class FlowRate_1_Fragment extends BaseFragment {

    @BindView(R.id.et_q_content)
    EditText etQContent;
    @BindView(R.id.et_r_content) EditText etRContent;
    @BindView(R.id.et_v_content) EditText etVContent;
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
                etVContent.setText(CommonUtils.FloaRateActivityGetFormatData(result));
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
        return R.layout.fragment_flowrate_1;
    }

    @Override
    public void loadData() {
        ArrayList<String> savedData = SharePreferenceUtils.getAllFlowRateData(getActivity());
        if (savedData != null && savedData.size() == 3) {
            etQContent.setText(savedData.get(0));
            etRContent.setText(savedData.get(1));
            etVContent.setText(savedData.get(2));
        }
    }

    @Override
    public void saveData() {
        SharePreferenceUtils.saveAllFlowRateData(getActivity(), etQContent.getText().toString(),
                etRContent.getText().toString(), etVContent.getText().toString());
    }
}
