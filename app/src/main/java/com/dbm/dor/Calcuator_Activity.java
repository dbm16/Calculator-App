package com.dbm.dor;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Calcuator_Activity extends AppCompatActivity {
    private TextView targilView;
    private TextView resultView;
    private String userInput = "";
    private String selectedOperator  = "";
    private String fullEquation  = "";
    private double firstNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        targilView = findViewById(R.id.targil);
        resultView = findViewById(R.id.result);

        setNumberListeners();

        setOperatorListeners();

        findViewById(R.id.equals).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calcuator_Activity.this.calculateResult();
            }
        });

        findViewById(R.id.button13).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calcuator_Activity.this.clearCalculator();
            }
        });
    }

    private void setNumberListeners() {
        int[] numberButtonIds = {
                R.id.one, R.id.two, R.id.three,
                R.id.four, R.id.five, R.id.six,
                R.id.seven,
                R.id.zero, R.id.eight, R.id.nine
        };

        for (int id : numberButtonIds) {
            Button button = findViewById(id);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String number = ((Button) v).getText().toString();
                    userInput += number;
                    fullEquation += number;
                    targilView.setText(fullEquation);
                }
            });
        }
    }

    private void setOperatorListeners() {

        {
            Button button = findViewById(R.id.plus);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!userInput.isEmpty()) {
                        firstNumber = Double.parseDouble(userInput);
                        selectedOperator = ((Button) v).getText().toString();
                        fullEquation += " " + selectedOperator + " ";
                        userInput = "";
                        targilView.setText(fullEquation);
                    }
                }
            });
        }
        {
            Button button = findViewById(R.id.minus);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!userInput.isEmpty()) {
                        firstNumber = Double.parseDouble(userInput);
                        selectedOperator = ((Button) v).getText().toString();
                        fullEquation += " " + selectedOperator + " ";
                        userInput = "";
                        targilView.setText(fullEquation);
                    }
                }
            });
        }
        {
            Button button = findViewById(R.id.multiplication);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!userInput.isEmpty()) {
                        firstNumber = Double.parseDouble(userInput);
                        selectedOperator = ((Button) v).getText().toString();
                        fullEquation += " " + selectedOperator + " ";
                        userInput = "";
                        targilView.setText(fullEquation);
                    }
                }
            });
        }
        {
            Button button = findViewById(R.id.divisor);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!userInput.isEmpty()) {
                        firstNumber = Double.parseDouble(userInput);
                        selectedOperator = ((Button) v).getText().toString();
                        fullEquation += " " + selectedOperator + " ";
                        userInput = "";
                        targilView.setText(fullEquation);
                    }
                }
            });
        }
    }

    private void calculateResult() {
        if (!userInput.isEmpty() && !selectedOperator.isEmpty()) {
            double secondNumber = Double.parseDouble(userInput);
            double result = 0;

            switch (selectedOperator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "X":
                    result = firstNumber * secondNumber;
                    break;
                case ":":
                    if (secondNumber != 0) {
                        result = firstNumber / secondNumber;
                    } else {
                        resultView.setText("Cannot divide by zero");
                        return;
                    }
                    break;
            }

            targilView.setText(fullEquation);
            resultView.setText(String.valueOf(result));
        }
    }

    private void clearCalculator() {
        userInput = "";
        firstNumber = 0;
        selectedOperator = "";
        fullEquation = "";
        targilView.setText("0");
        resultView.setText("");
    }
}