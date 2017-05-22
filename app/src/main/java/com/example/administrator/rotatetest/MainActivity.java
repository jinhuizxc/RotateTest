package com.example.administrator.rotatetest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

/**
 * 通过key-value 保存radiobutton的id
 * onDestroy()被执行，activity重新创建。
 */
public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";
    private RadioGroup mRadioGroup;
    private TextView mTextView;

    private static final String LAST_CHOICE = "last_choice";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRadioGroup = (RadioGroup) findViewById(R.id.main_radioGroup);
        mTextView = (TextView) findViewById(R.id.textView1);
        //获取销毁前选择的RadioButton的Id
        int checkId = R.id.main_radio0;
        Log.e(TAG, "checkId = " + checkId);   // 2131427418
        if (savedInstanceState != null) {
            Log.e(TAG, "savedInstanceState被执行");
            checkId = savedInstanceState.getInt(LAST_CHOICE);
            Log.e(TAG, "保存的checkId = " + checkId);  // 2131427420
        }

        ((RadioButton) findViewById(checkId)).setChecked(true);
        switch (mRadioGroup.getCheckedRadioButtonId()) {
            case R.id.main_radio0:
                mTextView.setText("Show One");
                break;
            case R.id.main_radio1:
                mTextView.setText("Show Two");
                break;
            case R.id.main_radio2:
                mTextView.setText("Show Three");
                break;
            default:
                break;
        }

        mRadioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                switch (checkedId) {
                    case R.id.main_radio0:
                        mTextView.setText("Show One");
                        break;
                    case R.id.main_radio1:
                        mTextView.setText("Show Two");
                        break;
                    case R.id.main_radio2:
                        mTextView.setText("Show Three");
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // TODO Auto-generated method stub
        super.onSaveInstanceState(outState);
        //保存选择RadioButton的Id
        outState.putInt(LAST_CHOICE, mRadioGroup.getCheckedRadioButtonId());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy 方法被执行");
    }

}
