package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

import androidx.annotation.Nullable;

public class NewService extends Service {
    private MediaPlayer ml;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
      //  ml = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        ml = MediaPlayer.create(getApplicationContext(),R.raw.music1);
        ml.setLooping(true);
        ml.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ml.stop();
    }
}
