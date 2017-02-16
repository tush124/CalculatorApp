package com.silverglobesoft.www.calculatorsg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {

    TextView textViewNumberExpression, textViewResult;
    Button buttonNumberOne, buttonNumberTwo, buttonNumberThree, buttonNumberFour, buttonNumberFive;
    Button buttonNumberSix, buttonNumberSeven, buttonNumberEight, buttonNumberNine;
    Button buttonDot, buttonZero, buttonEqual;
    Button buttonDelete, buttonDivide, buttonMultiply, buttonMinus, buttonPlus, buttonClear;

    Boolean flagDot = true;
    String result = "";
    String expression = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewNumberExpression = (TextView) findViewById(R.id.textViewNumberExpression);
        textViewResult = (TextView) findViewById(R.id.textViewResult);

        buttonNumberOne = (Button) findViewById(R.id.buttonNumberOne);
        buttonNumberTwo = (Button) findViewById(R.id.buttonNumberTwo);
        buttonNumberThree = (Button) findViewById(R.id.buttonNumberThree);
        buttonNumberFour = (Button) findViewById(R.id.buttonNumberFour);
        buttonNumberFive = (Button) findViewById(R.id.buttonNumberFive);
        buttonNumberSix = (Button) findViewById(R.id.buttonNumberSix);
        buttonNumberSeven = (Button) findViewById(R.id.buttonNumberSeven);
        buttonNumberEight = (Button) findViewById(R.id.buttonNumberEight);
        buttonNumberNine = (Button) findViewById(R.id.buttonNumberNine);

        buttonDot = (Button) findViewById(R.id.buttonDot);
        buttonZero = (Button) findViewById(R.id.buttonZero);
        buttonClear = (Button)findViewById(R.id.buttonClear);
        buttonEqual = (Button) findViewById(R.id.buttonEqaul);

        buttonDivide = (Button) findViewById(R.id.buttonDivide);
        buttonMultiply = (Button) findViewById(R.id.buttonMultiply);
        buttonMinus = (Button) findViewById(R.id.buttonMinus);
        buttonPlus = (Button)findViewById(R.id.buttonPlus);

        buttonDelete = (Button)findViewById(R.id.buttonDelete);
        buttonNumberOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = expression + "1";
                updateTextViewExpression();
            }
        });

        buttonNumberTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = expression + "2";
                updateTextViewExpression();
            }
        });

        buttonNumberThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = expression + "3";
                updateTextViewExpression();
            }
        });

        buttonNumberFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = expression + "4";
                updateTextViewExpression();
            }
        });

        buttonNumberFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = expression + "5";
                updateTextViewExpression();
            }
        });

        buttonNumberSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = expression + "6";
                updateTextViewExpression();
            }
        });

        buttonNumberSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = expression + "7";
                updateTextViewExpression();
            }
        });

        buttonNumberEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = expression + "8";
                updateTextViewExpression();
            }
        });

        buttonNumberNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = expression + "9";
                updateTextViewExpression();
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flagDot) {
                    expression = expression + ".";
                    updateTextViewExpression();
                    flagDot = false;
                }
            }
        });

        buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = expression + "0";
                updateTextViewExpression();
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = expression + "/";
                updateTextViewExpression();
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = expression + "*";
                updateTextViewExpression();
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = expression + "-";
                updateTextViewExpression();
            }
        });

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = expression + "+";
                updateTextViewExpression();
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (expression.length() != 0) {
                    if (expression.charAt(expression.length() - 1) == '.') {
                        flagDot = true;
                    }
                    expression = expression.substring(0, expression.length() - 1);
                    updateTextViewExpression();
                }
                if (expression.length() == 0){
                    textViewResult.setText("");
                }
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateExpression();
                textViewNumberExpression.setText(textViewResult.getText());
                textViewResult.setText("");
                expression = "";
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewResult.setText("");
                textViewNumberExpression.setText("");
                expression = "";
            }
        });

    }

    private void updateTextViewExpression() {
        textViewNumberExpression.append(expression);
        calculateExpression();
    }

    private void calculateExpression() {

        try{
            Expression expressionBuild = new ExpressionBuilder(expression).build();
            double result1 = expressionBuild.evaluate();
            textViewResult.setText(Double.toString(result1));


        }catch(Exception e){
            Log.e("Exception : ","message : " + e.toString());
        }
    }
}
