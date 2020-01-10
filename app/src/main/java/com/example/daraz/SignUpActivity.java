package com.example.daraz;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class SignUpActivity extends AppCompatActivity {

    EditText PhoneNo, SMS;
    Button btnNext, btnSend,btn1;
    TextView tvL;
    int min = 1;
    int max = 100000;

    Random r = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        PhoneNo = findViewById(R.id.etNo);
        btnNext = findViewById(R.id.btnNext);
        tvL = findViewById(R.id.tvL);
        SMS = findViewById(R.id.etsms);
        btnSend = findViewById(R.id.button2);
        btn1=findViewById(R.id.button);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(PhoneNo.getText().toString()))
                {
                    PhoneNo.setError("Mandatory Field");
                    return;
                }
                Thread thread = new Thread(){
                    @Override
                    public void run() {
                        try {
                            sleep(1000);
                            int I1 = r.nextInt(max - min + 1) + min;
                            SMS.setText(Integer.toString(I1));
                        }   catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                    }
                };
                thread.start();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(PhoneNo.getText().toString()))
                {
                    PhoneNo.setError("Mandatory Field");
                    return;
                }
                else if (TextUtils.isEmpty(SMS.getText().toString())){
                    SMS.setError("Mandatory Field");
                    return;
                }
                Intent intent = new Intent(SignUpActivity.this, SignUpEmailActivity.class);
                startActivity(intent);
            }
        });

        tvL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

btn1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(SignUpActivity.this, SignUpEmailActivity.class);
        startActivity(intent);
    }
});
    }
}