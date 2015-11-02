package ru.ifmo.android_2015.listdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

/**
 * Created by alexey.nikitin on 02.11.15.
 */
public class AngleView extends View {
    protected float angle;

    private final Paint paintAgnle = new Paint();
    private final Paint paintRect = new Paint();

    public AngleView(Context context, AttributeSet attrs) {
        super(context, attrs);

        paintAgnle.setColor(new Random().nextInt());
        paintAgnle.setStrokeWidth(10);

        paintRect.setColor(new Random().nextInt());
        paintRect.setStrokeWidth(10);
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();

        canvas.drawRect(0, 0, width, height, paintRect);

        int minSize = Math.min(width, height) / 2;

        int centerX = width / 2;
        int centerY = height / 2;
        canvas.drawLine(centerX, centerY, (float)(centerX + minSize * Math.cos(angle)),
                        (float)(centerY + minSize * Math.sin(angle)), paintAgnle);

        angle += 0.1;
        invalidate();
    }
}
