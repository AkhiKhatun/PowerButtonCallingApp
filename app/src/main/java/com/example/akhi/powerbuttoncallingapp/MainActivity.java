package com.example.akhi.powerbuttoncallingapp;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private MyReceiver myReceiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.addAction(Intent.ACTION_USER_PRESENT);
        myReceiver = new MyReceiver();
        registerReceiver(myReceiver, filter);

    }
    @Override
    protected void onDestroy()
    {
        if (myReceiver != null)
        {
            unregisterReceiver(myReceiver);
            myReceiver = null;
        }
        super.onDestroy();
    }
}


