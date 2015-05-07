package com.example.barun.myapplication;

import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    int counter;
    Button add, sub;
    TextView display;
    MediaPlayer ourSong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ourSong=MediaPlayer.create(MainActivity.this,R.raw.shallow_bath_water_splash_001);
        counter=0;
        add=(Button)findViewById(R.id.bAdd);
        sub=(Button)findViewById(R.id.bSubtract);
        display=(TextView)findViewById(R.id.tvDisplay);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ourSong.start();
                counter++;
                display.setText("Your total is "+counter);

            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ourSong.start();
                counter--;
                display.setText("Your total is "+counter);
            }
        });
    }

    protected void onPause(){
        super.onPause();
        ourSong.release();
        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
