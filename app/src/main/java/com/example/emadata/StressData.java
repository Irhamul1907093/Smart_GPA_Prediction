package com.example.emadata;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class StressData extends AppCompatActivity {
    int selectedMood = 0; // Variable to store the selected mood value

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stress_data);

        // Inside your Activity's onCreate() method or similar place
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("GPA Prediction");

        // Find the RadioGroup by its ID
        RadioGroup moodRadioGroup = findViewById(R.id.moodRadioGroup);

        // Set a listener for the RadioGroup changes
        moodRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            // Check which RadioButton is selected
            if (checkedId == R.id.littleStressed) {
                selectedMood = 1;
            } else if (checkedId == R.id.definitelyStressed) {
                selectedMood = 2;
            } else if (checkedId == R.id.stressedOut) {
                selectedMood = 3;
            } else if (checkedId == R.id.feelingGood) {
                selectedMood = 4;
            } else if (checkedId == R.id.feelingGreat) {
                selectedMood = 5;
            } else {
                selectedMood = 0; // Default value
            }
        });

        // Find the button by ID
        Button buttonMoveToSleepData = findViewById(R.id.buttonMoveToSleepData);

        // Set click listener for the button
        buttonMoveToSleepData.setOnClickListener(v -> {
            // Move to SleepData activity
            Intent intent = new Intent(StressData.this, SleepData.class);
            startActivity(intent);
        });
    }
}
