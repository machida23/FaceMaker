
/**
 * Author: Logan Machida
 *
 * FaceController Class: Used as a listener for when the user interacts with the screen.
 *
 */package com.example.facemaker;

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
            if(faceView.getFacialElement() == 0){
                faceView.setHairColor(Color.rgb(progress,Color.green(faceView.getHairColor()),Color.blue(faceView.getHairColor())));
            }
            else if(faceView.getFacialElement() == 1){
                faceView.setEyeColor(Color.rgb(progress,Color.green(faceView.getEyeColor()),Color.blue(faceView.getEyeColor())));
            }
            else{
                faceView.setSkinColor(Color.rgb(progress,Color.green(faceView.getSkinColor()),Color.blue(faceView.getSkinColor())));
            }
        }
        if(seekBar == greenSeekBar){
            if(faceView.getFacialElement() == 0){
                faceView.setHairColor(Color.rgb(Color.red(faceView.getHairColor()),progress,Color.blue(faceView.getHairColor())));
            }
            else if(faceView.getFacialElement() == 1){
                faceView.setEyeColor(Color.rgb(Color.red(faceView.getEyeColor()),progress,Color.blue(faceView.getEyeColor())));
            }
            else{
                faceView.setSkinColor(Color.rgb(Color.red(faceView.getSkinColor()),progress,Color.blue(faceView.getSkinColor())));
            }
        }
        if(seekBar == blueSeekBar){
            if(faceView.getFacialElement()==0){
                faceView.setHairColor(Color.rgb(Color.red(faceView.getHairColor()),Color.green(faceView.getHairColor()),progress));
            }
            else if(faceView.getFacialElement()==1){
                faceView.setEyeColor(Color.rgb(Color.red(faceView.getEyeColor()),Color.green(faceView.getEyeColor()),progress));
            }
            else{
                faceView.setSkinColor(Color.rgb(Color.red(faceView.getSkinColor()),Color.green(faceView.getSkinColor()),progress));
            }
        }
        faceView.invalidate();
    }
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) { }
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) { }


    // Implement Radio Buttons to change body element
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if(checkedId == R.id.hairRadioButton){
            faceView.setFacialElement(0);
        }
        else if(checkedId == R.id.eyesRadioButton){
            faceView.setFacialElement(1);
        }
        else{
            faceView.setFacialElement(2);
        }
    }


    // Implement Button to Randomize the Face
    @Override
    public void onClick(View v) {
        faceView.Randomize();

        // randomize color of three elements
        if(faceView.getFacialElement() == 0){
            redSeekBar.setProgress(Color.red(faceView.getHairColor()));
            greenSeekBar.setProgress(Color.green(faceView.getHairColor()));
            blueSeekBar.setProgress(Color.blue(faceView.getHairColor()));
        }
        else if(faceView.getFacialElement() == 1){
            redSeekBar.setProgress(Color.red(faceView.getEyeColor()));
            greenSeekBar.setProgress(Color.green(faceView.getEyeColor()));
            blueSeekBar.setProgress(Color.blue(faceView.getEyeColor()));
        }
        else{
            redSeekBar.setProgress(Color.red(faceView.getSkinColor()));
            greenSeekBar.setProgress(Color.green(faceView.getSkinColor()));
            blueSeekBar.setProgress(Color.blue(faceView.getSkinColor()));
        }
        // randomize hairstyle
        hairSpinner.setSelection(faceView.getHairStyle());

        faceView.invalidate();
    }
}
