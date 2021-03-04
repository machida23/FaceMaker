package com.example.facemaker;
/**
 * Author: Logan Machida
 *
 * Main Activity Class
 *
 */
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {


    /** External Citation
     * Date: March 3, 2021
     * Problem: I did not know how to add options for the spinner.
     * Resource: https://stackoverflow.com/questions/5241660/how-to-add-items-to-a-spinner-in-android
     * Solution: I used the code on this website as an example.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // findViewById
        Face faceView = findViewById(R.id.faceSurfaceView);
        SeekBar redBar = findViewById(R.id.redSeekBar);
        SeekBar greenBar = findViewById(R.id.greenSeekBar);
        SeekBar blueBar = findViewById(R.id.blueSeekBar);
        Spinner hairSpinner = findViewById(R.id.hairStyleSpinner);
        Button random = findViewById(R.id.randomButton);
        RadioGroup radioGroup = findViewById(R.id.hairRadioGroup);

        // FaceController
        FaceController faceController = new FaceController(faceView, redBar, greenBar, blueBar, hairSpinner);

        // add elements to spinner
        String[] hairType = {"bald", "smooth"};
        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, hairType);
        hairSpinner.setAdapter(arrayAdapter);
        hairSpinner.setOnItemSelectedListener(faceController);

        // set listener
        redBar.setOnSeekBarChangeListener(faceController);
        greenBar.setOnSeekBarChangeListener(faceController);
        blueBar.setOnSeekBarChangeListener(faceController);
        random.setOnClickListener(faceController);
        radioGroup.setOnCheckedChangeListener(faceController);





    }
}