package com.example.barun.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;

/**
 * Created by Barun on 13/06/15.
 */
public class MyBringBack extends View {

    Bitmap gBall;
    float changingY;
    Typeface font;


    public MyBringBack(Context context){
        super(context);
        gBall = BitmapFactory.decodeResource(getResources(), R.drawable.greenball);
        changingY = 0;
        font = Typeface.createFromAsset(context.getAssets(), "G-Unit.TTF");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);

        Paint textPaint = new Paint();
        textPaint.setARGB(50, 222, 44, 99);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setTextSize(80);
        textPaint.setTypeface(font);
        canvas.drawText("Android Graphics", canvas.getWidth()/2, 700, textPaint);


        canvas.drawBitmap(gBall, (canvas.getWidth() / 2 - gBall.getWidth()/2), changingY, null);

        changingY+=10;
        if(changingY>canvas.getHeight()){
            changingY=0;
        }

        Rect middleRect = new Rect();
        middleRect.set(0, 1000, canvas.getWidth(), 1150);
        Paint ourBlue = new Paint();
        ourBlue.setColor(Color.BLUE);

        canvas.drawRect(middleRect, ourBlue);

        invalidate();
    }
}
