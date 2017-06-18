package winto.com.wintodata;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import winto.com.wintodata.utils.CommonUtils;
import winto.com.wintodata.utils.SharePreferenceUtils;
import winto.com.wintodata.widget.PopupConfirmDialog;

/**
 * Created by hkun2012 on 2017/5/29.
 */

public class DataCheckActivity extends BaseActivity {

    @BindView(R.id.title_number) TextView tvTitle;
    @BindView(R.id.flow_dot) EditText etFlowDot;
    @BindView(R.id.et_input_1_data_1) EditText etInput_1_start;
    @BindView(R.id.et_input_1_data_2) EditText etInput_1_end;
    @BindView(R.id.et_input_1_diff) EditText etInput_1_diff;
    @BindView(R.id.et_input_1_data_3) EditText etInput_1_standard;
    @BindView(R.id.et_input_1_result) EditText etInput_1_result;
    @BindView(R.id.rb_input_1_check) CheckBox rb_1_check;

    @BindView(R.id.et_input_2_data_1) EditText etInput_2_start;
    @BindView(R.id.et_input_2_data_2) EditText etInput_2_end;
    @BindView(R.id.et_input_2_diff) EditText etInput_2_diff;
    @BindView(R.id.et_input_2_data_3) EditText etInput_2_standard;
    @BindView(R.id.et_input_2_result) EditText etInput_2_result;
    @BindView(R.id.rb_input_2_check) CheckBox rb_2_check;

    @BindView(R.id.et_input_3_data_1) EditText etInput_3_start;
    @BindView(R.id.et_input_3_data_2) EditText etInput_3_end;
    @BindView(R.id.et_input_3_diff) EditText etInput_3_diff;
    @BindView(R.id.et_input_3_data_3) EditText etInput_3_standard;
    @BindView(R.id.et_input_3_result) EditText etInput_3_result;
    @BindView(R.id.rb_input_3_check) CheckBox rb_3_check;

    @BindView(R.id.et_input_4_data_1) EditText etInput_4_start;
    @BindView(R.id.et_input_4_data_2) EditText etInput_4_end;
    @BindView(R.id.et_input_4_diff) EditText etInput_4_diff;
    @BindView(R.id.et_input_4_data_3) EditText etInput_4_standard;
    @BindView(R.id.et_input_4_result) EditText etInput_4_result;
    @BindView(R.id.rb_input_4_check) CheckBox rb_4_check;

    @BindView(R.id.et_input_5_data_1) EditText etInput_5_start;
    @BindView(R.id.et_input_5_data_2) EditText etInput_5_end;
    @BindView(R.id.et_input_5_diff) EditText etInput_5_diff;
    @BindView(R.id.et_input_5_data_3) EditText etInput_5_standard;
    @BindView(R.id.et_input_5_result) EditText etInput_5_result;
    @BindView(R.id.rb_input_5_check) CheckBox rb_5_check;

    @BindView(R.id.et_input_6_data_1) EditText etInput_6_start;
    @BindView(R.id.et_input_6_data_2) EditText etInput_6_end;
    @BindView(R.id.et_input_6_diff) EditText etInput_6_diff;
    @BindView(R.id.et_input_6_data_3) EditText etInput_6_standard;
    @BindView(R.id.et_input_6_result) EditText etInput_6_result;
    @BindView(R.id.rb_input_6_check) CheckBox rb_6_check;

    @BindView(R.id.btn_calc) Button btnCalc;
    @BindView(R.id.btn_confirm) Button btnConfirm;
    @BindView(R.id.btn_reset) Button btnReset;
    @BindView(R.id.btn_screenshot) Button btnScreenShot;

    @OnClick(R.id.btn_screenshot)
    public void onClickScreenShot() {
        doScreenShot(this, btnScreenShot);
    }

    @Override
    protected View getScreenShotButton() {
        return btnScreenShot;
    }

    @OnClick(R.id.btn_reset)
    public void onClickReset() {
        etFlowDot.setText("");
        etInput_6_start.setText("");
        etInput_6_end.setText("");
        etInput_6_diff.setText("");
        etInput_6_standard.setText("");
        etInput_6_result.setText("");
        rb_6_check.setChecked(false);

        etInput_5_start.setText("");
        etInput_5_end.setText("");
        etInput_5_diff.setText("");
        etInput_5_standard.setText("");
        etInput_5_result.setText("");
        rb_5_check.setChecked(false);

        etInput_4_start.setText("");
        etInput_4_end.setText("");
        etInput_4_diff.setText("");
        etInput_4_standard.setText("");
        etInput_4_result.setText("");
        rb_4_check.setChecked(false);

        etInput_3_start.setText("");
        etInput_3_end.setText("");
        etInput_3_diff.setText("");
        etInput_3_standard.setText("");
        etInput_3_result.setText("");
        rb_3_check.setChecked(false);

        etInput_2_start.setText("");
        etInput_2_end.setText("");
        etInput_2_diff.setText("");
        etInput_2_standard.setText("");
        etInput_2_result.setText("");
        rb_2_check.setChecked(false);

        etInput_1_start.setText("");
        etInput_1_end.setText("");
        etInput_1_diff.setText("");
        etInput_1_standard.setText("");
        etInput_1_result.setText("");
        rb_1_check.setChecked(false);
    }

