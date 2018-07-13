package com.twobtech.pomapp.Activities;

import android.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.twobtech.pomapp.R;

public class MainViewActivity extends AppCompatActivity {

    Button leftButton, rightButton;

    Fragment[] fragments = new Fragment[5];
    int currentNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view);

        leftButton = findViewById(R.id.main_Left);
        rightButton = findViewById(R.id.main_Right);
    }


}
