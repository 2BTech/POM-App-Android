package com.twobtech.pomapp.Activities;





import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.twobtech.pomapp.R;

public class SignUpActivity extends AppCompatActivity {

    EditText emailField, passField, passConfField;
    Button signUpButton, termsButton, skipButton, loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        emailField = (EditText) findViewById(R.id.signUpEmail);
        passField = (EditText) findViewById(R.id.signUpPassword);
        passConfField = (EditText) findViewById(R.id.signUpConfirmPassword);

        signUpButton = (Button) findViewById(R.id.signUpButton);
        termsButton = (Button) findViewById(R.id.signUpTermsButton);
        skipButton = (Button) findViewById(R.id.signUpSkipButton);
        loginButton = (Button) findViewById(R.id.signUpLoginButton);

        /*skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMain();
            }
        });*/
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToLogin();
            }
        });
    }

    private void goToMain()
    {
        Intent mainIntent = new Intent(SignUpActivity.this, MainMenuActivity.class);
        SignUpActivity.this.startActivity(mainIntent);
        SignUpActivity.this.finish();
    }

    private void goToLogin() {
        Intent mainIntent = new Intent(SignUpActivity.this, LogInActivity.class);
        SignUpActivity.this.startActivity(mainIntent);
        SignUpActivity.this.finish();
    }
}
