package com.example.Day13;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Administrator on 13-8-6.
 */
public class Activity1 extends Activity {
    private EditText name;
    private EditText password;
    private Button login;
    private Button button;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1);


        login  = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity1.this, Activity2.class);
//               startActivity(intent);
                startActivityForResult(intent, 10);
            }
        });

        name = (EditText) findViewById(R.id.name);
        password = (EditText) findViewById(R.id.password);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity1.this,Activity2.class);
                intent.putExtra("name",name.getText().toString());
                intent.putExtra("password",password.getText().toString());
                startActivity(intent);
            }
        });

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ComponentName cn = new ComponentName(Activity1.this,com.example.Day13.Activity2.class);
                Intent intent = new Intent();
                intent.setComponent(cn);
                startActivity(intent);
            }
        });
    }
}