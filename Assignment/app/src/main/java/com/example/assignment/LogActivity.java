package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class LogActivity extends AppCompatActivity {
    private static final String LOG_TAG = "LogActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        Log.v(LOG_TAG,"This is verbose log");
        Log.d(LOG_TAG,"This is debug log");
        Log.i(LOG_TAG,"This is info log");
        Log.w(LOG_TAG,"This is warn log");
        Log.e(LOG_TAG,"This is error log");
    }
}