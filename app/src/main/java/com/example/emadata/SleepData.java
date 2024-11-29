package com.example.emadata;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SleepData extends AppCompatActivity {

    int sleepHours; // Variable to hold sleep hours
    int sleepRate; // Variable to hold sleep rate
    int sleepTrouble; // Variable to hold trouble staying awake

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sleep_data);

        RadioGroup sleepHoursRadioGroup = findViewById(R.id.sleepHoursRadioGroup);
        RadioGroup sleepRateRadioGroup = findViewById(R.id.sleepRateRadioGroup);
        RadioGroup sleepTroubleRadioGroup = findViewById(R.id.sleepTroubleRadioGroup);

        // Inside your Activity's onCreate() method or similar place
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("GPA Prediction");
        //Button displayButton = findViewById(R.id.buttonDisplaySleep);

        // Rest of your code for setting up RadioGroups...

        /*displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayVariables();
            }
        });*/
        sleepHoursRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.sleepHoursOption1) {
                sleepHours = 1;
            } else if (checkedId == R.id.sleepHoursOption2) {
                sleepHours = 2;
            } else if (checkedId == R.id.sleepHoursOption3) {
                sleepHours = 3;
            } else if (checkedId == R.id.sleepHoursOption4) {
                sleepHours = 4;
            } else if (checkedId == R.id.sleepHoursOption5) {
                sleepHours = 5;
            } else if (checkedId == R.id.sleepHoursOption6) {
                sleepHours = 6;
            } else if (checkedId == R.id.sleepHoursOption7) {
                sleepHours = 7;
            } else if (checkedId == R.id.sleepHoursOption8) {
                sleepHours = 8;
            } else if (checkedId == R.id.sleepHoursOption9) {
                sleepHours = 9;
            } else if (checkedId == R.id.sleepHoursOption10) {
                sleepHours = 10;
            } else if (checkedId == R.id.sleepHoursOption11) {
                sleepHours = 11;
            } else if (checkedId == R.id.sleepHoursOption12) {
                sleepHours = 12;
            } else if (checkedId == R.id.sleepHoursOption13) {
                sleepHours = 13;
            } else if (checkedId == R.id.sleepHoursOption14) {
                sleepHours = 14;
            } else if (checkedId == R.id.sleepHoursOption15) {
                sleepHours = 15;
            } else if (checkedId == R.id.sleepHoursOption16) {
                sleepHours = 16;
            } else if (checkedId == R.id.sleepHoursOption17) {
                sleepHours = 17;
            } else if (checkedId == R.id.sleepHoursOption18) {
                sleepHours = 18;
            } else if (checkedId == R.id.sleepHoursOption19) {
                sleepHours = 19;
            }

        });

        sleepRateRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.sleepRateOption1) {
                sleepRate = 1; // Very good
            } else if (checkedId == R.id.sleepRateOption2) {
                sleepRate = 2; // Fairly good
            }
            else if (checkedId == R.id.sleepRateOption3) {
                sleepRate = 3; // Fairly good
            }
            else if (checkedId == R.id.sleepRateOption4) {
                sleepRate = 4; // Fairly good
            }

        });

        sleepTroubleRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.sleepTroubleOption1) {
                sleepTrouble = 1; // None
            } else if (checkedId == R.id.sleepTroubleOption2) {
                sleepTrouble = 2; // Once
            }
            else if (checkedId == R.id.sleepTroubleOption3) {
                sleepTrouble = 3; // Once
            }
            else if (checkedId == R.id.sleepTroubleOption4) {
                sleepTrouble = 4; // Once
            }
        });
        // Find the button by ID
        Button buttonMoveToSocialData = findViewById(R.id.buttonMoveToSocialData);

        // Set click listener for the button
        buttonMoveToSocialData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Move to SocialData activity
                Intent intent = new Intent(SleepData.this, SocialData.class);
                startActivity(intent);
            }
        });
    }

    private void displayVariables() {
        String message = "Sleep Hours: " + sleepHours +
                "\nSleep Rate: " + sleepRate +
                "\nSleep Trouble: " + sleepTrouble;

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
