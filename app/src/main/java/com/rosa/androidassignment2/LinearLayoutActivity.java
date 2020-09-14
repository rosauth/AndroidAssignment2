package com.rosa.androidassignment2;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class LinearLayoutActivity extends AppCompatActivity {

    Button btn_toast, btn_count;
    TextView txt_showCount;

    TextInputEditText inp_expectedValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);

        btn_toast = findViewById(R.id.btn_showToast);
        btn_count = findViewById(R.id.btn_countUp);
        txt_showCount = findViewById(R.id.txt_count);

        inp_expectedValue = findViewById(R.id.inp_expectedVal);

        inp_expectedValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Toast.makeText(getApplicationContext(), "Value changed", Toast.LENGTH_SHORT).show();
                txt_showCount.setText(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt("count", Integer.parseInt(txt_showCount.getText().toString()));
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        txt_showCount.setText(String.valueOf(savedInstanceState.getInt("count", 0)));
        super.onRestoreInstanceState(savedInstanceState);
    }

    public void showToast(View view) {
        Toast.makeText(getApplicationContext(), "Navigate to first Counter - Assignment", Toast.LENGTH_LONG).show();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

    public void count(View view) {
        int currentCount = Integer.parseInt(txt_showCount.getText().toString());
        txt_showCount.setText(String.valueOf(currentCount += 1));
    }

}