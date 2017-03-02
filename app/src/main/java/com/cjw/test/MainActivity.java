package com.cjw.test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.cjw.test.vptest.FragmentFive;
import com.cjw.test.vptest.FragmentFour;
import com.cjw.test.vptest.FragmentOne;
import com.cjw.test.vptest.FragmentThree;
import com.cjw.test.vptest.FragmentTwo;
import com.cjw.test.vptest.ViewPagerStateAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    @BindView(R.id.vp)
    ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new FragmentOne());
        fragmentList.add(new FragmentTwo());
        fragmentList.add(new FragmentThree());
        fragmentList.add(new FragmentFour());
        fragmentList.add(new FragmentFive());

        ViewPagerStateAdapter adapterState = new ViewPagerStateAdapter(getSupportFragmentManager(), fragmentList, null);
        vp.setAdapter(adapterState);


//        List<String> dataList = Arrays.asList("string1", "string02", "string3", "string04",
//                "string05", "string06");
//
//        // 1.每个元素按流式传递  2.string06 根本不会打印
//        Observable.just(dataList).flatMap(new Func1<List<String>, Observable<String>>() {
//            @Override
//            public Observable<String> call(List<String> strings) {
//                Log.e(TAG, "begin");
//                // from操作符把just整个对象变成单个对象发射出去
//                // 也就是单个对象走一轮之后再触发下一个对象走一轮
//                return Observable.from(strings);
//            }
//        }).flatMap(new Func1<String, Observable<String>>() {
//            @Override
//            public Observable<String> call(String s) {
//                Log.e(TAG, s + "  222222 addPre_");
//                return Observable.just("addPre_"+ s);
//            }
//        }).filter(new Func1<String, Boolean>() {
//            @Override
//            public Boolean call(String s) {
//                Log.e(TAG, s + "  333333 filter");
//                //包含a的留下
//                return s.contains("0");
//            }
//        }).take(3) //最多只取3个
//                .doOnNext(new Action1<String>() {
//                    @Override
//                    public void call(String s) {
//                        // onNext之前 输出一下
//                        Log.e(TAG, s + "  444444 doOnNext");
//                    }
//                }).subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                Log.e(TAG, s + "  end");
//            }
//        });



    }

}
