package com.rosa.androidassignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class IntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        Intent intent = getIntent();
        int data = intent.getIntExtra("count", 0);

        TextView txt_num = findViewById(R.id.txt_num);
        txt_num.setText(String.valueOf(data));
    }
}