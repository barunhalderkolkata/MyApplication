package com.example.barun.myapplication;

import android.app.Activity;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Barun on 21/06/15.
 */
public class SoundStuff extends Activity implements View.OnClickListener, View.OnLongClickListener{

    SoundPool sp;
    MediaPlayer mp;
    int explosion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v = new View(this);
        v.setOnClickListener(this);
        v.setOnLongClickListener(this);
        setContentView(v);

        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
            AudioAttributes aa = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build();
            sp = new SoundPool.Builder()
                    .setMaxStreams(5)
                    .setAudioAttributes(aa)
                    .build();
            explosion = sp.load(this, R.raw.explosion, 1);
        }
        else{
            sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
            explosion = sp.load(this, R.raw.explosion, 1);
        }

        mp = MediaPlayer.create(this, R.raw.backgroundmusic);

    }

    @Override
    public void onClick(View v) {
        if(explosion != 0){
            sp.play(explosion, 1, 1, 0, 0, 1);
        }
    }

    @Override
    public boolean onLongClick(View v) {
        mp.start();
        return false;
    }
}
