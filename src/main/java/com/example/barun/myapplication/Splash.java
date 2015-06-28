package com.example.barun.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

/**
 * Created by Barun on 16/04/15.
 */
public class Splash extends Activity {
    MediaPlayer ourSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        ourSong = MediaPlayer.create(Splash.this, R.raw.shallow_bath_water_splash_001);

        SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean music = getPrefs.getBoolean("checkbox", true);
        if(music)
             ourSong.start();

        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent openStartingPoint = new Intent("com.example.barun.myapplication.MENU");
                    startActivity(openStartingPoint);
                }
            }
        };
        timer.start();
    }

    protected void onPause(){
        super.onPause();
        finish();
    }
}
