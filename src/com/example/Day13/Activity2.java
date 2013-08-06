package com.example.Day13;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Administrator on 13-8-6.
 */
public class Activity2 extends Activity {

    private TextView name;
    private TextView password;
    private TextView tv;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        Button finish = (Button) findViewById(R.id.finish);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        name = (TextView) findViewById(R.id.textView);
        password = (TextView) findViewById(R.id.textView2);
        Intent intent = this.getIntent();
        name.setText(intent.getStringExtra("name"));
        password.setText(intent.getStringExtra("password"));

        Intent intent1 = this.getIntent();
        ComponentName  cn = intent1.getComponent();
        String packName = cn.getPackageName();
        String className = cn.getClassName();
        tv  = (TextView) findViewById(R.id.tv);
        tv.setText("包名是： " + packName + "类名是： " + className);



    }
}