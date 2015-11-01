package ru.ifmo.android_2015.listdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * Created by alexey.nikitin on 01.11.15.
 */
public final class MainActivity extends Activity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    public void scrollViewClicked(View view) {
        Log.d(TAG, "scrollViewClicked");
        Intent intent = new Intent(this, ScrollActivity.class);
        startActivity(intent);
    }

    public void recyclerViewClicked(View view) {
        Log.d(TAG, "recyclerViewClicked");
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }
}
