package winto.com.wintodata;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hkun2012 on 2017/5/30.
 */

public class DataQueryActivity extends BaseActivity {

    private ArrayAdapter<String> mQueryAdapter;

    @BindView(R.id.spinner_query)
    Spinner spinnerQuery;
    @BindView(R.id.et_data_1) EditText etData_1;
    @BindView(R.id.et_data_2) EditText etData_2;
    @BindView(R.id.et_data_3) EditText etData_3;
    @BindView(R.id.et_data_4) EditText etData_4;
    @BindView(R.id.et_data_5) EditText etData_5;
    @BindView(R.id.et_data_6) EditText etData_6;
    @BindView(R.id.et_data_7) EditText etData_7;
    @BindView(R.id.et_data_8) EditText etData_8;
    @BindView(R.id.et_data_9) EditText etData_9;
    @BindView(R.id.et_data_10) EditText etData_10;

    public static final String DN25 = "DN25";
    public static final String DN50 = "DN50";
    public static final String DN65 = "DN65";
    public static final String DN80 = "DN80";
    public static final String DN100 = "DN100";
    public static final String DN125 = "DN125";
    public static final String DN150 = "DN150";
    public static final String DN200 = "DN200";
    public static final String DN250 = "DN250";
    public static final String DN300 = "DN300";

    public static HashMap<String, List<String>> data = new HashMap<>();
    static {
        data.put(DN25, Arrays.asList("16", "2.65", "0.53", "0.353", "0.246", "0.177", "0.088", "0.0625", "0.039", "0.039"));
        data.put(DN50, Arrays.asList("100", "10.6", "2.12", "1.413", "0.982", "0.707", "0.353", "0.4", "0.25", "0.156"));
        data.put(DN65, Arrays.asList("100", "17.91", "3.582", "2.388", "1.66", "1.194", "0.597", "0.4", "0.25", "0.264"));
        data.put(DN80, Arrays.asList("160", "27.12", "5.426", "3.617", "2.514", "1.809", "0.904", "0.64", "0.4", "0.4"));
        data.put(DN100, Arrays.asList("250", "42.39", "8.478", "5.652", "3.928", "2.826", "1.413", "1", "0.625", "0.625"));
        data.put(DN125, Arrays.asList("400", "66.23", "13.247", "8.831", "6.138", "4.416", "2.208", "1.6", "1", "0.977"));
        data.put(DN150, Arrays.asList("630", "95.38", "19.076", "12.717", "8.838", "6.359", "3.179", "2.52", "1.575", "1.406"));
        data.put(DN200, Arrays.asList("1000", "169.56", "33.912", "22.608", "15.713", "11.304", "5.652", "4", "2.5", "2.5"));
        data.put(DN250, Arrays.asList("1600", "264.94", "53.988", "35.325", "24.55", "17.663", "8.831", "6.4", "4", "3.906"));
        data.put(DN300, Arrays.asList("1600", "381.51", "76.302", "50.868", "36.353", "25.434", "12.717", "6.4", "4", "5.625"));
    }



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_data_query);
        unbinder = ButterKnife.bind(this);

        final String[] queryStrings = {"DN25", "DN50", "DN65", "DN80", "DN100", "DN125", "DN150", "DN200", "DN250", "DN300"};
        mQueryAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, queryStrings);
        mQueryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerQuery.setAdapter(mQueryAdapter);
        spinnerQuery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String key = queryStrings[position];
                showData(data.get(key));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void showData(final List<String> data) {
        etData_1.setText(data.get(0));
        etData_2.setText(data.get(1));
        etData_3.setText(data.get(2));
        etData_4.setText(data.get(3));
        etData_5.setText(data.get(4));
        etData_6.setText(data.get(5));
        etData_7.setText(data.get(6));
        etData_8.setText(data.get(7));
        etData_9.setText(data.get(8));
        etData_10.setText(data.get(9));
    }
}
