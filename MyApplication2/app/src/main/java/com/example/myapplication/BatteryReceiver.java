package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

public class BatteryReceiver extends BroadcastReceiver {
    TextView tv;

    BatteryReceiver(TextView tv) {
        this.tv = tv;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        int per = intent.getIntExtra("level", 0);
        if (per != 0) {
            tv.setText(per + "%");
        }
    }
}
