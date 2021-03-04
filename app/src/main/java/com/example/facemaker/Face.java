package com.example.facemaker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.SurfaceView;

import androidx.annotation.RequiresApi;

public class Face extends SurfaceView {

    // instance variables
    private int skinColor;
    private int eyeColor;
    private int hairColor;
    private int hairStyle; // set to 0 or 1 for different hairstyles
    private int facialElement; // set to 0, 1, or 2 for hair, eyes, or skin

    private Paint skinPaint = new Paint();
    private Paint eyePaint = new Paint();
    private Paint hairPaint = new Paint();
    private Paint whitePaint = new Paint();
    private Paint redPaint = new Paint();

    // Constructor
    public Face(Context context, AttributeSet attrs){
        super(context, attrs);
        setWillNotDraw(false);

        Randomize();
        facialElement = -1;
        skinPaint.setColor(skinColor);
        eyePaint.setColor(eyeColor);
        hairPaint.setColor(hairColor);
        whitePaint.setColor(Color.WHITE);
        redPaint.setColor(Color.RED);

    }

   public void Randomize(){
        // initialize all variables to randomly selected values
        skinColor = android.graphics.Color.rgb((int)(256*(Math.random())),(int)(256*(Math.random())), (int)(256*(Math.random())));
        eyeColor = android.graphics.Color.rgb((int)(256*(Math.random())),(int)(256*(Math.random())), (int)(256*(Math.random())));
        hairColor = android.graphics.Color.rgb((int)(256*(Math.random())),(int)(256*(Math.random())), (int)(256*(Math.random())));
        hairStyle = (int)(2*(Math.random())); // how many hairstyles are needed?

    }


    public void onDraw(Canvas canvas){

        canvas.drawOval(100.0f, 100.0f, 100.0f, 100.0f, skinPaint);

        // call helper methods
        drawHair(canvas);
        drawEyes(canvas);
        drawMouth(canvas);
    }

    public void drawHair(Canvas canvas){
        if(hairStyle == 0){
            canvas.drawOval(100.0f, 100.0f, 100.0f, 100.0f, hairPaint);
        }
        else{
            canvas.drawOval(100.0f, 100.0f, 100.0f, 100.0f, hairPaint);
        }
    }

    public void drawEyes(Canvas canvas){
        canvas.drawOval(100.0f, 100.0f, 100.0f, 100.0f, whitePaint);
        canvas.drawOval(100.0f, 100.0f, 100.0f, 100.0f, eyePaint);
        canvas.drawOval(100.0f, 100.0f, 100.0f, 100.0f, whitePaint);
        canvas.drawOval(100.0f, 100.0f, 100.0f, 100.0f, eyePaint);
    }

    public void drawMouth(Canvas canvas){
        canvas.drawOval(100.0f, 100.0f, 100.0f, 100.0f, redPaint);
    }


    // getter methods
    public int getSkinColor(){ return skinColor; }
    public int getEyeColor(){ return eyeColor; }
    public int getHairColor(){ return hairColor; }
    public int getHairStyle(){ return hairStyle; }
    public int getFacialElement(){return facialElement; }

    // setter methods
    public void setSkinColor(int skinColor){ this.skinColor = skinColor; }
    public void setEyeColor(int eyeColor){ this.eyeColor = eyeColor; }
    public void setHairColor(int hairColor){this.hairColor = hairColor; }
    public void setHairStyle(int hairStyle){this.hairStyle = hairStyle; }
    public void setFacialElement(int facialElement){this.facialElement = facialElement; }

}

