package com.example.administrator.rotatetest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ((Button) findViewById(R.id.button1))
                .setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(HomeActivity.this,
                                MainActivity.class));
                    }
                });
        ((Button) findViewById(R.id.button2))
                .setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(HomeActivity.this,
                                Main2Activity.class));
                    }
                });
    }


}
