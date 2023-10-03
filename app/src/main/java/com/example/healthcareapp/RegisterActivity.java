package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText edUserNameReg, edEmail, edPasswordReg, edConfirmPassword;
    Button btnRegister;
    TextView tvBackToLogin;
    TextView alreadyHaveAnAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edUserNameReg = findViewById(R.id.editTxtUserNameReg);
        edEmail = findViewById(R.id.editTxtEmail);
        edPasswordReg = findViewById(R.id.editTxtRegPass);
        edConfirmPassword = findViewById(R.id.editTxtConfirmPass);
        btnRegister = findViewById(R.id.btnRegister);
        tvBackToLogin = findViewById(R.id.txtBackToLogin);
        //redirect to login form reg if already exist an account
        tvBackToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View view){
                String userNameReg = edUserNameReg.getText().toString();
                String emailReg = edEmail.getText().toString();
                String passReg = edPasswordReg.getText().toString();
                String confirmPassReg = edConfirmPassword.getText().toString();

                if (userNameReg.length() == 0 && emailReg.length() == 0 && passReg.length() == 0 && passReg.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please fill all details", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (passReg.compareTo(confirmPassReg) == 0) {
                        if (isValid(passReg)) {
                            Toast.makeText(getApplicationContext(), "Record Inserted!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "Password must contain 8 characters, having letter, digit and special symbol!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Password and confirm password didn't match!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    public static boolean isValid(String pass){
        int f1=0, f2=0, f3=0;
        if(pass.length()<8){
            return false;
        }else{
            for (int p = 0; p<pass.length(); p++){
                if(Character.isLetter(pass.charAt(p))){
                    f1=1;
                }
            }
            for (int r = 0; r<pass.length(); r++){
                if(Character.isDigit(pass.charAt(r))){
                    f2=1;
                }
            }
            for (int s = 0; s<pass.length(); s++){
                char c = pass.charAt(s);
                if(c>=33&&c<=46||c==64){
                    f3=1;
                }
            }
            if(f1==1 && f2==1 && f3==1)
                return true;
            return false;
        }
    }
}