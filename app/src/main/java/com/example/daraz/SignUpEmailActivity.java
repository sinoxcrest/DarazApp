package com.example.daraz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.daraz.Url.Url;
import com.example.daraz.api.UserAPI;
import com.example.daraz.model.Users;
import com.example.daraz.serverresponse.SignUpResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpEmailActivity extends AppCompatActivity {
    EditText FullName,Email,Password;
    Button btnSignup;
    CheckBox chkb;
    boolean ischecked = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_email);
        FullName = findViewById(R.id.etFullName);
        Email = findViewById(R.id.etemail);
        Password = findViewById(R.id.etpassword);
        btnSignup = findViewById(R.id.btnsubmit);
        chkb = findViewById(R.id.checkbox);

        final Bundle bundle = getIntent().getExtras();



        chkb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ischecked = true;
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(FullName.getText().toString()))
                {
                    FullName.setError("Mandatory Field");
                    return;
                }
                else if (TextUtils.isEmpty(Password.getText().toString())){
                    Password.setError("Mandatory Field");
                    return;
                }
                else if (TextUtils.isEmpty(Email.getText().toString())){
                    Email.setError("Mandatory Field");
                    return;
                }
                else if (ischecked = false){
                    chkb.setError("Mandatory Field");
                    return;
                }

                String PhoneNo = bundle.getString("PhoneNo");
                String SMS = bundle.getString("SMS");
                String Name = FullName.getText().toString();
                String email = Email.getText().toString();
                String password = Password.getText().toString();

                Users users = new Users(Name, email, password,PhoneNo, SMS);

                UserAPI usersAPI = Url.getInstance().create(UserAPI.class);
                Call<SignUpResponse> signUpCall = usersAPI.registerUser(users);

                signUpCall.enqueue(new Callback<SignUpResponse>() {
                    @Override
                    public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                        if (!response.isSuccessful()) {
                            Toast.makeText(SignUpEmailActivity.this, "Code " + response.code(), Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Toast.makeText(SignUpEmailActivity.this, "Registered", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<SignUpResponse> call, Throwable t) {
                        Toast.makeText(SignUpEmailActivity.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });            }
        });
    }
}
