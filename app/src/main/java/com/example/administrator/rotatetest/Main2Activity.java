package com.example.administrator.rotatetest;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Configuration;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 屏幕横竖屏切换：
 * onDestroy()不会被执行，activity没有被创建创建。
 * 方法调用：onConfigurationChanged()
 *
 * android:configChanges="orientation|keyboardHidden|screenSize"/>
 */
public class Main2Activity extends Activity {

    private static final String TAG = "Main2Activity";
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate 方法被执行");
        setContentView(R.layout.activity_main2);
        text = (TextView) findViewById(R.id.text);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.e(TAG, "onConfigurationChanged方法被执行");
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(Main2Activity.this, "现在是竖屏", Toast.LENGTH_SHORT)
                    .show();
            text.setText("现在是竖屏");
        }
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(Main2Activity.this, "现在是横屏", Toast.LENGTH_SHORT)
                    .show();
            text.setText("现在是横屏");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy 方法被执行");
    }
}
