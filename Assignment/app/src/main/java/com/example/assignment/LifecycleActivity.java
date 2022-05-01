package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class LifecycleActivity extends AppCompatActivity {

    private static final String TAG = "LogActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);

        Toast.makeText(this, "onCreate method called", Toast.LENGTH_LONG).show();
        Log.d(TAG, "OnCreate method called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "OnResume method called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "OnStart method called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "OnStop method called");
        //unregisterReceiver(bv);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "OnDestroy method called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "OnPause method called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "OnRestart method called");
    }

}