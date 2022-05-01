package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "LogActivity";
    Button btn, start, stop;
    ImageView iv;
    TextView tv;
    BatteryReceiver bv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "onCreate method called", Toast.LENGTH_LONG).show();
        Log.d(TAG, "OnCreate method called");

        btn = findViewById(R.id.btn_next);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent i = new Intent(getApplicationContext(), FirstActivity.class);
                Intent i = new Intent(getApplicationContext(), MainActivityTabbed.class);
                startActivity(i);
                //finish();
            }
        });

        start = findViewById(R.id.btn_start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(new Intent(getApplicationContext(), NewService.class));
            }
        });

        stop = findViewById(R.id.btn_stop);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(new Intent(getApplicationContext(), NewService.class));
            }
        });

        iv = findViewById(R.id.image_show);
        Intent i = getIntent();
        String action = i.getAction();
        String type = i.getType();

        if (Intent.ACTION_SEND.equals(action) && type != null) {
            iv.setImageURI(i.getParcelableExtra(Intent.EXTRA_STREAM));
        }

        tv = findViewById(R.id.text_battery);
        bv = new BatteryReceiver(tv);
        registerReceiver(bv,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
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
        unregisterReceiver(bv);
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