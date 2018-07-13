package com.twobtech.pomapp.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.zxing.Result;
import com.twobtech.pomapp.R;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

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

    public static class QRFragment extends Fragment implements ZXingScannerView.ResultHandler{

        private ZXingScannerView mScannerView;

        public QRFragment() {}

        @Override
        public void handleResult(Result rawResult)
        {
            Log.e("handler", rawResult.getText());
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle("Scan Result");
            builder.setMessage(rawResult.getText());
            AlertDialog alert1 = builder.create();
            alert1.show();
            mScannerView.resumeCameraPreview(this);
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.fragment_qr, container, false);

            mScannerView = view.findViewById(R.id.QR_Sub);
            mScannerView.setResultHandler(this);
            mScannerView.startCamera(0);

            return view;
        }

        @Override
        public void onAttach(Context context) {
            super.onAttach(context);
    //        mScannerView = getView().findViewById(R.id.QR_Sub);

        }
    }
}



