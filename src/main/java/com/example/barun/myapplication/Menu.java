package com.example.barun.myapplication;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Barun on 18/04/15.
 */
public class Menu extends ListActivity {

    String classes[] = {"MainActivity","TextPlay","Email","Camera","example4","example5","example6"};
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(Menu.this,R.layout.simple_text_layout ,classes));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);
        String cheese = classes[position];

        try {
        Class ourClass = Class.forName("com.example.barun.myapplication."+cheese);
        Intent ourIntent = new Intent(Menu.this,ourClass);
        startActivity(ourIntent);
        }catch(ClassNotFoundException e){
        e.printStackTrace();
        }
    }
}
