package ru.ifmo.android_2015.listdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;

/**
 * Created by alexey.nikitin on 01.11.15.
 */
public final class ScrollActivity extends Activity {
    private static final String TAG = ScrollActivity.class.getSimpleName();
    private ViewGroup group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate");

        setContentView(R.layout.activity_scroll);

        group = (ViewGroup)findViewById(R.id.root_container);
        for (int i = 0; i < 10000; i++) {
            addTextView(i);
        }

        group.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                group.getViewTreeObserver().removeOnPreDrawListener(this);
                Log.d(TAG, "onPreDraw");
                return true;
            }
        });
    }

    private void addTextView(int i) {
        TextView tv = new TextView(this);
        tv.setText("Item #" + i);
        group.addView(tv, i, new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                80));
    }

    public void addClicked(View view) {
        addTextView(group.getChildCount());
    }
}