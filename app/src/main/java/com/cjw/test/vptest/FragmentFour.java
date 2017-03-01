package com.cjw.test.vptest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cjw.test.R;

/**
 * Created by CJW on 2017/3/1.
 */

public class FragmentFour extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e("CJW", "onCreateView 44444444");
        return inflater.inflate(R.layout.fragment_four, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.e("CJW", "onCreate 44444444");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        Log.e("CJW", "onDestroy 4444444444");
        super.onDestroy();
    }
}
