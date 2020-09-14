package com.rosa.androidassignment2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class MainActivity extends AppCompatActivity {

    TextView txt_num;
    AppCompatButton btn_up, btn_down;

    int count;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_num = findViewById(R.id.txt_counter);
        btn_up = findViewById(R.id.btn_up);
        btn_down = findViewById(R.id.btn_down);

        sharedPreferences = MainActivity.this.getPreferences(Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    @Override
    protected void onPause() {
        editor.putInt("count", Integer.parseInt(txt_num.getText().toString())).commit();
        super.onPause();
    }

    @Override
    protected void onResume() {
        txt_num.setText(String.valueOf(sharedPreferences.getInt("count", 0)));
        super.onResume();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt("count", Integer.parseInt(txt_num.getText().toString()));
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        txt_num.setText(String.valueOf(savedInstanceState.getInt("count")));
        super.onRestoreInstanceState(savedInstanceState);
    }

    public void countUp(View view) {
        count = Integer.parseInt(txt_num.getText().toString());
        txt_num.setText(String.valueOf(count+=1));
    }


    public void countDown(View view) {
        count = Integer.parseInt(txt_num.getText().toString());
        txt_num.setText(String.valueOf(count-=1));
    }

    public void nextPage(View view) {
        Intent nextPage = new Intent(getApplicationContext(), IntentActivity.class);
        nextPage.putExtra("count", Integer.parseInt(txt_num.getText().toString()));
        startActivity(nextPage);
    }
}