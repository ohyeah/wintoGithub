package winto.com.wintodata.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;

/**
 * Created by hkun2012 on 2017/5/31.
 */

public class SharePreferenceUtils {
    public static final String FILE_FLOW_RATE = "file_flowrate";

    public static final String FLOW_RATE_INPUT_1_DATA_1 = "flow_rate_input_1_data_1";
    public static final String FLOW_RATE_INPUT_1_DATA_2 = "flow_rate_input_1_data_2";
    public static final String FLOW_RATE_INPUT_1_DATA_3 = "flow_rate_input_1_data_3";
    public static final String FLOW_RATE_INPUT_1_DIFF = "flow_rate_input_1_diff";
    public static final String FLOW_RATE_INPUT_1_RESULT = "flow_rate_input_1_result";

    public static final String FLOW_RATE_INPUT_2_DATA_1 = "flow_rate_input_2_data_1";
    public static final String FLOW_RATE_INPUT_2_DATA_2 = "flow_rate_input_2_data_2";
    public static final String FLOW_RATE_INPUT_2_DATA_3 = "flow_rate_input_2_data_3";
    public static final String FLOW_RATE_INPUT_2_DIFF = "flow_rate_input_2_diff";
    public static final String FLOW_RATE_INPUT_2_RESULT = "flow_rate_input_2_result";

    public static final String FLOW_RATE_INPUT_3_DATA_1 = "flow_rate_input_3_data_1";
    public static final String FLOW_RATE_INPUT_3_DATA_2 = "flow_rate_input_3_data_2";
    public static final String FLOW_RATE_INPUT_3_DATA_3 = "flow_rate_input_3_data_3";
    public static final String FLOW_RATE_INPUT_3_DIFF = "flow_rate_input_3_diff";
    public static final String FLOW_RATE_INPUT_3_RESULT = "flow_rate_input_3_result";

    public static final String FLOW_RATE_INPUT_4_DATA_1 = "flow_rate_input_4_data_1";
    public static final String FLOW_RATE_INPUT_4_DATA_2 = "flow_rate_input_4_data_2";
    public static final String FLOW_RATE_INPUT_4_DATA_3 = "flow_rate_input_4_data_3";
    public static final String FLOW_RATE_INPUT_4_DIFF = "flow_rate_input_4_diff";
    public static final String FLOW_RATE_INPUT_4_RESULT = "flow_rate_input_4_result";

    public static final String FLOW_RATE_INPUT_5_DATA_1 = "flow_rate_input_5_data_1";
    public static final String FLOW_RATE_INPUT_5_DATA_2 = "flow_rate_input_5_data_2";
    public static final String FLOW_RATE_INPUT_5_DATA_3 = "flow_rate_input_5_data_3";
    public static final String FLOW_RATE_INPUT_5_DIFF = "flow_rate_input_5_diff";
    public static final String FLOW_RATE_INPUT_5_RESULT = "flow_rate_input_5_result";

    public static final String FLOW_RATE_INPUT_6_DATA_1 = "flow_rate_input_6_data_1";
    public static final String FLOW_RATE_INPUT_6_DATA_2 = "flow_rate_input_6_data_2";
    public static final String FLOW_RATE_INPUT_6_DATA_3 = "flow_rate_input_6_data_3";
    public static final String FLOW_RATE_INPUT_6_DIFF = "flow_rate_input_6_diff";
    public static final String FLOW_RATE_INPUT_6_RESULT = "flow_rate_input_6_result";

    public static void saveAllFlowData(final Context context, final ArrayList<String> dataList) {
        SharedPreferences.Editor editor = context.getSharedPreferences(FILE_FLOW_RATE, Context.MODE_PRIVATE).edit();
        editor.clear();
        if (dataList != null && dataList.size() >= 5) {
            int base = 0;
            editor.putString(FLOW_RATE_INPUT_1_DATA_1, dataList.get(base))
                    .putString(FLOW_RATE_INPUT_1_DATA_2, dataList.get(base + 1))
                    .putString(FLOW_RATE_INPUT_1_DATA_3, dataList.get(base + 2))
                    .putString(FLOW_RATE_INPUT_1_DIFF, dataList.get(base + 3))
                    .putString(FLOW_RATE_INPUT_1_RESULT, dataList.get(base + 4));
        }

        if (dataList != null && dataList.size() >= 10) {
            int base = 5;
            editor.putString(FLOW_RATE_INPUT_2_DATA_1, dataList.get(base))
                    .putString(FLOW_RATE_INPUT_2_DATA_2, dataList.get(base + 1))
                    .putString(FLOW_RATE_INPUT_2_DATA_3, dataList.get(base + 2))
                    .putString(FLOW_RATE_INPUT_2_DIFF, dataList.get(base + 3))
                    .putString(FLOW_RATE_INPUT_2_RESULT, dataList.get(base + 4));
        }

        if (dataList != null && dataList.size() >= 15) {
            int base = 10;
            editor.putString(FLOW_RATE_INPUT_3_DATA_1, dataList.get(base))
                    .putString(FLOW_RATE_INPUT_3_DATA_2, dataList.get(base + 1))
                    .putString(FLOW_RATE_INPUT_3_DATA_3, dataList.get(base + 2))
                    .putString(FLOW_RATE_INPUT_3_DIFF, dataList.get(base + 3))
                    .putString(FLOW_RATE_INPUT_3_RESULT, dataList.get(base + 4));
        }

        if (dataList != null && dataList.size() >= 20) {
            int base = 15;
            editor.putString(FLOW_RATE_INPUT_4_DATA_1, dataList.get(base))
                    .putString(FLOW_RATE_INPUT_4_DATA_2, dataList.get(base + 1))
                    .putString(FLOW_RATE_INPUT_4_DATA_3, dataList.get(base + 2))
                    .putString(FLOW_RATE_INPUT_4_DIFF, dataList.get(base + 3))
                    .putString(FLOW_RATE_INPUT_4_RESULT, dataList.get(base + 4));
        }

        if (dataList != null && dataList.size() >= 25) {
            int base = 20;
            editor.putString(FLOW_RATE_INPUT_5_DATA_1, dataList.get(base))
                    .putString(FLOW_RATE_INPUT_5_DATA_2, dataList.get(base + 1))
                    .putString(FLOW_RATE_INPUT_5_DATA_3, dataList.get(base + 2))
                    .putString(FLOW_RATE_INPUT_5_DIFF, dataList.get(base + 3))
                    .putString(FLOW_RATE_INPUT_5_RESULT, dataList.get(base + 4));
        }

        if (dataList != null && dataList.size() >= 30) {
            int base = 25;
            editor.putString(FLOW_RATE_INPUT_6_DATA_1, dataList.get(base))
                    .putString(FLOW_RATE_INPUT_6_DATA_2, dataList.get(base + 1))
                    .putString(FLOW_RATE_INPUT_6_DATA_3, dataList.get(base + 2))
                    .putString(FLOW_RATE_INPUT_6_DIFF, dataList.get(base + 3))
                    .putString(FLOW_RATE_INPUT_6_RESULT, dataList.get(base + 4));
        }
        editor.apply();
    }

