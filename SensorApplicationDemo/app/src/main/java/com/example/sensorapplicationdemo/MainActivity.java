package com.example.sensorapplicationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView text;
    SensorManager sm;
    Button b1, b2, b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.tv);
        text.setVisibility(View.GONE);

        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> mlist = sm.getSensorList(Sensor.TYPE_ALL);

        for (int i = 1; i < mlist.size(); i++) {
            text.setVisibility(View.VISIBLE);
            text.append("\n" + mlist.get(i).getName());
        }

        b1 = findViewById(R.id.btn_pro);
        b2 = findViewById(R.id.btn_acc);
        b3 = findViewById(R.id.btn_light);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ProximityActivity.class);
                startActivity(i);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AccelerometerActivity.class);
                startActivity(i);
            }
        });
    }
}