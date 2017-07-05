package com.lostu.intercepttouchevent;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.lostu.intercepttouchevent.views.MyViewGroup;
import com.lostu.intercepttouchevent.views.RedView;
import com.lostu.intercepttouchevent.views.YellowView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    public MyViewGroup mMyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        setupView();
    }

    private void setupView() {
        RelativeLayout rootView = new RelativeLayout(this);
        rootView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        rootView.setBackgroundColor(Color.WHITE);

        rootView.setClickable(true);
        rootView.setEnabled(true);
        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "hello", Toast.LENGTH_LONG).show();
            }
        });

        {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
            layoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
            layoutParams.height = 1000;
            layoutParams.width = 1000;

            MyViewGroup greeView = new MyViewGroup(this);
            greeView.setBackgroundColor(Color.GREEN);
            greeView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "MyView");
                    Toast.makeText(MainActivity.this, "MyView", Toast.LENGTH_LONG).show();
                }
            });

            rootView.addView(greeView, layoutParams);
            this.mMyView = greeView;
        }

        {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            layoutParams.height = 600;
            layoutParams.width = 600;

            View redView = new RedView(this);
            redView.setBackgroundColor(Color.RED);
            redView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Red");
                    Toast.makeText(MainActivity.this, "Red", Toast.LENGTH_SHORT).show();
                }
            });

            this.mMyView.addView(redView, layoutParams);
        }

        {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            layoutParams.height = 400;
            layoutParams.width = 400;

            YellowView yellowView = new YellowView(this);
            yellowView.setBackgroundColor(Color.YELLOW);
            yellowView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Yellow");
                    Toast.makeText(MainActivity.this, "Yellow", Toast.LENGTH_SHORT).show();
                }
            });

            this.mMyView.addView(yellowView, layoutParams);
        }

        setContentView(rootView);
    }

}
