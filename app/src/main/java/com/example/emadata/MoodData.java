package com.example.emadata;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;


public class MoodData extends AppCompatActivity {

    int feelHappy = 0; // 0 for No, 1 for Yes
    int happyIntensity = 0; // 1 for 'A little bit', 2 for 'Somewhat', 3 for 'Very much', 4 for 'Extremely'
    int feelSad = 0; // 0 for No, 1 for Yes
    int sadIntensity = 0; // 1 for 'A little bit', 2 for 'Somewhat', 3 for 'Very much', 4 for 'Extremely'

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mood_data); // Linking the Java class with the XML layout

        RadioGroup happyRadioGroup = findViewById(R.id.happyRadioGroup);
        RadioGroup happyIntensityRadioGroup = findViewById(R.id.happyIntensityRadioGroup);
        RadioGroup sadRadioGroup = findViewById(R.id.sadRadioGroup);
        RadioGroup sadIntensityRadioGroup = findViewById(R.id.sadIntensityRadioGroup);
        // Inside your Activity's onCreate() method or similar place
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("GPA Prediction");


        happyRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.happyYes) {
                feelHappy = 1;
                happyIntensityRadioGroup.setVisibility(View.VISIBLE);
            } else {
                feelHappy = 0;
                happyIntensityRadioGroup.setVisibility(View.GONE);
            }
        });

        sadRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.sadYes) {
                feelSad = 1;
                sadIntensityRadioGroup.setVisibility(View.VISIBLE);
            } else {
                feelSad = 0;
                sadIntensityRadioGroup.setVisibility(View.GONE);
            }
        });

        happyIntensityRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.happyALittleBit) {
                happyIntensity = 1;
            } else if (checkedId == R.id.happysomewhat) {
                happyIntensity = 2;
            } else if (checkedId == R.id.happyverymuch) {
                happyIntensity = 3;
            } else if (checkedId == R.id.happyextreme) {
                happyIntensity = 4;
            }
        });

        sadIntensityRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.sadALittleBit) {
                sadIntensity = 1;
            } else if (checkedId == R.id.sadsomewhat) {
                sadIntensity = 2;
            } else if (checkedId == R.id.sadverymuch) {
                sadIntensity = 3;
            } else if (checkedId == R.id.sadextreme) {
                sadIntensity = 4;
            }
        });
        // Find the button by its ID
        /*Button displayButton = findViewById(R.id.buttonDisplay);

        // Set an OnClickListener for the button
        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displaySelectedValues(v); // Call the method when the button is clicked
            }
        });*/

        // Find the button by ID
        Button buttonMoveToStressData = findViewById(R.id.buttonMoveToStressData);

        // Set click listener for the button
        buttonMoveToStressData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Move to StressData activity
                Intent intent = new Intent(MoodData.this, StressData.class);
                startActivity(intent);
            }
        });
    }

    // Add a method to handle button click to display the selected values
    public void displaySelectedValues(View view) {
        String message = "Feel Happy: " + feelHappy + "\nHappy Intensity: " + happyIntensity +
                "\nFeel Sad: " + feelSad + "\nSad Intensity: " + sadIntensity;

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}



