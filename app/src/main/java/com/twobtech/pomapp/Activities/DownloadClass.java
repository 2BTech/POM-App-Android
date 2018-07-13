package com.twobtech.pomapp.Activities;

import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadClass extends Thread implements DownloaderDelegate {

    Thread thread = null;
    public JSONObject target = null;
    public DownloaderDelegate delegate = this;
    String add;

    public DownloadClass()
    {

    }

    public DownloadClass(String url)
    {
        add = url;
        Runnable run = new Runnable() {
            @Override
            public void run() {
                doWork(add);
            }
        };
        thread = new Thread(run);
        thread.start();

    }

    private void doWork(String u)
    {
        try {
            URL url = new URL(u);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            target = new JSONObject(  getString(in));
            urlConnection.disconnect();
            delegate.updater();
        }catch (Exception e)
        {
            e.printStackTrace();
            Log.d("Threas", "Download");

        }
    }

    public String getString(InputStream stream)  throws IOException
    {
        int n = 0;
        char[] buffer = new char[1024 * 4];
        InputStreamReader reader = new InputStreamReader(stream, "UTF8");
        StringWriter writer = new StringWriter();
        while (-1 != (n = reader.read(buffer)))
        {
            writer.write(buffer, 0, n);
        }
        return writer.toString();
    }

    @Override
    public void updater()
    {

    }
}


