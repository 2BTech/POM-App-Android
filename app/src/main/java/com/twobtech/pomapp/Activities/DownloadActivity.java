package com.twobtech.pomapp.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.twobtech.pomapp.R;

import org.json.JSONObject;

public class DownloadActivity extends AppCompatActivity implements DownloaderDelegate {

    private DownloadClass download;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        downloadContent("https://citizenair.org/airin");
    }

    private void downloadContent(String url)
    {
        download = new DownloadClass(url);
        download.delegate = this;
    }

    @Override
    public void updater(){
        try {
            JSONObject j = download.target;
            Log.d("Hi", j.toString(4));
            int n = 0;
        }
        catch (Exception e)
        {
            Log.d("JSON Reader", "Failed");
        }

        int i = 0;


        /*Log.e("handler", rawResult.getText());
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Scan Result");
        builder.setMessage(rawResult.getText());
        AlertDialog alert1 = builder.create();
        alert1.show();
        mScannerView.resumeCameraPreview(this);*/
    }
}