    public static ArrayList<String> getAllFlowData(final Context context) {
        SharedPreferences preferences = context.getSharedPreferences(FILE_FLOW_RATE, Context.MODE_PRIVATE);
        ArrayList<String> retData = new ArrayList<>();
        if (preferences != null) {
            if (!preferences.getString(FLOW_RATE_INPUT_1_DATA_1, "").equals("")) {
                retData.add(preferences.getString(FLOW_RATE_INPUT_1_DATA_1, ""));
                retData.add(preferences.getString(FLOW_RATE_INPUT_1_DATA_2, ""));
                retData.add(preferences.getString(FLOW_RATE_INPUT_1_DATA_3, ""));
                retData.add(preferences.getString(FLOW_RATE_INPUT_1_DIFF, ""));
                retData.add(preferences.getString(FLOW_RATE_INPUT_1_RESULT, ""));
            }

            if (!preferences.getString(FLOW_RATE_INPUT_2_DATA_1, "").equals("")) {
                retData.add(preferences.getString(FLOW_RATE_INPUT_2_DATA_1, ""));
                retData.add(preferences.getString(FLOW_RATE_INPUT_2_DATA_2, ""));
                retData.add(preferences.getString(FLOW_RATE_INPUT_2_DATA_3, ""));
                retData.add(preferences.getString(FLOW_RATE_INPUT_2_DIFF, ""));
                retData.add(preferences.getString(FLOW_RATE_INPUT_2_RESULT, ""));
            }

            if (!preferences.getString(FLOW_RATE_INPUT_3_DATA_1, "").equals("")) {
                retData.add(preferences.getString(FLOW_RATE_INPUT_3_DATA_1, ""));
                retData.add(preferences.getString(FLOW_RATE_INPUT_3_DATA_2, ""));
                retData.add(preferences.getString(FLOW_RATE_INPUT_3_DATA_3, ""));
                retData.add(preferences.getString(FLOW_RATE_INPUT_3_DIFF, ""));
                retData.add(preferences.getString(FLOW_RATE_INPUT_3_RESULT, ""));
            }

            if (!preferences.getString(FLOW_RATE_INPUT_4_DATA_1, "").equals("")) {
                retData.add(preferences.getString(FLOW_RATE_INPUT_4_DATA_1, ""));
                retData.add(preferences.getString(FLOW_RATE_INPUT_4_DATA_2, ""));
                retData.add(preferences.getString(FLOW_RATE_INPUT_4_DATA_3, ""));
                retData.add(preferences.getString(FLOW_RATE_INPUT_4_DIFF, ""));
                retData.add(preferences.getString(FLOW_RATE_INPUT_4_RESULT, ""));
            }

            if (!preferences.getString(FLOW_RATE_INPUT_5_DATA_1, "").equals("")) {
                retData.add(preferences.getString(FLOW_RATE_INPUT_5_DATA_1, ""));
                retData.add(preferences.getString(FLOW_RATE_INPUT_5_DATA_2, ""));
                retData.add(preferences.getString(FLOW_RATE_INPUT_5_DATA_3, ""));
                retData.add(preferences.getString(FLOW_RATE_INPUT_5_DIFF, ""));
                retData.add(preferences.getString(FLOW_RATE_INPUT_5_RESULT, ""));
            }

            if (!preferences.getString(FLOW_RATE_INPUT_6_DATA_1, "").equals("")) {
                retData.add(preferences.getString(FLOW_RATE_INPUT_6_DATA_1, ""));
                retData.add(preferences.getString(FLOW_RATE_INPUT_6_DATA_2, ""));
                retData.add(preferences.getString(FLOW_RATE_INPUT_6_DATA_3, ""));
                retData.add(preferences.getString(FLOW_RATE_INPUT_6_DIFF, ""));
                retData.add(preferences.getString(FLOW_RATE_INPUT_6_RESULT, ""));
            }

            return retData;
        } else{
            return  retData;
        }
    }
}
