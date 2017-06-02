package winto.com.wintodata;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import android.support.annotation.Nullable;

/**
 * Created by hkun2012 on 2017/5/28.
 */

public class MainFragment extends PreferenceFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.mail_preference);
    }

    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        switch(preference.getKey()) {
            case "first_item":
                try {
                    startActivity(new Intent(getActivity(), FlowRateActivity.class));
                } catch (Exception e) {

                }
                return true;
            case "second_item":
                try {
                    startActivity(new Intent(getActivity(), DataCheckActivity.class));
                } catch (Exception e) {

                }
                return true;
            case "third_item":
                try {
                    startActivity(new Intent(getActivity(), DataQueryActivity.class));
                } catch (Exception e) {

                }
                return true;
            default:
                return super.onPreferenceTreeClick(preferenceScreen, preference);
        }

    }
}
