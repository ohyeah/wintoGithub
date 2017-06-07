package winto.com.wintodata;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import winto.com.wintodata.fragment.FlowRate_1_Fragment;
import winto.com.wintodata.fragment.FlowRate_2_Fragment;

/**
 * Created by hkun2012 on 2017/5/28.
 */

public class FlowRateActivity extends BaseActivity {
    public static final double TEST = 0.001 * 0.001 * 3600 * 3.14;

    public static final int RETURN_CODE = 1;
    private List<Fragment> fragmentList = new ArrayList<>();
    private MyPagerAdapter adapter;

    @BindView(R.id.title_text)
    TextView title;
    @BindView(R.id.viewpager)
    ViewPager viewPager;

    @OnClick(R.id.tv_switch)
    public void onClickSwitch() {
        switchPage();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow_rate);
        unbinder = ButterKnife.bind(this);

        fragmentList.add(new FlowRate_1_Fragment());
        fragmentList.add(new FlowRate_2_Fragment());
        adapter = new MyPagerAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    title.setText("流量->流速");
                } else if (position == 1) {
                    title.setText("流速->流量");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void switchPage() {
        if (viewPager.getCurrentItem() == 0) {
            viewPager.setCurrentItem(1, true);
        } else if (viewPager.getCurrentItem() == 1) {
            viewPager.setCurrentItem(0, true);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    public static class MyPagerAdapter extends FragmentStatePagerAdapter {

        private List<Fragment> mList;

        public MyPagerAdapter(android.support.v4.app.FragmentManager fm, List<Fragment> list) {
            super(fm);
            mList = list;
        }

        @Override
        public Fragment getItem(int position) {

            return mList.get(position);
        }

        @Override
        public int getCount() {
            return mList.size();
        }
    }
}