    @OnClick(R.id.btn_calc)
    public void onClickCalc() {
        if (isInputValid(etInput_1_start, etInput_1_end, etInput_1_standard)) {
            calcTheData(etInput_1_start, etInput_1_end, etInput_1_diff, etInput_1_standard, etInput_1_result);
        }

        if (isInputValid(etInput_2_start, etInput_2_end, etInput_2_standard)) {
            calcTheData(etInput_2_start, etInput_2_end, etInput_2_diff, etInput_2_standard, etInput_2_result);
        }

        if (isInputValid(etInput_3_start, etInput_3_end, etInput_3_standard)) {
            calcTheData(etInput_3_start, etInput_3_end, etInput_3_diff, etInput_3_standard, etInput_3_result);
        }

        if (isInputValid(etInput_4_start, etInput_4_end, etInput_4_standard)) {
            calcTheData(etInput_4_start, etInput_4_end, etInput_4_diff, etInput_4_standard, etInput_4_result);
        }

        if (isInputValid(etInput_5_start, etInput_5_end, etInput_5_standard)) {
            calcTheData(etInput_5_start, etInput_5_end, etInput_5_diff, etInput_5_standard, etInput_5_result);
        }

        if (isInputValid(etInput_6_start, etInput_6_end, etInput_6_standard)) {
            calcTheData(etInput_6_start, etInput_6_end, etInput_6_diff, etInput_6_standard, etInput_6_result);
        }
    }

    @OnClick(R.id.btn_confirm)
    public void onClickConfirm() {
        ArrayList<Integer> indexs = getValidDataList();
        Log.d("winto", "size: " + indexs.size());
        if (indexs.size() == 0) {
            Toast.makeText(DataCheckActivity.this, "请至少选取一组数据", Toast.LENGTH_LONG).show();
            return;
        }

        if (indexs.size() == 3) {
            ArrayList<Double> data = getDataByIndex(indexs);
            ThirdActivity.startThirdActivity(DataCheckActivity.this, data);
        } else {
            Toast.makeText(DataCheckActivity.this, "请选取三组数据", Toast.LENGTH_LONG).show();
        }

    }

