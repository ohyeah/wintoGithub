package winto.com.wintodata;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hkun2012 on 2017/5/30.
 */

public class DataQueryActivity extends BaseActivity {

    private ArrayAdapter<String> mQueryAdapter;

    @BindView(R.id.spinner_query)
    Spinner spinnerQuery;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_data_query);
        unbinder = ButterKnife.bind(this);

        String[] queryStrings = {"DN50", "DN65", "DN80", "DN100", "DN125", "DN150", "DN200", "DN250", "DN300"};
        mQueryAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, queryStrings);
        mQueryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerQuery.setAdapter(mQueryAdapter);
        spinnerQuery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
