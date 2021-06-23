package com.example.eva3_20_servicio_media_player;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyService extends Service {
    MediaPlayer mediaPlayer =  null;
    public MyService() {
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mediaPlayer != null){
            mediaPlayer.stop();
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = mediaPlayer.create(this,R.raw.twenty_one_pilots_shy_away);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        if(mediaPlayer != null){
            mediaPlayer.start();
        }

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}