package winto.com.wintodata.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;

/**
 * Created by hkun2012 on 2017/5/31.
 */

public class SharePreferenceUtils {
    public static final String FILE_DATA_CHECK = "file_datacheck";

    public static final String DATA_CHECK_FLOW_DOT = "data_check_flow_dot";
    public static final String DATA_CHECK_INPUT_1_DATA_1 = "data_check_input_1_data_1";
    public static final String DATA_CHECK_INPUT_1_DATA_2 = "data_check_input_1_data_2";
    public static final String DATA_CHECK_INPUT_1_DATA_3 = "data_check_input_1_data_3";
    public static final String DATA_CHECK_INPUT_1_DIFF = "data_check_input_1_diff";
    public static final String DATA_CHECK_INPUT_1_RESULT = "data_check_input_1_result";

    public static final String DATA_CHECK_INPUT_2_DATA_1 = "data_check_input_2_data_1";
    public static final String DATA_CHECK_INPUT_2_DATA_2 = "data_check_input_2_data_2";
    public static final String DATA_CHECK_INPUT_2_DATA_3 = "data_check_input_2_data_3";
    public static final String DATA_CHECK_INPUT_2_DIFF = "data_check_input_2_diff";
    public static final String DATA_CHECK_INPUT_2_RESULT = "data_check_input_2_result";

    public static final String DATA_CHECK_INPUT_3_DATA_1 = "data_check_input_3_data_1";
    public static final String DATA_CHECK_INPUT_3_DATA_2 = "data_check_input_3_data_2";
    public static final String DATA_CHECK_INPUT_3_DATA_3 = "data_check_input_3_data_3";
    public static final String DATA_CHECK_INPUT_3_DIFF = "data_check_input_3_diff";
    public static final String DATA_CHECK_INPUT_3_RESULT = "data_check_input_3_result";

    public static final String DATA_CHECK_INPUT_4_DATA_1 = "data_check_input_4_data_1";
    public static final String DATA_CHECK_INPUT_4_DATA_2 = "data_check_input_4_data_2";
    public static final String DATA_CHECK_INPUT_4_DATA_3 = "data_check_input_4_data_3";
    public static final String DATA_CHECK_INPUT_4_DIFF = "data_check_input_4_diff";
    public static final String DATA_CHECK_INPUT_4_RESULT = "data_check_input_4_result";

    public static final String DATA_CHECK_INPUT_5_DATA_1 = "data_check_input_5_data_1";
    public static final String DATA_CHECK_INPUT_5_DATA_2 = "data_check_input_5_data_2";
    public static final String DATA_CHECK_INPUT_5_DATA_3 = "data_check_input_5_data_3";
    public static final String DATA_CHECK_INPUT_5_DIFF = "data_check_input_5_diff";
    public static final String DATA_CHECK_INPUT_5_RESULT = "data_check_input_5_result";

    public static final String DATA_CHECK_INPUT_6_DATA_1 = "data_check_input_6_data_1";
    public static final String DATA_CHECK_INPUT_6_DATA_2 = "data_check_input_6_data_2";
    public static final String DATA_CHECK_INPUT_6_DATA_3 = "data_check_input_6_data_3";
    public static final String DATA_CHECK_INPUT_6_DIFF = "data_check_input_6_diff";
    public static final String DATA_CHECK_INPUT_6_RESULT = "data_check_input_6_result";

