package com.cjw.test.viewpager.testadapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.cjw.test.BaseActivity;
import com.cjw.test.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class TestVPAdapterActivity extends BaseActivity {

    @BindView(R.id.vp)
    ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        testViewPagerAdapter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_viewpager_adapter;
    }

    private void testViewPagerAdapter() {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new FragmentOne());
        fragmentList.add(new FragmentTwo());
        fragmentList.add(new FragmentThree());
        fragmentList.add(new FragmentFour());
        fragmentList.add(new FragmentFive());

        ViewPagerStateAdapter adapterState = new ViewPagerStateAdapter(getSupportFragmentManager(), fragmentList, null);
        vp.setAdapter(adapterState);
    }
}
