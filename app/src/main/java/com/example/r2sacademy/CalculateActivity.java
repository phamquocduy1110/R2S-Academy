package com.example.r2sacademy;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CalculateActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText txtNumberA, txtNumberB;
    private Button btnAdd, btnSub, btnMul, btnDiv, btnCancel;
    private TextView tvResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        init();
    }

    public void init() {
        txtNumberA = findViewById(R.id.numberA);
        txtNumberB = findViewById(R.id.numberB);

        btnAdd = findViewById(R.id.btnSummation);
        btnAdd.setOnClickListener(this);

        btnSub = findViewById(R.id.btnSubtraction);
        btnSub.setOnClickListener(this);

        btnMul = findViewById(R.id.btnMultiplication);
        btnMul.setOnClickListener(this);

        btnDiv = findViewById(R.id.btnDivision);
        btnDiv.setOnClickListener(this);

        tvResult = findViewById(R.id.tvResult);

        btnCancel = findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });    }

    private void add() {
        int a = Integer.parseInt(txtNumberA.getText().toString());
        int b = Integer.parseInt(txtNumberB.getText().toString());

        tvResult.setText(String.valueOf("A + B = " + (a + b)));
    }

    private void sub() {
        int a = Integer.parseInt(txtNumberA.getText().toString());
        int b = Integer.parseInt(txtNumberB.getText().toString());

        tvResult.setText(String.valueOf("A - B = " + (a - b)));
    }

    private void mul() {
        int a = Integer.parseInt(txtNumberA.getText().toString());
        int b = Integer.parseInt(txtNumberB.getText().toString());

        tvResult.setText(String.valueOf("A x B = " + (a * b)));
    }

    private void div() {
        int a = Integer.parseInt(txtNumberA.getText().toString());
        int b = Integer.parseInt(txtNumberB.getText().toString());

        tvResult.setText(String.valueOf("A : B = " + (a / b)));
    }

    @Override
    public void onClick(View view) {
        if (txtNumberA.getText().toString().isEmpty() && txtNumberB.getText().toString().isEmpty())
        {
            Toast.makeText(CalculateActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
            return;
        }

        switch (view.getId()) {
            case R.id.btnSummation: add();
                break;
            case R.id.btnSubtraction: sub();
                break;
            case R.id.btnMultiplication: mul();
                break;
            case R.id.btnDivision: div();
                break;
        }
    }
}
