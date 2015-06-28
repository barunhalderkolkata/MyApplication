package com.example.barun.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;

/**
 * Created by Barun on 22/06/15.
 */
public class Tabs extends Activity implements View.OnClickListener{

    TabHost th;
    TextView showResults;
    long start, stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabs);
        th = (TabHost) findViewById(R.id.tabHost);
        Button newTab = (Button) findViewById(R.id.bAddTab);
        Button bStart = (Button) findViewById(R.id.bStartWatch);
        Button bStop = (Button) findViewById(R.id.bStopWatch);
        showResults = (TextView) findViewById(R.id.tvShowResults);
        start = stop = 0;


        newTab.setOnClickListener(this);
        bStart.setOnClickListener(this);
        bStop.setOnClickListener(this);

        th.setup();
        TabHost.TabSpec specs = th.newTabSpec("tag1");
        specs.setContent(R.id.tab1);
        specs.setIndicator("StopWatch");
        th.addTab(specs);
        specs = th.newTabSpec("tag2");
        specs.setContent(R.id.tab2);
        specs.setIndicator("Tab 2");
        th.addTab(specs);
        specs = th.newTabSpec("tag3");
        specs.setContent(R.id.tab3);
        specs.setIndicator("Add a Tab ");
        th.addTab(specs);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bAddTab:
                TabHost.TabSpec ourSpec = th.newTabSpec("tag1");
                ourSpec.setContent(new TabHost.TabContentFactory(){
                    public View createTabContent(String tag){
                        TextView text = new TextView(Tabs.this);
                        text.setText("you've created a new Tab!");
                        return text;
                    }
                });
                ourSpec.setIndicator("New");
                th.addTab(ourSpec);
                break;
            case R.id.bStartWatch:
                start = System.currentTimeMillis();
                break;
            case R.id.bStopWatch:

                if(start!=0){
                    stop = System.currentTimeMillis();
                    long result = stop - start;
                    showResults.setText(Long.toString(result));
                    start = 0;
                }

                break;
        }
    }
}
