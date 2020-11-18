package com.example.storeanotheractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText inputText = findViewById(R.id.editText);
        final TextView outputText = findViewById(R.id.textView);
        //Button Add = findViewById(R.id.bt_add);
        Button Save = findViewById(R.id.bt_save);

//        Add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String Value = inputText.getText().toString();
//                outputText.setText(Value);
//            }
//        });

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Value = inputText.getText().toString();
                outputText.setText(Value);
                String Data = outputText.getText().toString();
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("abc", Data);
                startActivity(intent);
                finish();
            }
        });
    }
}