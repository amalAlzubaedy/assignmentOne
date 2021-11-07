package edu.cs.birziet.amalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class BMI extends AppCompatActivity {
    EditText weight,height;
    TextView resultText;
    String calculation,BMIresult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        weight=findViewById(R.id.edtWight);
        height=findViewById(R.id.edtHight);
        resultText=findViewById(R.id.txtResult);



    }

    public void calculatBMI(View view) {
        String s1 = weight.getText().toString();
        String s2 = height.getText().toString();
        float weightValu= Float.parseFloat(s1);
        float heightValu= Float.parseFloat(s2) / 100;
        float bmi = weightValu /(heightValu*heightValu);
        if(bmi<16) {
            BMIresult = "severly under weight";
        }
        else if(bmi < 18.5){
            BMIresult = "under weight";
        }
        else if(bmi < 18.5 && bmi <= 24.9) {
            BMIresult = "Normal weight";
        }

        else if ((bmi>= 25 && bmi<=29.9)){
            BMIresult="OverWeight";
        }
        else {
            BMIresult=" Obese";
        }
        calculation= "Result:\n\n" +bmi+ "\n"+BMIresult;
        resultText.setText(calculation);


    }
}