package com.route.basicsc39;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class CalculatorActivity extends AppCompatActivity {
    TextView resultTv;
    String operator = "";
    String lhs = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        resultTv = findViewById(R.id.resultTv);

    }

    public void onDigitClick(View v) {
        Button clickedDigit = (Button) v;
        if (resultTv.getText().toString().contains(".")) return;
        resultTv.append(clickedDigit.getText());
    }

    public void onOperatorClick(View v) {
        Button clickOperator = (Button) v;
        if (operator.isEmpty()) {
            lhs = resultTv.getText().toString();
        } else {
            String rhs = resultTv.getText().toString();
            lhs = calculate(lhs, operator, rhs);
        }
        operator = clickOperator.getText().toString();
        resultTv.setText("");
        Log.e("onOperatorClick", "lhs: " + lhs + ", operator: " + operator);

    }

    private String calculate(String lhs, String operator, String rhs) {
        double n1 = Double.parseDouble(lhs);
        double n2 = Double.parseDouble(rhs);

        if (Objects.equals(operator, "+")) {
            return ((Double) (n1 + n2)).toString();
        } else if (operator.equals("-")) {
            return ((Double) (n1 - n2)).toString();
        } else if ("/".equals(operator)) {
            return ((Double) (n1 / n2)).toString();
        } else {
            return ((Double) (n1 * n2)).toString();
        }

    }

    public void onEqualClick(View v) {
        String rhs = resultTv.getText().toString();
        resultTv.setText(calculate(lhs, operator, rhs));
        operator = "";
        lhs = "";
    }
}