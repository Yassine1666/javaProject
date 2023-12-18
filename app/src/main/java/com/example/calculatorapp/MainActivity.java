package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnAc,btnDel,btndivide
            ,btnMultiply,btnMines,btnpoint,btnPlus,btnequal;
    private TextView TextViewHistory,TextViewResult;
    String number=null;
    double firstNumber=0;
    double lastNumber=0;
    String status=null;
    boolean operator =false;
    DecimalFormat myformat = new DecimalFormat("######.######");
    String history,currentresult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn0=findViewById(R.id.btn0);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);
        btnAc=findViewById(R.id.btnAc);
        btnDel=findViewById(R.id.btnDel);
        btndivide=findViewById(R.id.btndivide);
        btnMultiply=findViewById(R.id.btnMultiply);
        btnMines=findViewById(R.id.btnMines);
        btnpoint=findViewById(R.id.btnpoint);
        btnPlus=findViewById(R.id.btnPlus);
        TextViewHistory=findViewById(R.id.TextViewHistory);
        TextViewResult=findViewById(R.id.TextViewResult);
        btnequal=findViewById(R.id.btnequal);
        btnpoint=findViewById(R.id.btnpoint);
        btnpoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(number ==null){
                    number ="0.";
                }
                else {
                    number =number+ ".";
                }
                TextViewResult.setText((number));
            }
        });
        btnAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number =null ;
                status = null ;
                TextViewResult.setText("0");
                TextViewHistory.setText("");
                firstNumber = 0;
                lastNumber = 0;

            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number = number.substring(0,number.length()-1);
                TextViewResult.setText(number);
            }
        });
        btnequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operator){
                    if(status == "multiplacition"){
                        Multiply();
                    } else if (status == "division") {
                        Divide();

                    } else if (status == "subtraction") {
                        Mines();
                    }else if(status =="sum" ){
                        plus();
                    }else {
                        firstNumber = Double.parseDouble(TextViewResult.getText().toString());
                    }
                }
                operator =false ;
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                history = TextViewHistory.getText().toString();
                currentresult =TextViewResult.getText().toString();
                TextViewHistory.setText(history+currentresult+"+");
                if (operator){
                    if(status == "multiplacition"){
                        Multiply();
                    } else if (status == "division") {
                        Divide();
                        
                    } else if (status == "subtraction") {
                        Mines();
                    }else{
                        plus();
                    }
                }
                status= "sum";
                operator = false;
                number = null;
            }
        });
        btndivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                history = TextViewHistory.getText().toString();
                currentresult =TextViewResult.getText().toString();
                TextViewHistory.setText(history+currentresult+"/");
                if (operator){
                    if(status == "multiplacition"){
                        Multiply();
                    } else if (status == "sum") {
                        plus();

                    } else if (status == "subtraction") {
                        Mines();
                    }else{
                        Divide();
                    }
                }
                status= "division";
                operator = false;
                number = null;

            }
        });
        btnMines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                history = TextViewHistory.getText().toString();
                currentresult =TextViewResult.getText().toString();
                TextViewHistory.setText(history+currentresult+"-");
                if (operator){
                    if(status == "multiplacition"){
                        Multiply();
                    } else if (status == "sum") {
                        plus();

                    } else if (status == "division") {
                        Divide();
                    }else{
                        Mines();
                    }
                }
                status= "subtraction";
                operator = false;
                number = null;
            }
        });
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                history = TextViewHistory.getText().toString();
                currentresult =TextViewResult.getText().toString();
                TextViewHistory.setText(history+currentresult+"*");
                if (operator){
                    if(status == "division"){
                        Divide();
                    } else if (status == "sum") {
                        plus();

                    } else if (status == "subtraction") {
                        Mines();
                    }else{
                        Multiply();
                    }
                }
                status= "multiplacition";
                operator = false;
                number = null;
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("9");
            }
        });



    }
    public void numberClick(String view){
        if (number==null){
            number=view;
        }else{
            number=number + view;
        }
        TextViewResult.setText(number);
        operator = true;

    }
    public void plus(){
        lastNumber = Double.parseDouble(TextViewResult.getText().toString());
        firstNumber =firstNumber + lastNumber;
        TextViewResult.setText(myformat.format(firstNumber));
    }
    public void Mines(){
        if (firstNumber == 0){
            firstNumber = Double.parseDouble(TextViewResult.getText().toString());
        }else{
            lastNumber = Double.parseDouble(TextViewResult.getText().toString());
            firstNumber =firstNumber - lastNumber;
        }
        TextViewResult.setText(myformat.format(firstNumber));
    }
    public void Multiply(){
        if (firstNumber == 0){
            firstNumber=1;
            lastNumber = Double.parseDouble(TextViewResult.getText().toString());
            firstNumber =firstNumber * lastNumber;
        }else{
            lastNumber = Double.parseDouble(TextViewResult.getText().toString());
            firstNumber =firstNumber * lastNumber;
        }
        TextViewResult.setText(myformat.format(firstNumber));
    }
    public void Divide(){
        if(firstNumber==0){
            lastNumber = Double.parseDouble(TextViewResult.getText().toString());
            firstNumber = lastNumber / 1;
        }else{
            lastNumber = Double.parseDouble(TextViewResult.getText().toString());
            firstNumber = firstNumber / lastNumber ;
        }
        TextViewResult.setText(myformat.format(firstNumber));
    }
}