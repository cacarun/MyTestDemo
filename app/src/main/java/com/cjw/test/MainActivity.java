package com.cjw.test;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.cjw.test.behavior.TestBehaviorActivity;
import com.cjw.test.view.TestViewActivity;
import com.cjw.test.viewpager.TestViewPagerActivity;

import java.util.Arrays;
import java.util.List;

import butterknife.OnClick;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class MainActivity extends BaseActivity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @OnClick({R.id.btn_view_pager, R.id.btn_behavior, R.id.btn_view})
    public void bfClick(View view) {
        switch (view.getId()) {
            case R.id.btn_view_pager:
                startActivity(new Intent(this, TestViewPagerActivity.class));
                break;
            case R.id.btn_behavior:
                startActivity(new Intent(this, TestBehaviorActivity.class));
                break;
            case R.id.btn_view:
                startActivity(new Intent(this, TestViewActivity.class));
                break;

        }
    }


    private void testRxJava() {
        List<String> dataList = Arrays.asList("string1", "string02", "string3", "string04",
                "string05", "string06");

        // 1.每个元素按流式传递  2.string06 根本不会打印
        Observable.just(dataList).flatMap(new Func1<List<String>, Observable<String>>() {
            @Override
            public Observable<String> call(List<String> strings) {
                Log.e(TAG, "begin");
                // from操作符把just整个对象变成单个对象发射出去
                // 也就是单个对象走一轮之后再触发下一个对象走一轮
                return Observable.from(strings);
            }
        }).flatMap(new Func1<String, Observable<String>>() {
            @Override
            public Observable<String> call(String s) {
                Log.e(TAG, s + "  222222 addPre_");
                return Observable.just("addPre_"+ s);
            }
        }).filter(new Func1<String, Boolean>() {
            @Override
            public Boolean call(String s) {
                Log.e(TAG, s + "  333333 filter");
                //包含a的留下
                return s.contains("0");
            }
        }).take(3) //最多只取3个
                .doOnNext(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        // onNext之前 输出一下
                        Log.e(TAG, s + "  444444 doOnNext");
                    }
                }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.e(TAG, s + "  end");
            }
        });
    }

}
