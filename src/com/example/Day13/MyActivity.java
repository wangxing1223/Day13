package com.example.Day13;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private CheckBox checkBox ;
    private ToggleButton toggleButton;
    private String[] colors = {"red","green","blue"};
    private Button activity;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioButton = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
        Log.v("Test",String.valueOf(radioButton.getText()));
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton = (RadioButton) findViewById(i);
                Log.v("Test",String.valueOf(radioButton.getText()));
            }
        });

        checkBox = (CheckBox) findViewById(R.id.tour);
        checkBox.setChecked(true);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                checkBox = (CheckBox)compoundButton;
                Log.v("Test",String.valueOf(checkBox.getText() + "is" + String.valueOf(b)));
            }
        });

        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    setTitle("打开");
                }else {
                    setTitle("关闭");
                }
            }
        });


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,colors);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Spinner spinner = (Spinner) adapterView;
                Toast.makeText(MyActivity.this,spinner.getSelectedItem().toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        activity = (Button) findViewById(R.id.activity1);
        setActivity1();
        
    ;
    }
    private void setActivity1(){
        activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MyActivity.this, Activity1.class);
                startActivity(intent);
            }
        });
    }
}
