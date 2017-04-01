package com.cjw.test.viewpager;

import android.content.Intent;
import android.view.View;

import com.cjw.test.BaseActivity;
import com.cjw.test.R;
import com.cjw.test.viewpager.testadapter.TestVPAdapterActivity;
import com.cjw.test.viewpager.testdynamic.TestVPDynamicActivity;

import butterknife.OnClick;

public class TestViewPagerActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_viewpager;
    }

    @OnClick({R.id.btn_vp_adapter, R.id.btn_vp_dynamic})
    public void bfClick(View view) {
        switch (view.getId()) {
            case R.id.btn_vp_adapter:
                startActivity(new Intent(this, TestVPAdapterActivity.class));
                break;
            case R.id.btn_vp_dynamic:
                startActivity(new Intent(this, TestVPDynamicActivity.class));
                break;

        }
    }
}
