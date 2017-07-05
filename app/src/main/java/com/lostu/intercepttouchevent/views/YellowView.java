package com.lostu.intercepttouchevent.views;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by zhudf on 2017/7/4.
 */

public class YellowView extends MovableView {

    private static final String TAG = YellowView.class.getSimpleName();

    public YellowView(Context ctx) {
        super(ctx);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "onTouch: YellowView");
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d(TAG, "dispatchTouchEvent: Yellow");
        boolean handled =  super.dispatchTouchEvent(event);
        Log.e(TAG, String.format("action=%d, handled=%s", event.getAction(), handled ? "true" : "false"));
        return handled;
    }
}

