package com.example.todo_09;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText moperandOne;
    private EditText moperandTwo;
    public Calculator mCalculator;
    private TextView mResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        moperandOne=findViewById(R.id.operandOne);
        moperandTwo=findViewById(R.id.operandTwo);
        mCalculator=new Calculator();
        mResult=findViewById(R.id.result);
    }

    public void Addition(View view) {
        String operandOne=moperandOne.getText().toString();
        String operandTwo=moperandTwo.getText().toString();

        double value=mCalculator.add(Double.valueOf(operandOne), Double.valueOf(operandTwo));
        mResult.setText(String.valueOf(value));

    }

    public void Subtraction(View view) {
        String operandOne=moperandOne.getText().toString();
        String operandTwo=moperandTwo.getText().toString();

        double value=mCalculator.sub(Double.valueOf(operandOne), Double.valueOf(operandTwo));
        mResult.setText(String.valueOf(value));
    }

    public void Multiplication(View view) {
        String operandOne=moperandOne.getText().toString();
        String operandTwo=moperandTwo.getText().toString();

        double value=mCalculator.mul(Double.valueOf(operandOne), Double.valueOf(operandTwo));
        mResult.setText(String.valueOf(value));
    }

    public void Division(View view) {
        String operandOne=moperandOne.getText().toString();
        String operandTwo=moperandTwo.getText().toString();

        double value=mCalculator.div(Double.valueOf(operandOne), Double.valueOf(operandTwo));
        mResult.setText(String.valueOf(value));
    }
}