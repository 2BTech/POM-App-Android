package com.twobtech.pomapp.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.common.SignInButton;
import com.twobtech.pomapp.R;

public class LogInActivity extends AppCompatActivity {

    EditText emailField, passField;
    Button loginButton, forgotButton, skipButton, signUpButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        SharedPreferences pref = this.getSharedPreferences("SavedData", Context.MODE_PRIVATE);
        if(pref.contains("UserID")) {
            goToMain();
            return;
        }


        emailField = (EditText) findViewById(R.id.loginEmail);
        passField = (EditText) findViewById(R.id.loginPassword);

        loginButton = (Button) findViewById(R.id.loginLoginButton);
        forgotButton = (Button) findViewById(R.id.loginForgotButton);
        skipButton = (Button) findViewById(R.id.loginSkipButton);
        signUpButton = (Button) findViewById(R.id.loginSignUpButton);

        forgotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToForgotPassword();
            }
        });
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMain();
            }
        });
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSignUp();
            }
        });
    }

    private void goToForgotPassword() {
        Intent mainIntent = new Intent(LogInActivity.this, ForgotPasswordActivity.class);
        LogInActivity.this.startActivity(mainIntent);
        LogInActivity.this.finish();
    }

    public void goToSignUp() {
        Intent mainIntent = new Intent(LogInActivity.this, SignUpActivity.class);
        LogInActivity.this.startActivity(mainIntent);
        LogInActivity.this.finish();
    }

    public void goToMain() {
        Intent mainIntent = new Intent(LogInActivity.this, MainMenuActivity.class);
        LogInActivity.this.startActivity(mainIntent);
        LogInActivity.this.finish();
    }
}
