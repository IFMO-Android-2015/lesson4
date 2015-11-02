package ru.ifmo.android_2015.listdemo;

import android.app.Activity;
import android.os.Bundle;
import ru.ifmo.android_2015.listdemo.view.AngleView;

import java.util.Random;

/**
 * Created by alexey.nikitin on 02.11.15.
 */
public final class ViewActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_view);

        AngleView angle1 = (AngleView)findViewById(R.id.angle_1);
        AngleView angle2 = (AngleView)findViewById(R.id.angle_2);
        AngleView angle3 = (AngleView)findViewById(R.id.angle_3);

        Random random = new Random();
        angle1.setAngle((float)(random.nextFloat() * Math.PI * 2));
        angle2.setAngle((float)(random.nextFloat() * Math.PI * 2));
        angle3.setAngle((float)(random.nextFloat() * Math.PI * 2));
    }
}