    public static void saveAllDataCheckData(final Context context, final ArrayList<String> dataList) {
        SharedPreferences.Editor editor = context.getSharedPreferences(FILE_DATA_CHECK, Context.MODE_PRIVATE).edit();
        editor.clear();
        if (dataList != null && dataList.size() >= 5) {
            int base = 0;
            editor.putString(DATA_CHECK_INPUT_1_DATA_1, dataList.get(base))
                    .putString(DATA_CHECK_INPUT_1_DATA_2, dataList.get(base + 1))
                    .putString(DATA_CHECK_INPUT_1_DATA_3, dataList.get(base + 2))
                    .putString(DATA_CHECK_INPUT_1_DIFF, dataList.get(base + 3))
                    .putString(DATA_CHECK_INPUT_1_RESULT, dataList.get(base + 4));
        }

        if (dataList != null && dataList.size() >= 10) {
            int base = 5;
            editor.putString(DATA_CHECK_INPUT_2_DATA_1, dataList.get(base))
                    .putString(DATA_CHECK_INPUT_2_DATA_2, dataList.get(base + 1))
                    .putString(DATA_CHECK_INPUT_2_DATA_3, dataList.get(base + 2))
                    .putString(DATA_CHECK_INPUT_2_DIFF, dataList.get(base + 3))
                    .putString(DATA_CHECK_INPUT_2_RESULT, dataList.get(base + 4));
        }

        if (dataList != null && dataList.size() >= 15) {
            int base = 10;
            editor.putString(DATA_CHECK_INPUT_3_DATA_1, dataList.get(base))
                    .putString(DATA_CHECK_INPUT_3_DATA_2, dataList.get(base + 1))
                    .putString(DATA_CHECK_INPUT_3_DATA_3, dataList.get(base + 2))
                    .putString(DATA_CHECK_INPUT_3_DIFF, dataList.get(base + 3))
                    .putString(DATA_CHECK_INPUT_3_RESULT, dataList.get(base + 4));
        }

        if (dataList != null && dataList.size() >= 20) {
            int base = 15;
            editor.putString(DATA_CHECK_INPUT_4_DATA_1, dataList.get(base))
                    .putString(DATA_CHECK_INPUT_4_DATA_2, dataList.get(base + 1))
                    .putString(DATA_CHECK_INPUT_4_DATA_3, dataList.get(base + 2))
                    .putString(DATA_CHECK_INPUT_4_DIFF, dataList.get(base + 3))
                    .putString(DATA_CHECK_INPUT_4_RESULT, dataList.get(base + 4));
        }

        if (dataList != null && dataList.size() >= 25) {
            int base = 20;
            editor.putString(DATA_CHECK_INPUT_5_DATA_1, dataList.get(base))
                    .putString(DATA_CHECK_INPUT_5_DATA_2, dataList.get(base + 1))
                    .putString(DATA_CHECK_INPUT_5_DATA_3, dataList.get(base + 2))
                    .putString(DATA_CHECK_INPUT_5_DIFF, dataList.get(base + 3))
                    .putString(DATA_CHECK_INPUT_5_RESULT, dataList.get(base + 4));
        }

        if (dataList != null && dataList.size() >= 30) {
            int base = 25;
            editor.putString(DATA_CHECK_INPUT_6_DATA_1, dataList.get(base))
                    .putString(DATA_CHECK_INPUT_6_DATA_2, dataList.get(base + 1))
                    .putString(DATA_CHECK_INPUT_6_DATA_3, dataList.get(base + 2))
                    .putString(DATA_CHECK_INPUT_6_DIFF, dataList.get(base + 3))
                    .putString(DATA_CHECK_INPUT_6_RESULT, dataList.get(base + 4));
        }

        if (dataList != null && dataList.size() >= 31) {
            editor.putString(DATA_CHECK_FLOW_DOT, dataList.get(30));
        }
        editor.apply();
    }

