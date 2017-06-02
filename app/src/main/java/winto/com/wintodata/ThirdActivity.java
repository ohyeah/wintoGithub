package winto.com.wintodata;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import winto.com.wintodata.utils.CommonUtils;

/**
 * Created by hkun2012 on 2017/5/30.
 */

public class ThirdActivity extends BaseActivity {
    public static final String DATA_1 = "data_1";
    public static final String DATA_2 = "data_2";
    public static final String DATA_3 = "data_3";
    public static final String STANDARD_1 = "standard_1";
    public static final String STANDARD_2 = "standard_2";
    public static final String STANDARD_3 = "standard_1";

    private double data_1, data_2, data_3, standard_1, standard_2, standard_3;

    @BindView(R.id.time) EditText etTime;
    @BindView(R.id.size) EditText etSize;
    @BindView(R.id.et_data_1) EditText etData_1;
    @BindView(R.id.et_data_2) EditText etData_2;
    @BindView(R.id.et_data_3) EditText etData_3;
    @BindView(R.id.et_standard_1) EditText etStandard_1;
    @BindView(R.id.et_standard_2) EditText etStandard_2;
    @BindView(R.id.et_standard_3) EditText etStandard_3;
    @BindView(R.id.et_average_data) EditText etAverageData;
    @BindView(R.id.et_average_standard) EditText etAverageStandard;
    @BindView(R.id.et_last_data) EditText etLastData;
    @BindView(R.id.et_last_standard) EditText etLastStandard;

    @OnClick(R.id.btn_calc)
    public void onClickCalc() {
        if (etTime != null && etTime.getText() != null && etTime.getText().toString() != null &&
                etSize != null && etSize.getText() != null && etSize.getText().toString() != null) {
            try {
                double time = Double.valueOf(etTime.getText().toString());
                double size = Double.valueOf(etSize.getText().toString());

                double data_average = (data_1 + data_2 + data_3) / 3 * (3600 / time) / 1000;
                double standard_average = (standard_1 + standard_2 + standard_3) / 3 * (3600 / time) / 1000;
                double last_data = data_average * 4 / 0.001 / 0.001 / 3600 / 3.14 / size / size;
                double last_standard = standard_average * 4 / 0.001 / 0.001 / 3600 / 3.14 / size / size;

                etAverageData.setText(CommonUtils.ThirdActivityGetFormatData(data_average, 4));
                etAverageStandard.setText(CommonUtils.ThirdActivityGetFormatData(standard_average, 4));
                etLastData.setText(CommonUtils.ThirdActivityGetFormatData(last_data, 5));
                etLastStandard.setText(CommonUtils.ThirdActivityGetFormatData(last_standard, 5));
            } catch (Exception e) {

            }
        } else {
            Toast.makeText(getApplicationContext(), "请输入[校表时间]和[被校口径]!", Toast.LENGTH_LONG).show();
        }
    }

    public static void startThirdActivity(final Context context, final ArrayList<Double> data) {
        if (context == null || data == null || data.size() != 6) {
            return;
        }

        Intent intent = new Intent(context, ThirdActivity.class);
        intent.putExtra(DATA_1, data.get(0));
        intent.putExtra(STANDARD_1, data.get(1));
        intent.putExtra(DATA_2, data.get(2));
        intent.putExtra(STANDARD_2, data.get(3));
        intent.putExtra(DATA_3, data.get(4));
        intent.putExtra(STANDARD_3, data.get(5));
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        try {
            data_1 = intent.getDoubleExtra(DATA_1, 0);
            data_2 = intent.getDoubleExtra(DATA_2, 0);
            data_3 = intent.getDoubleExtra(DATA_3, 0);
            standard_1 = intent.getDoubleExtra(STANDARD_1, 0);
            standard_2 = intent.getDoubleExtra(STANDARD_2, 0);
            standard_3 = intent.getDoubleExtra(STANDARD_3, 0);
        } catch (Exception e) {
            Log.d("winto", Log.getStackTraceString(e));
            Toast.makeText(getApplicationContext(), "数据异常，请重试", Toast.LENGTH_SHORT).show();
            return;
        }

        setContentView(R.layout.activity_third);
        unbinder = ButterKnife.bind(this);

        initDataView();
    }

    private void initDataView() {
        etData_1.setText(String.valueOf(data_1));
        etData_2.setText(String.valueOf(data_2));
        etData_3.setText(String.valueOf(data_3));
        etStandard_1.setText(String.valueOf(standard_1));
        etStandard_2.setText(String.valueOf(standard_2));
        etStandard_3.setText(String.valueOf(standard_3));
    }

}
