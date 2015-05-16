package com.example.barun.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Barun on 16/05/15.
 */
public class Data extends Activity implements View.OnClickListener{

    Button start, startFor;
    EditText sendET;
    TextView gotAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.get);
        initialize();
    }

    private void initialize(){
        start=(Button)findViewById(R.id.bSA);
        startFor=(Button)findViewById(R.id.bSAFR);
        sendET=(EditText)findViewById(R.id.etSend);
        gotAnswer=(TextView)findViewById(R.id.tvGot);
        start.setOnClickListener(this);
        startFor.setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bSA:
                String bread = sendET.getText().toString();
                Bundle basket = new Bundle();
                basket.putString("key", bread);
                Intent a = new Intent(Data.this, OpenedClass.class);
                a.putExtras(basket);
                startActivity(a);
                break;
            case R.id.bSAFR:
                break;
        }
    }
}
