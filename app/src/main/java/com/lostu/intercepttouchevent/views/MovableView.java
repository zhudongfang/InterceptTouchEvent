package com.lostu.intercepttouchevent.views;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by zhudf on 2017/7/5.
 */

public class MovableView extends View {

    private static final String TAG = MovableView.class.getSimpleName();

    private float mTouchDownX;
    private float mTouchDownY;

    private float mOrigX;
    private float mOrigY;

    public MovableView(Context context) {
        super(context);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i(TAG, "Down");
                mTouchDownX = event.getRawX();
                mTouchDownY = event.getRawY();

                mOrigX = this.getX();
                mOrigY = this.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                float x = event.getRawX();
                float y = event.getRawY();

                float translationX = x - mTouchDownX;
                float translationY = y - mTouchDownY;

                this.setX(mOrigX + translationX);
                this.setY(mOrigY + translationY);

                break;
            case MotionEvent.ACTION_UP:
                Log.i(TAG, "Up");
                break;
        }

        return super.onTouchEvent(event);
    }
}