    public static ArrayList<String> getAllDataCheckData(final Context context) {
        SharedPreferences preferences = context.getSharedPreferences(FILE_DATA_CHECK, Context.MODE_PRIVATE);
        ArrayList<String> retData = new ArrayList<>();
        if (preferences != null) {
            if (!preferences.getString(DATA_CHECK_INPUT_1_DATA_1, "").equals("")) {
                retData.add(preferences.getString(DATA_CHECK_INPUT_1_DATA_1, ""));
                retData.add(preferences.getString(DATA_CHECK_INPUT_1_DATA_2, ""));
                retData.add(preferences.getString(DATA_CHECK_INPUT_1_DATA_3, ""));
                retData.add(preferences.getString(DATA_CHECK_INPUT_1_DIFF, ""));
                retData.add(preferences.getString(DATA_CHECK_INPUT_1_RESULT, ""));
            }

            if (!preferences.getString(DATA_CHECK_INPUT_2_DATA_1, "").equals("")) {
                retData.add(preferences.getString(DATA_CHECK_INPUT_2_DATA_1, ""));
                retData.add(preferences.getString(DATA_CHECK_INPUT_2_DATA_2, ""));
                retData.add(preferences.getString(DATA_CHECK_INPUT_2_DATA_3, ""));
                retData.add(preferences.getString(DATA_CHECK_INPUT_2_DIFF, ""));
                retData.add(preferences.getString(DATA_CHECK_INPUT_2_RESULT, ""));
            }

            if (!preferences.getString(DATA_CHECK_INPUT_3_DATA_1, "").equals("")) {
                retData.add(preferences.getString(DATA_CHECK_INPUT_3_DATA_1, ""));
                retData.add(preferences.getString(DATA_CHECK_INPUT_3_DATA_2, ""));
                retData.add(preferences.getString(DATA_CHECK_INPUT_3_DATA_3, ""));
                retData.add(preferences.getString(DATA_CHECK_INPUT_3_DIFF, ""));
                retData.add(preferences.getString(DATA_CHECK_INPUT_3_RESULT, ""));
            }

            if (!preferences.getString(DATA_CHECK_INPUT_4_DATA_1, "").equals("")) {
                retData.add(preferences.getString(DATA_CHECK_INPUT_4_DATA_1, ""));
                retData.add(preferences.getString(DATA_CHECK_INPUT_4_DATA_2, ""));
                retData.add(preferences.getString(DATA_CHECK_INPUT_4_DATA_3, ""));
                retData.add(preferences.getString(DATA_CHECK_INPUT_4_DIFF, ""));
                retData.add(preferences.getString(DATA_CHECK_INPUT_4_RESULT, ""));
            }

            if (!preferences.getString(DATA_CHECK_INPUT_5_DATA_1, "").equals("")) {
                retData.add(preferences.getString(DATA_CHECK_INPUT_5_DATA_1, ""));
                retData.add(preferences.getString(DATA_CHECK_INPUT_5_DATA_2, ""));
                retData.add(preferences.getString(DATA_CHECK_INPUT_5_DATA_3, ""));
                retData.add(preferences.getString(DATA_CHECK_INPUT_5_DIFF, ""));
                retData.add(preferences.getString(DATA_CHECK_INPUT_5_RESULT, ""));
            }

            if (!preferences.getString(DATA_CHECK_INPUT_6_DATA_1, "").equals("")) {
                retData.add(preferences.getString(DATA_CHECK_INPUT_6_DATA_1, ""));
                retData.add(preferences.getString(DATA_CHECK_INPUT_6_DATA_2, ""));
                retData.add(preferences.getString(DATA_CHECK_INPUT_6_DATA_3, ""));
                retData.add(preferences.getString(DATA_CHECK_INPUT_6_DIFF, ""));
                retData.add(preferences.getString(DATA_CHECK_INPUT_6_RESULT, ""));
            }

            if (!preferences.getString(DATA_CHECK_FLOW_DOT, "").equals("")) {
                retData.add(preferences.getString(DATA_CHECK_FLOW_DOT, ""));
            }

            return retData;
        } else{
            return  retData;
        }
    }

    
    public static final String FILE_FLOW_RATE = "file_flowrate";
    public static final String FLOW_RATE_Q_KEY = "flow_rate_q_key";
    public static final String FLOW_RATE_R_KEY = "flow_rate_r_key";
    public static final String FLOW_RATE_V_KEY = "flow_rate_v_key";
    public static void saveAllFlowRateData(final Context context, final String q, final String r, final String v) {
        if (context == null) {
            return;
        }
        SharedPreferences.Editor editor = context.getSharedPreferences(FILE_FLOW_RATE, Context.MODE_PRIVATE).edit();
        editor.clear();
        if (q != null) {
            editor.putString(FLOW_RATE_Q_KEY, q);
        }
        if (r != null) {
            editor.putString(FLOW_RATE_R_KEY, r);
        }
        if (v != null) {
            editor.putString(FLOW_RATE_V_KEY, v);
        }
        editor.apply();
    }

    public static ArrayList<String> getAllFlowRateData(final Context context) {
        if (context == null) {
            return null;
        }
        ArrayList<String> retData = new ArrayList<>();
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_FLOW_RATE, Context.MODE_PRIVATE);
        String q = sharedPreferences.getString(FLOW_RATE_Q_KEY, "");
        String r = sharedPreferences.getString(FLOW_RATE_R_KEY, "");
        String v = sharedPreferences.getString(FLOW_RATE_V_KEY, "");
        retData.add(q);
        retData.add(r);
        retData.add(v);
        return retData;
    }


    public static final String FILE_FLOW_RATE_2 = "file_flowrate_2";
    public static void saveAllFlowRateData_2(final Context context, final String v, final String r, final String q) {
        if (context == null) {
            return;
        }
        SharedPreferences.Editor editor = context.getSharedPreferences(FILE_FLOW_RATE_2, Context.MODE_PRIVATE).edit();
        editor.clear();
        if (q != null) {
            editor.putString(FLOW_RATE_Q_KEY, q);
        }
        if (r != null) {
            editor.putString(FLOW_RATE_R_KEY, r);
        }
        if (v != null) {
            editor.putString(FLOW_RATE_V_KEY, v);
        }
        editor.apply();
    }

    public static ArrayList<String> getAllFlowRateData_2(final Context context) {
        if (context == null) {
            return null;
        }
        ArrayList<String> retData = new ArrayList<>();
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_FLOW_RATE_2, Context.MODE_PRIVATE);
        String q = sharedPreferences.getString(FLOW_RATE_Q_KEY, "");
        String r = sharedPreferences.getString(FLOW_RATE_R_KEY, "");
        String v = sharedPreferences.getString(FLOW_RATE_V_KEY, "");
        retData.add(v);
        retData.add(r);
        retData.add(q);
        return retData;
    }
}