    public Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what)  {
                case 1:

                    break;
                default:
                    break;
            }
        }
    };

    private long exitTime;

    @Override
    public View[] getAllEditText() {
        return new View[]{etInput_1_start, etInput_1_end, etInput_1_standard, etInput_1_diff, etInput_1_result,
                etInput_2_start, etInput_2_end, etInput_2_standard, etInput_2_diff, etInput_2_result,
                etInput_3_start, etInput_3_end, etInput_3_standard, etInput_3_diff, etInput_3_result,
                etInput_4_start, etInput_4_end, etInput_4_standard, etInput_4_diff, etInput_4_result,
                etInput_5_start, etInput_5_end, etInput_5_standard, etInput_5_diff, etInput_5_result,
                etInput_6_start, etInput_6_end, etInput_6_standard, etInput_6_diff, etInput_6_result,};
    }

    private ArrayList<Double> getDataByIndex(ArrayList<Integer> indexs) {
        ArrayList<Double> data = new ArrayList<>();
        double start, end, standard;
        for (int i : indexs) {
            switch (i) {
                case 1:
                    start = Double.valueOf(etInput_1_start.getText().toString());
                    end =  Double.valueOf(etInput_1_end.getText().toString());
                    standard =  Double.valueOf(etInput_1_standard.getText().toString());
                    data.add(end - start);
                    data.add(standard);
                    break;
                case 2:
                    start = Double.valueOf(etInput_2_start.getText().toString());
                    end =  Double.valueOf(etInput_2_end.getText().toString());
                    standard =  Double.valueOf(etInput_2_standard.getText().toString());
                    data.add(end - start);
                    data.add(standard);
                    break;
                case 3:
                    start = Double.valueOf(etInput_3_start.getText().toString());
                    end =  Double.valueOf(etInput_3_end.getText().toString());
                    standard =  Double.valueOf(etInput_3_standard.getText().toString());
                    data.add(end - start);
                    data.add(standard);
                    break;
                case 4:
                    start = Double.valueOf(etInput_4_start.getText().toString());
                    end =  Double.valueOf(etInput_4_end.getText().toString());
                    standard =  Double.valueOf(etInput_4_standard.getText().toString());
                    data.add(end - start);
                    data.add(standard);
                    break;
                case 5:
                    start = Double.valueOf(etInput_5_start.getText().toString());
                    end =  Double.valueOf(etInput_5_end.getText().toString());
                    standard =  Double.valueOf(etInput_5_standard.getText().toString());
                    data.add(end - start);
                    data.add(standard);
                    break;
                case 6:
                    start = Double.valueOf(etInput_6_start.getText().toString());
                    end =  Double.valueOf(etInput_6_end.getText().toString());
                    standard =  Double.valueOf(etInput_6_standard.getText().toString());
                    data.add(end - start);
                    data.add(standard);
                    break;
                default:
                    break;
            }
        }
        return data;
    }

    private ArrayList<Integer> getValidDataList() {
        ArrayList<Integer> result = new ArrayList<>();
        if (isResultValid(etInput_1_diff, etInput_1_standard, rb_1_check)) {
            result.add(1);
        }
        if (isResultValid(etInput_2_diff, etInput_2_standard, rb_2_check)) {
            result.add(2);
        }
        if (isResultValid(etInput_3_diff, etInput_3_standard, rb_3_check)) {
            result.add(3);
        }
        if (isResultValid(etInput_4_diff, etInput_4_standard, rb_4_check)) {
            result.add(4);
        }
        if (isResultValid(etInput_5_diff, etInput_5_standard, rb_5_check)) {
            result.add(5);
        }
        if (isResultValid(etInput_6_diff, etInput_6_standard, rb_6_check)) {
            result.add(6);
        }
        return result;
    }

    private boolean isResultValid(EditText et_1, EditText et_2, CheckBox rb) {
        if (et_1 != null && et_1.getText() != null &&
                et_1.getText().toString() != null &&
                !et_1.getText().toString().equals("") &&
                et_2 != null && et_2.getText() != null &&
                et_2.getText().toString() != null &&
                !et_2.getText().toString().equals("") &&
                rb.isChecked()) {
            return true;
        } else {
            return false;
        }
    }

    private void calcTheData(EditText etInput_start, EditText etInput_end, EditText etInput_diff, EditText etInput_standard, EditText etInput_result) {
        try {
            double start = Double.valueOf(etInput_start.getText().toString());
            double end = Double.valueOf(etInput_end.getText().toString());
            double standard = Double.valueOf(etInput_standard.getText().toString());

            double diff = end - start;
            double result = (end - start - standard) / standard;
            etInput_diff.setText(String.valueOf(diff));
            etInput_result.setText(CommonUtils.getFormatPercent(result));
        } catch (Exception e) {
            Toast.makeText(DataCheckActivity.this, "请检查输入!", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isInputValid(EditText... inputs) {
        if (inputs == null) {
            return false;
        }
        for (EditText et : inputs) {
            if (et != null && !et.getText().toString().equals("")) {
                try {
                    double data = Double.valueOf(et.getText().toString());
                } catch (Exception e) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_check);
        unbinder = ButterKnife.bind(this);

        initData();
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                showNumberInputDialog();
            }


        });
    }

    private void showNumberInputDialog() {
        PopupConfirmDialog.Builder builder = new PopupConfirmDialog.Builder(DataCheckActivity.this);
        builder.setCanceledOnTouchOutside(false)
                .setCanForceClose(false)
                .setHintText("请输入法兰编号: ")
                .setPositiveButton("确认", new PopupConfirmDialog.OnConfirmListener() {
                    @Override
                    public boolean onConfirm(String data) {
                        if (data.length() >= 5 && data.length() <= 9) {
                            // // TODO: 2017/6/18
                            if (tvTitle != null) {
                                tvTitle.setText(data);
                                return true;
                            } else {
                                Toast.makeText(DataCheckActivity.this, "系统异常，请稍后再试", Toast.LENGTH_LONG).show();
                                finish();
                                return false;
                            }
                        } else {
                            Toast.makeText(DataCheckActivity.this, "法兰编号的长度应为5-9", Toast.LENGTH_LONG).show();
                            return false;
                        }
                    }
                })
                .setNegtiveButton("取消", new PopupConfirmDialog.OnConfirmListener() {
                    @Override
                    public boolean onConfirm(String data) {
                        try {
                            finish();
                            return true;
                        } catch (Exception e) {
                            return false;
                        }
                    }
                })
                .setNotPassword()
                .setKeyDisable(true)
                .createView()
                .show();
    }

    private void initData() {
        ArrayList<String> data = SharePreferenceUtils.getAllDataCheckData(DataCheckActivity.this);
        if (data.size() >= 5) {
            int base = 0;
            etInput_1_start.setText(data.get(base));
            etInput_1_end.setText(data.get(base + 1));
            etInput_1_standard.setText(data.get(base + 2));
            etInput_1_diff.setText(data.get(base + 3));
            etInput_1_result.setText(data.get(base + 4));
        }

        if (data.size() >= 10) {
            int base = 5;
            etInput_2_start.setText(data.get(base));
            etInput_2_end.setText(data.get(base + 1));
            etInput_2_standard.setText(data.get(base + 2));
            etInput_2_diff.setText(data.get(base + 3));
            etInput_2_result.setText(data.get(base + 4));
        }

        if (data.size() >= 15) {
            int base = 10;
            etInput_3_start.setText(data.get(base));
            etInput_3_end.setText(data.get(base + 1));
            etInput_3_standard.setText(data.get(base + 2));
            etInput_3_diff.setText(data.get(base + 3));
            etInput_3_result.setText(data.get(base + 4));
        }

        if (data.size() >= 20) {
            int base = 15;
            etInput_4_start.setText(data.get(base));
            etInput_4_end.setText(data.get(base + 1));
            etInput_4_standard.setText(data.get(base + 2));
            etInput_4_diff.setText(data.get(base + 3));
            etInput_4_result.setText(data.get(base + 4));
        }

        if (data.size() >= 25) {
            int base = 20;
            etInput_5_start.setText(data.get(base));
            etInput_5_end.setText(data.get(base + 1));
            etInput_5_standard.setText(data.get(base + 2));
            etInput_5_diff.setText(data.get(base + 3));
            etInput_5_result.setText(data.get(base + 4));
        }

        if (data.size() >= 30) {
            int base = 25;
            etInput_6_start.setText(data.get(base));
            etInput_6_end.setText(data.get(base + 1));
            etInput_6_standard.setText(data.get(base + 2));
            etInput_6_diff.setText(data.get(base + 3));
            etInput_6_result.setText(data.get(base + 4));
        }

        if (data.size() >= 31) {
            etFlowDot.setText(data.get(30));
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveAllData();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出本页面", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
                return true;
            } else {
                finish();
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    private void saveAllData() {
        ArrayList<String> data = new ArrayList<>();
        if (!etInput_1_diff.getText().toString().equals("") && !etInput_1_result.getText().toString().equals("")) {
            data.add(etInput_1_start.getText().toString());
            data.add(etInput_1_end.getText().toString());
            data.add(etInput_1_standard.getText().toString());
            data.add(etInput_1_diff.getText().toString());
            data.add(etInput_1_result.getText().toString());
        }

        if (!etInput_2_diff.getText().toString().equals("") && !etInput_2_result.getText().toString().equals("")) {
            data.add(etInput_2_start.getText().toString());
            data.add(etInput_2_end.getText().toString());
            data.add(etInput_2_standard.getText().toString());
            data.add(etInput_2_diff.getText().toString());
            data.add(etInput_2_result.getText().toString());
        }

        if (!etInput_3_diff.getText().toString().equals("") && !etInput_3_result.getText().toString().equals("")) {
            data.add(etInput_3_start.getText().toString());
            data.add(etInput_3_end.getText().toString());
            data.add(etInput_3_standard.getText().toString());
            data.add(etInput_3_diff.getText().toString());
            data.add(etInput_3_result.getText().toString());
        }

        if (!etInput_4_diff.getText().toString().equals("") && !etInput_4_result.getText().toString().equals("")) {
            data.add(etInput_4_start.getText().toString());
            data.add(etInput_4_end.getText().toString());
            data.add(etInput_4_standard.getText().toString());
            data.add(etInput_4_diff.getText().toString());
            data.add(etInput_4_result.getText().toString());
        }

        if (!etInput_5_diff.getText().toString().equals("") && !etInput_5_result.getText().toString().equals("")) {
            data.add(etInput_5_start.getText().toString());
            data.add(etInput_5_end.getText().toString());
            data.add(etInput_5_standard.getText().toString());
            data.add(etInput_5_diff.getText().toString());
            data.add(etInput_5_result.getText().toString());
        }

        if (!etInput_6_diff.getText().toString().equals("") && !etInput_6_result.getText().toString().equals("")) {
            data.add(etInput_6_start.getText().toString());
            data.add(etInput_6_end.getText().toString());
            data.add(etInput_6_standard.getText().toString());
            data.add(etInput_6_diff.getText().toString());
            data.add(etInput_6_result.getText().toString());
        }

        if (!etFlowDot.getText().toString().equals("")) {
            data.add(etFlowDot.getText().toString());
        }

        SharePreferenceUtils.saveAllDataCheckData(DataCheckActivity.this, data);
    }
}
