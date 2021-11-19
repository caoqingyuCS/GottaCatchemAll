package com.example.dig4634.developedexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;

public class SettingsActivity extends AppCompatActivity implements MediaPlayer.OnPreparedListener{
    public static boolean hasmusic = false;
    Button btn1,btn3;
    private MediaPlayServices.MusicControl control;
    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            control = (MediaPlayServices.MusicControl) iBinder; //实例化
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        initView();
        Intent intent = new Intent(getApplicationContext(),MediaPlayServices.class);
        //startService(intent);
        bindService(intent,conn,BIND_AUTO_CREATE);
        hasmusic = true;
    }

    public void initView(){
        btn1 = (Button)findViewById(R.id.button2);
        //btn3 = (Button)findViewById(R.id.button7);
    }

    public void OnMusicStart(View view){
        control.play();
    }

    //public void OnMusicPause(View view){ control.pause(); }

    public void OnMusicStop(View view){
        control.pause();
    }

    @Override
    public void onDestroy() {
        control.stop();
        unbindService(conn);
        super.onDestroy();
    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

}
