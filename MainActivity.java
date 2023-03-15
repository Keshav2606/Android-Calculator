package com.keshav.calci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean isNewOperator = false;
    EditText edt1;
    TextView txtResult;
    String initialNumber;
    String operator = "";
    double output = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = findViewById(R.id.editText);
        txtResult = findViewById(R.id.txtResult);

    }

    public void numberEvent(View view) {

        if(!isNewOperator) {

            String number = edt1.getText().toString();

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
            edt1.setText(number);
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
            edt1.append(newNumber);

        }
    }

    public void operatorEvent(View view) {

        isNewOperator = true;
        if(output != 0.0){
            initialNumber = String.valueOf(output);
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
        edt1.append(operator);

    }

    public void equalEvent(View view) {
        int index = edt1.getText().toString().lastIndexOf(operator);
        if(initialNumber==null)
            initialNumber = edt1.getText().toString().substring(0,index);
        String newNumber = edt1.getText().toString().substring(index+1);

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


    public void clearEvent(View view) {
        edt1.setText("");
        txtResult.setText("");
        isNewOperator = false;
        output = 0.0;
    }

    public void delEvent(View view){
        int lastIndex = edt1.getText().toString().length();
        edt1.setText(edt1.getText().toString().substring(0,lastIndex-1));
        if(edt1.getText().toString().equals(""))
            clearEvent(view);
    }

    public void percentEvent(View view) {
        double num = Double.parseDouble(edt1.getText().toString())/100;
        edt1.setText(num+"");
        isNewOperator = true;

    }
}