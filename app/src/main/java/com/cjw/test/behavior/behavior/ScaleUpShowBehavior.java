
package com.cjw.test.behavior.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;


public class ScaleUpShowBehavior extends FloatingActionButton.Behavior {

    private static final String TAG = ScaleUpShowBehavior.class.getName();

    // 退出动画是否正在执行
    private boolean isAnimatingOut = false;

    /**
     * 控件距离coordinatorLayout底部距离，用来做移动效果
     */
    private float viewDistance;

    public ScaleUpShowBehavior(Context context, AttributeSet attrs) {
        super();
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child,
                                       View directTargetChild, View target, int nestedScrollAxes) {
        if(child.getVisibility() == View.VISIBLE && viewDistance == 0 ){
            // TODO
            // 获取控件距离父布局（coordinatorLayout）底部距离
            viewDistance = coordinatorLayout.getHeight() - child.getY();
        }

        // 这个Behavior要监听的滑动方向
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL;
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child,
                               View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
//        System.out.println("onNestedScroll- dxConsumed:" + dxConsumed + "; dyConsumed: " + dyConsumed + "; dxUnconsumed: " + dxUnconsumed + "; dyUnconsumed: " + dyUnconsumed);

//        if (dyConsumed > 0 && dyUnconsumed == 0) {
//            System.out.println("上滑中。。。");
//        }
//        if (dyConsumed == 0 && dyUnconsumed > 0) {
//            System.out.println("到边界了还在上滑。。。");
//        }
//        if (dyConsumed < 0 && dyUnconsumed == 0) {
//            System.out.println("下滑中。。。");
//        }
//        if (dyConsumed == 0 && dyUnconsumed < 0) {
//            System.out.println("到边界了，还在下滑。。。");
//        }

        if (((dyConsumed > 0 && dyUnconsumed == 0) || (dyConsumed == 0 && dyUnconsumed > 0))
                && child.getVisibility() != View.VISIBLE) {// 显示

            Log.e(TAG, "上滑需要显示");

            AnimatorUtil.scaleShow(child, null);

            // TODO
//            AnimatorUtil.translationShow(child, null);


        } else if (((dyConsumed < 0 && dyUnconsumed == 0) || (dyConsumed == 0 && dyUnconsumed < 0))
                && child.getVisibility() != View.GONE && !isAnimatingOut) {

            Log.e(TAG, "下滑需要隐藏");

            AnimatorUtil.scaleHide(child, viewPropertyAnimatorListener);

//            AnimatorUtil.translationHide(child, viewDistance, viewPropertyAnimatorListener);

        }
    }

    private ViewPropertyAnimatorListener viewPropertyAnimatorListener = new ViewPropertyAnimatorListener() {

        @Override
        public void onAnimationStart(View view) {
            isAnimatingOut = true;
        }

        @Override
        public void onAnimationEnd(View view) {
            isAnimatingOut = false;
            view.setVisibility(View.GONE);
        }

        @Override
        public void onAnimationCancel(View arg0) {
            isAnimatingOut = false;
        }
    };
}
