package ru.ifmo.android_2015.listdemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by alexey.nikitin on 02.11.15.
 */
public final class UniformLayout extends ViewGroup {
    private static final String TAG = UniformLayout.class.getSimpleName();

    public UniformLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.d(TAG, MeasureSpec.toString(widthMeasureSpec) + " x " + MeasureSpec.toString(heightMeasureSpec));

        int childCount = getChildCount();

        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

        if (childCount > 0) {
            int oneChildWidth = width / childCount;
            int oneChildWidthMeasureSpec = MeasureSpec.makeMeasureSpec(oneChildWidth, MeasureSpec.EXACTLY);
            int oneChildHeightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);

            for (int i = 0; i < childCount; i++) {
                View child = getChildAt(i);

                child.measure(oneChildWidthMeasureSpec, oneChildHeightMeasureSpec);
            }
        }

        setMeasuredDimension(width, height);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int count = getChildCount();
        int x = 0;
        for (int i = 0; i < count; i++) {
            View childAt = getChildAt(i);

            childAt.layout(x, 0, x + childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
            x += childAt.getMeasuredWidth();
        }
    }
}
