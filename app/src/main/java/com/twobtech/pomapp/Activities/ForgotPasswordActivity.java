package com.twobtech.pomapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.twobtech.pomapp.R;

public class ForgotPasswordActivity extends AppCompatActivity {

    EditText emailField;
    Button submitButton, loginButton, signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        emailField = (EditText) findViewById(R.id.forgotEmail);
        submitButton = (Button) findViewById(R.id.forgotSubmitButton);
        loginButton = (Button) findViewById(R.id.forgotLogInButton);
        signupButton = (Button) findViewById(R.id.forgotSignUpButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToLogin();
            }
        });
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSignup();
            }
        });
    }

    private void goToLogin()
    {
        Intent mainIntent = new Intent(ForgotPasswordActivity.this, LogInActivity.class);
        ForgotPasswordActivity.this.startActivity(mainIntent);
        ForgotPasswordActivity.this.finish();
    }

    private void goToSignup()
    {
        Intent mainIntent = new Intent(ForgotPasswordActivity.this, SignUpActivity.class);
        ForgotPasswordActivity.this.startActivity(mainIntent);
        ForgotPasswordActivity.this.finish();
    }
}



