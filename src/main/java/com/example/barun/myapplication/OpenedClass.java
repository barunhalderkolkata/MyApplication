package com.example.barun.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by Barun on 16/05/15.
 */
public class OpenedClass extends Activity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener{

    TextView question, test;
    Button returnData;
    RadioGroup selectionList;
    String gotBread,setData;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.send);
        initialize();

        SharedPreferences getData = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String et = getData.getString("name","I am...");
        String values = getData.getString("list", "2");
        if(values.contentEquals("1"))
        {
            question.setText(et);
        }


        /*
        Bundle gotBasket = getIntent().getExtras();
        gotBread = gotBasket.getString("key");
        question.setText(gotBread);
        */
    }
    private void initialize(){
        question=(TextView)findViewById(R.id.tvQuestion);
        test=(TextView)findViewById(R.id.tvText);
        returnData=(Button)findViewById(R.id.bReturn);
        returnData.setOnClickListener(this);
        selectionList = (RadioGroup)findViewById(R.id.rgAnswers);
        selectionList.setOnCheckedChangeListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        Intent person = new Intent();
        Bundle backpack = new Bundle();
        backpack.putString("answer", setData);
        person.putExtras(backpack);
        setResult(RESULT_OK, person);
        finish();
    }

    /**
     * <p>Called when the checked radio button has changed. When the
     * selection is cleared, checkedId is -1.</p>
     *
     * @param group     the group in which the checked radio button has changed
     * @param checkedId the unique identifier of the newly checked radio button
     */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rCrazy:
                setData = "Probably Right!";
                break;
            case  R.id.rSexy:
                setData = "Definitely Right!!";
                break;
            case R.id.rBoth:
                setData = "Spot On!";
                break;
        }
        test.setText(setData);
    }
}
