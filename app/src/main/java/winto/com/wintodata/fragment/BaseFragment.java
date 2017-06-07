package winto.com.wintodata.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by hkun2012 on 2017/6/7.
 */

public abstract class BaseFragment extends Fragment {
    protected View mView;
    protected Unbinder unBinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(getLayoutResource(), container, false);
        ButterKnife.bind(this, mView);
        loadData();
        return mView;
    }

    @Override
    public void onPause() {
        super.onPause();
        saveData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unBinder != null) {
            unBinder.unbind();
        }
    }

    public abstract int getLayoutResource();
    public abstract void loadData();
    public abstract void saveData();
}
