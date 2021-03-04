package com.example.facemaker;

import android.graphics.Color;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

public class FaceController implements AdapterView.OnItemSelectedListener, SeekBar.OnSeekBarChangeListener, RadioGroup.OnCheckedChangeListener,
        Button.OnClickListener {

    // instance variables
    private Face faceView;
    private SeekBar redSeekBar;
    private SeekBar greenSeekBar;
    private SeekBar blueSeekBar;
    private Spinner hairSpinner;

    // initialize instance variables
    public FaceController(Face face, SeekBar redBar, SeekBar greenBar, SeekBar blueBar, Spinner hair){
        faceView = face;
        redSeekBar = redBar;
        greenSeekBar = greenBar;
        blueSeekBar = blueBar;
        hairSpinner = hair;
    }


    // Implement Spinner to change hairstyles
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int hairStyle, long id) {
        faceView.setHairStyle(hairStyle);
        faceView.invalidate();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {}



    // Implement SeekBar to change hairColor
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        // determine which SeekBar was changed, then what facial element it applies to
        // hair = 0, eyes = 1, skin = 2
        if(seekBar == redSeekBar){
            if(faceView.getFacialElement()==0){
                faceView.setHairColor(Color.rgb(progress,Color.green(faceView.getHairColor()),Color.blue(faceView.getHairColor())));
            }
            else if(faceView.getFacialElement()==1){
                faceView.setEyeColor(Color.rgb(progress,Color.green(faceView.getEyeColor()),Color.blue(faceView.getEyeColor())));
            }
            else{
                faceView.setSkinColor(Color.rgb(progress,Color.green(faceView.getSkinColor()),Color.blue(faceView.getSkinColor())));
            }
        }
        if(seekBar == greenSeekBar){
            if(faceView.getFacialElement() == 0){
                // faceView.setHairColor();
            }
            else if(faceView.getFacialElement() == 1){
                // faceView.setEyeColor();
            }
            else{
                // faceView.setSkinColor();
            }
        }
        if(seekBar == blueSeekBar){
            if(faceView.getFacialElement() == 0){
                // faceView.setHairColor();
            }
            else if(faceView.getFacialElement() == 1){
                // faceView.setEyeColor();
            }
            else{
                // faceView.setSkinColor();
            }
        }
        faceView.invalidate();
    }
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) { }
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) { }


    // Implement Spinner to change hairstyle
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

    }


    // Implement Button to Randomize the Face
    @Override
    public void onClick(View v) {

    }
}
