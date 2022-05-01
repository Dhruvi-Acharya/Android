package com.example.sensorapplicationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class ProximityActivity extends AppCompatActivity implements SensorEventListener {

    TextView text;
    LinearLayout l;
    SensorManager sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity);

        text = findViewById(R.id.tv2);
        l = findViewById(R.id.linear);

        sm = (SensorManager) getSystemService(SENSOR_SERVICE);

        if (sm != null) {
            Sensor proximity = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
            if (proximity != null) {
                sm.registerListener(this, proximity, sm.SENSOR_DELAY_NORMAL);
            }

        } else {
            Snackbar s = Snackbar.make(l, "Sensor service not detected", Snackbar.LENGTH_LONG);
            s.show();
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == Sensor.TYPE_PROXIMITY) {
            text.setText("Proximity: " + sensorEvent.values[0]);
        }

        if (sensorEvent.values[0] > 0) {
            WindowManager.LayoutParams lp = getWindow().getAttributes();
            lp.screenBrightness = -1;
            getWindow().setAttributes(lp);
        }
        else {
            Toast.makeText(this, "High", Toast.LENGTH_SHORT).show();
            WindowManager.LayoutParams params = getWindow().getAttributes();
            params.screenBrightness = -1;
            getWindow().setAttributes(params);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}