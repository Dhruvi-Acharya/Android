package com.example.sensorapplicationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class AccelerometerActivity extends AppCompatActivity implements SensorEventListener {

    TextView text;
    SensorManager sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);

        text = findViewById(R.id.tv_acc);


        sm = (SensorManager) getSystemService(SENSOR_SERVICE);

        if (sm != null) {
            Sensor accele = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            if (accele != null) {
                sm.registerListener(this,accele,sm.SENSOR_DELAY_NORMAL);

            }

        } else {
            Toast.makeText(getApplicationContext(),"Sensor service not detected",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}