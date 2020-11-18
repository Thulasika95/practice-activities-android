package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CheckBox cbAndroid, cbJava, cbPhp;
    Button btSubmit;
    TextView tvOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbAndroid = findViewById(R.id.cb_android);
        cbJava = findViewById(R.id.cb_java);
        cbPhp = findViewById(R.id.cb_php);
        btSubmit = findViewById(R.id.bt_submit);
        tvOutput = findViewById(R.id.output);

        cbAndroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cbAndroid.isChecked()){
                    cbAndroid.setTextColor(getResources().getColor(R.color.colorAccent));
                }
                else{
                    cbAndroid.setTextColor(getResources().getColor(R.color.colorBlack));
                }
            }
        });

        cbJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cbJava.isChecked()){
                    cbJava.setTextColor(getResources().getColor(R.color.colorAccent));
                }
                else{
                    cbJava.setTextColor(getResources().getColor(R.color.colorBlack));
                }
            }
        });

        cbPhp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cbPhp.isChecked()){
                    cbPhp.setTextColor(getResources().getColor(R.color.colorAccent));
                }
                else{
                    cbPhp.setTextColor(getResources().getColor(R.color.colorBlack));
                }
            }
        });

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = "";
                if (cbAndroid.isChecked()){
                    s += "\n Android";
                }
                if (cbJava.isChecked()){
                    s += "\n Java";
                }
                if (cbPhp.isChecked()){
                    s += "\n PHP";
                }
                tvOutput.setText(s);
            }
        });
    }
}