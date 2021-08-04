package com.example.mad_tute_02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_value;
    RadioButton btn_celcius;
    RadioButton btn_farenheight;
    Button btn_calculate;
    TextView tv_displayAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_value = findViewById(R.id.enterTemp);
        btn_celcius = findViewById(R.id.btn_celsius);
        btn_farenheight= findViewById(R.id.btn_farenheight);
        btn_calculate= findViewById(R.id.btn_calculate);
        tv_displayAnswer= findViewById(R.id.txt_answer);

    }
    @Override
    protected void onResume() {
        super.onResume();
        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAnswer();
            }
        });
    }

    private void calculateAnswer() {
        Calculations cal = new Calculations();
        String temp_value = et_value.getText().toString();

        if(TextUtils.isEmpty(temp_value)){
            Toast.makeText(this, "Please enter a temperature value", Toast.LENGTH_LONG).show();
        }

 else{
            float temp = Float.parseFloat(temp_value);
            if(btn_celcius.isChecked()){
                temp = cal.convertCelciusToFahrenheit(temp);
            }
            else if(btn_farenheight.isChecked()){
                temp = cal.convertFahrenheitToCelcius(temp);
            }
            else{
                Toast.makeText(this, "Select Radio", Toast.LENGTH_LONG).show();
                temp = 0.0f;
            }
            tv_displayAnswer.setText(new Float(temp).toString());
        }

    }
}