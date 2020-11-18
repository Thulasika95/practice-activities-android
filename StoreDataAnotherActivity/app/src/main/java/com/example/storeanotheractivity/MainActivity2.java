package com.example.storeanotheractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView Display = findViewById(R.id.textView);
        Bundle bn = getIntent().getExtras();
        String name = bn.getString("abc");
        Display.setText(String.valueOf(name));
    }
}