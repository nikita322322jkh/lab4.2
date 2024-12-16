package com.example.lab4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonAdd, buttonSubtract, buttonDivide, buttonMultiply, buttonPower, buttonClean;
    private TextView operation, result;
    private EditText number1, number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSubtract = findViewById(R.id.buttonSubtract);
        buttonDivide = findViewById(R.id.buttonDivide);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonPower = findViewById(R.id.buttonPower);
        buttonClean = findViewById(R.id.buttonClean);
        operation = findViewById(R.id.operation);
        result = findViewById(R.id.result);
        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);

        buttonAdd.setOnClickListener(this);
        buttonSubtract.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonPower.setOnClickListener(this);
        buttonClean.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        float num1 = 0;
        float num2 = 0;
        float res = 0;
        try {
            num1 = Float.parseFloat(number1.getText().toString());
        } catch (NumberFormatException e) {
            result.setText("Ошибка");
            return;
        }

        try {
            num2 = Float.parseFloat(number2.getText().toString());
        } catch (NumberFormatException e) {
            result.setText("Ошибка");
            return;
        }

        if (v.getId() == R.id.buttonAdd) {
            operation.setText("+");
            res = num1 + num2;
        } else if (v.getId() == R.id.buttonSubtract) {
            operation.setText("-");
            res = num1 - num2;
        } else if (v.getId() == R.id.buttonDivide) {
            operation.setText("/");
            res = num1 / num2;
        } else if (v.getId() == R.id.buttonMultiply) {
            operation.setText("*");
            res = num1 * num2;
        } else if (v.getId() == R.id.buttonPower) {
            operation.setText("^");
            res = (float) Math.pow(num1, num2);
        } else if (v.getId() == R.id.buttonClean) {
            number1.setText("");
            operation.setText("");
            number2.setText("");
            result.setText("");
            return;
        }

        result.setText(String.valueOf(res));
    }

    public void goToNextPage(View view) {
        android.content.Intent intent = new android.content.Intent(this, develop.class);
        startActivity(intent);
    }
}