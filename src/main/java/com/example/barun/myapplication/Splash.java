package com.example.barun.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

/**
 * Created by Barun on 16/04/15.
 */
public class Splash extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
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
