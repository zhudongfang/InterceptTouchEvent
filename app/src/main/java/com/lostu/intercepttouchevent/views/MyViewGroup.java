package com.lostu.intercepttouchevent.views;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by zhudf on 2017/7/4.
 */

public class MyViewGroup extends RelativeLayout {

    private static final String TAG = MyViewGroup.class.getSimpleName();

    private View mResponseView;

    public MyViewGroup(Context ctx) {
        super(ctx);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "onTouch: MyView");
        return super.onTouchEvent(event);
    }

    /*
     * 1. 如果直接返回 false，那么 onInterceptTouchEvent 也就不会被触发，事件交由上层 View 处理
     * 2. 如果直接返回 true，那么 onInterceptTouchEvent 也不会被触发
     * 3. 如果调用 super.dispatchTouchEvent，那么先触发 onInterceptTouchEvent 方法，之后调用子 View 的
     * dispatchTouchEvent 方法（能响应的那个 View）
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e(TAG, "dispatchTouchEvent: MyView");

        if (event.getAction() != MotionEvent.ACTION_DOWN) {
            if (mResponseView != null) {
                return mResponseView.dispatchTouchEvent(event);
            } else {
                return super.dispatchTouchEvent(event);
            }
        }

        mResponseView = null;
        // 从上到下
        for (int i = this.getChildCount() - 1; i >= 0; i--) {
            View subView = this.getChildAt(i);

            Rect rect = new Rect();
            subView.getHitRect(rect);

            if (rect.contains((int)event.getX(), (int)event.getY())) {
                // subView.bringToFront();

                //  响应区域重叠时优先处理 RedView
                if (subView.getClass().getSimpleName().equals("RedView")) {
                    // subView.bringToFront();
                    boolean handled = subView.dispatchTouchEvent(event);
                    if (handled) {
                        mResponseView = subView;
                        return true;
                    }
                }
            }

            Log.i(TAG, String.format("subview: %s", subView.toString()));
        }

        boolean handled = super.dispatchTouchEvent(event);
        Log.e(TAG, String.format("action=%d, handled=%s", event.getAction(), handled ? "true" : "false"));
        return handled;
    }

    /*
     * 1. 如果返回 true，那么 onTouchEvent 中即使调用 super.onTouchEvent 子 View 也不会收到任何事件了
     * 2. 如果返回 false，那么 onIntercepterTouchEvent 就不会接收到其他事件了，所有事件到转到 onTouchEvent 中处理
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        Log.e(TAG, String.format("onInterceptTouchEvent: %d", event.getAction()));
        return super.onInterceptTouchEvent(event);
    }
}
