package com.example.daraz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.daraz.bll.LoginBll;
import com.example.daraz.strictmode.StrictModeClass;

public class LoginActivity extends AppCompatActivity {

    private EditText Email,Password;
    private TextView tvCR;
    private Button btnLog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvCR = findViewById(R.id.tvCR);
        Email = findViewById(R.id.etem);
        Password = findViewById(R.id.etp);
        btnLog = findViewById(R.id.btnLog);

        tvCR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

    }

    private void login() {
        String email = Email.getText().toString();
        String password = Password.getText().toString();

        LoginBll loginBLL = new LoginBll();

        StrictModeClass.StrictMode();
        if (loginBLL.checkUser(email, password)) {
            Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Either username or password is incorrect", Toast.LENGTH_SHORT).show();
            Email.requestFocus();
        }
    }
}