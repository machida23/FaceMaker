package com.example.facemaker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

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

        // FaceController
        FaceController faceController = new FaceController(faceView, redBar, greenBar, blueBar, hairSpinner);

        // set listener
        redBar.setOnSeekBarChangeListener(faceController);
        greenBar.setOnSeekBarChangeListener(faceController);
        blueBar.setOnSeekBarChangeListener(faceController);
        random.setOnClickListener(faceController);

    }
}