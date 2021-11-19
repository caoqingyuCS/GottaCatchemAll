package com.example.dig4634.developedexample;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.Timer;

public class MediaPlayServices extends Service {

    private MediaPlayer mediaplayer;

   //构造函数
    public MediaPlayServices(){}

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
            return new MusicControl();//把音乐控制类实例化
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaplayer = new MediaPlayer();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    class MusicControl extends Binder {
        public void play(){
                mediaplayer.reset();
                mediaplayer = MediaPlayer.create(getApplicationContext(),R.raw.music);
                mediaplayer.setLooping(true);
                mediaplayer.start();
        }
        public void pause(){
            if(mediaplayer.isPlaying()){
                mediaplayer.pause();
            }
        }
        public void resume(){
            mediaplayer.start();
        }
        public void stop(){
            mediaplayer.stop();
            mediaplayer.release();
        }
    }
}
