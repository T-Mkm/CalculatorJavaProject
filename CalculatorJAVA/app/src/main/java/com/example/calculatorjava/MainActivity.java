package com.example.calculatorjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Controller controller;

    private ScrollView scroll;
    private TextView textField;
    private TextView logField;

    public MainActivity() {
        controller = new Controller(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scroll = findViewById(R.id.scrollView);
        scroll.fullScroll(View.FOCUS_DOWN);

        textField = findViewById(R.id.textField);
        logField = findViewById(R.id.logField);

        Button button1 = findViewById(R.id.buttonOne);
        button1.setOnClickListener(controller);

        Button button2 = findViewById(R.id.buttonTwo);
        button2.setOnClickListener(controller);

        Button button3 = findViewById(R.id.buttonThree);
        button3.setOnClickListener(controller);

        Button button4 = findViewById(R.id.buttonFour);
        button4.setOnClickListener(controller);

        Button button5 = findViewById(R.id.buttonFive);
        button5.setOnClickListener(controller);

        Button button6 = findViewById(R.id.buttonSix);
        button6.setOnClickListener(controller);

        Button button7 = findViewById(R.id.buttonSeven);
        button7.setOnClickListener(controller);

        Button button8 = findViewById(R.id.buttonEight);
        button8.setOnClickListener(controller);

        Button button9 = findViewById(R.id.buttonNine);
        button9.setOnClickListener(controller);

        Button button0 = findViewById(R.id.buttonZero);
        button0.setOnClickListener(controller);

        Button buttonAC = findViewById(R.id.buttonAllClear);
        buttonAC.setOnClickListener(controller);

        Button buttonC = findViewById(R.id.buttonClear);
        buttonC.setOnClickListener(controller);

        Button buttonDel = findViewById(R.id.buttonDelete);
        buttonDel.setOnClickListener(controller);

        Button buttonDiv = findViewById(R.id.buttonDivide);
        buttonDiv.setOnClickListener(controller);

        Button buttonMul = findViewById(R.id.buttonMultiply);
        buttonMul.setOnClickListener(controller);

        Button buttonPlus = findViewById(R.id.buttonPlus);
        buttonPlus.setOnClickListener(controller);

        Button buttonMinus = findViewById(R.id.buttonMinus);
        buttonMinus.setOnClickListener(controller);

        Button buttonEq = findViewById(R.id.buttonEqual);
        buttonEq.setOnClickListener(controller);

        Button buttonPM = findViewById(R.id.buttonPlusMinus);
        buttonPM.setOnClickListener(controller);

        Button buttonDot = findViewById(R.id.buttonDot);
        buttonDot.setOnClickListener(controller);

    }

    public void setFontSize(Integer length) {
        if (length <= 11) {
            textField.setTextSize(60);
        } else if (length > 11 && length < 18) {
            textField.setTextSize(45);
        } else if (length > 18 && length < 28) {
            textField.setTextSize(30);
        } else if (length > 28) {
            textField.setTextSize(24);
        }
    }


    public void update(String expression, String log) {
        textField.setText(expression);
        logField.setText(log);

        scroll.post(new Runnable() {
            @Override
            public void run() {
                scroll.fullScroll(View.FOCUS_DOWN);
            }
        });
    }
}