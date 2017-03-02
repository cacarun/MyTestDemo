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

public class FragmentFive extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e("CJW", "onCreateView 55555555");
        return inflater.inflate(R.layout.fragment_five, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.e("CJW", "onCreate 55555555");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        Log.e("CJW", "onDestroyView 5555555555");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.e("CJW", "onDestroy 55555555");
        super.onDestroy();
    }
}
