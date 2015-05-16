package com.example.barun.myapplication;

import android.app.Activity;
import android.os.Bundle;
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
    String gotBread;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.send);
        initialize();
        Bundle gotBasket = getIntent().getExtras();
        gotBread = gotBasket.getString("key");
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
                break;
            case  R.id.rSexy:
                break;
            case R.id.rBoth:
                break;
        }
    }
}
