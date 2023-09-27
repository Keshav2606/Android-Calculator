package com.keshav.calci;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean isNewOperator = false;
    TextView txtResult,txtMain;
    String initialNumber;
    String operator = "";
    double output = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMain = findViewById(R.id.txtMain);
        txtResult = findViewById(R.id.txtResult);

    }

    public void numberEvent(View view) {

        if(!isNewOperator) {

            String number = txtMain.getText().toString();

            if (view.getId() == R.id.btnOne) {
                number += "1";
            } else if (view.getId() == R.id.btnTwo) {
                number += "2";
            } else if (view.getId() == R.id.btnThree) {
                number += "3";
            } else if (view.getId() == R.id.btnFour) {
                number += "4";
            } else if (view.getId() == R.id.btnFive) {
                number += "5";
            } else if (view.getId() == R.id.btnSix) {
                number += "6";
            } else if (view.getId() == R.id.btnSeven) {
                number += "7";
            } else if (view.getId() == R.id.btnEight) {
                number += "8";
            } else if (view.getId() == R.id.btnNine) {
                number += "9";
            } else if (view.getId() == R.id.btnZero) {
                number += "0";
            } else if (view.getId() == R.id.btnDZero) {
                number += "00";
            } else if (view.getId() == R.id.btnDot) {
                number += ".";
            }
            txtMain.setText(number);
            txtResult.setText("="+number);
        }else{
            String newNumber = "";
            if (view.getId() == R.id.btnOne) {
                newNumber += "1";
            } else if (view.getId() == R.id.btnTwo) {
                newNumber += "2";
            } else if (view.getId() == R.id.btnThree) {
                newNumber += "3";
            } else if (view.getId() == R.id.btnFour) {
                newNumber += "4";
            } else if (view.getId() == R.id.btnFive) {
                newNumber += "5";
            } else if (view.getId() == R.id.btnSix) {
                newNumber += "6";
            } else if (view.getId() == R.id.btnSeven) {
                newNumber += "7";
            } else if (view.getId() == R.id.btnEight) {
                newNumber += "8";
            } else if (view.getId() == R.id.btnNine) {
                newNumber += "9";
            } else if (view.getId() == R.id.btnZero) {
                newNumber += "0";
            } else if (view.getId() == R.id.btnDZero) {
                newNumber += "00";
            } else if (view.getId() == R.id.btnDot) {
                newNumber += ".";
            }
            txtMain.append(newNumber);
            equal(view);

        }
    }

    public void operatorEvent(View view) {

        isNewOperator = true;
        if(output != 0.0){
            initialNumber = String.valueOf(output);
            txtMain.setText(initialNumber);
            txtMain.setTextSize(40);
            txtResult.setTextSize(30);
            txtResult.setTextColor(getResources().getColor(R.color.gray));
        }

        if(view.getId() == R.id.btnMultiply){
            operator = "*";}

        else if(view.getId() == R.id.btnMinus){
            operator = "-";}

        else if(view.getId() == R.id.btnDivide){
            operator = "/";}

        else if(view.getId() == R.id.btnPlus){
            operator = "+";
        }
        txtMain.append(operator);
    }

    public void equal(View view) {
        int index = txtMain.getText().toString().lastIndexOf(operator);
        if(initialNumber==null)
            initialNumber = txtMain.getText().toString().substring(0,index);
        String newNumber = txtMain.getText().toString().substring(index+1);

        if(operator.equals("+"))
            output = Double.parseDouble(initialNumber) + Double.parseDouble(newNumber);

        if(operator.equals("/"))
            output = Double.parseDouble(initialNumber) / Double.parseDouble(newNumber);

        if(operator.equals("*"))
            output = Double.parseDouble(initialNumber) * Double.parseDouble(newNumber);

        if(operator.equals("-"))
            output = Double.parseDouble(initialNumber) - Double.parseDouble(newNumber);

        txtResult.setText("="+output);

    }

    public void equalEvent(View view){
        txtResult.setTextSize(40);
        txtResult.setTextColor(this.getResources().getColor(R.color.white));
        txtMain.setTextSize(30);
    }


    public void clearEvent(View view) {
        txtMain.setText("");
        txtResult.setText("");
        isNewOperator = false;
        output = 0.0;
    }

    public void delEvent(View view){
        int lastIndex = txtMain.getText().toString().length();
        txtMain.setText(txtMain.getText().toString().substring(0,lastIndex-1));
        txtResult.setText(txtMain.getText().toString().substring(0,lastIndex-1));
        if(txtMain.getText().toString().equals(""))
            clearEvent(view);
    }

    public void percentEvent(View view) {
        double num;
        int lastIndex = txtMain.getText().toString().lastIndexOf(operator);
        if(operator == "*" || operator == "/") {
            num = Double.parseDouble(txtMain.getText().toString().substring(lastIndex + 1)) / 100;
        }else{
            num = Double.parseDouble(txtMain.getText().toString().substring(0,lastIndex))/100;
        }
        txtMain.setText(txtMain.getText().toString().substring(0,lastIndex+1) + num);
        equal(view);
        isNewOperator = true;

    }
}