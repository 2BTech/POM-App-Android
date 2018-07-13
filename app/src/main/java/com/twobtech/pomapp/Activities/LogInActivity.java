package com.twobtech.pomapp.Activities;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Camera;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.common.SignInButton;
import com.twobtech.pomapp.R;
import com.twobtech.pomapp.TestActivity;

public class LogInActivity extends AppCompatActivity {

    EditText emailField, passField;
    Button loginButton, forgotButton, skipButton, signUpButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        SharedPreferences pref = this.getSharedPreferences("SavedData", Context.MODE_PRIVATE);
        if(pref.contains("UserID")) {

            goToTest();
            //goToMain();
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
        goToTest();
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

    public void goToTest() {
        Intent mainIntent = new Intent(LogInActivity.this, TestActivity.class);
        LogInActivity.this.startActivity(mainIntent);
        LogInActivity.this.finish();
    }
}
