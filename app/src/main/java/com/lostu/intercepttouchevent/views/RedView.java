package com.lostu.intercepttouchevent.views;

import android.content.Context;
import android.support.v4.widget.ViewDragHelper;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by zhudf on 2017/7/4.
 */

public class RedView extends MovableView {

    private static final String TAG = RedView.class.getSimpleName();

    private float mBeginX;
    private float mBeginY;

    public RedView(Context ctx) {
        super(ctx);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "onTouch: RedView");
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        // 会触发 onTouchEvent，决定是否处理本次事件
        boolean handled = super.dispatchTouchEvent(event);
        Log.e(TAG, String.format("action=%d, handled=%s", event.getAction(), handled ? "true" : "false"));
        return handled;
    }

}
