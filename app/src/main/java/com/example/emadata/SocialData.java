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

public class SocialData extends AppCompatActivity {

    int contactCount = -1; // Variable to hold the number of contacts, initialize as -1

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.social_data);

        RadioGroup contactCountRadioGroup = findViewById(R.id.contactRadioGroup);
        // Inside your Activity's onCreate() method or similar place
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("GPA Prediction");
        // Button setup
        /*Button displayContactCountButton = findViewById(R.id.buttonDisplayContactCount);
        displayContactCountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displaySelectedContactCount(v); // Call the displaySelectedContactCount method on button click
            }
        });*/
        contactCountRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.contactOption1) {
                    contactCount = 1; // 0-4 persons
                } else if (checkedId == R.id.contactOption2) {
                    contactCount = 2; // 5-9 persons
                } else if (checkedId == R.id.contactOption3) {
                    contactCount = 3; // 10-19 persons
                } else if (checkedId == R.id.contactOption4) {
                    contactCount = 4; // 20-49 persons
                } else if (checkedId == R.id.contactOption5) {
                    contactCount = 5; // 50-99 persons
                } else if (checkedId == R.id.contactOption6) {
                    contactCount = 6; // over 100 persons (use a suitable value)
                } else {
                    contactCount = -1; // Default value if none selected
                }
            }
        });
        // Find the button by ID
        Button buttonMoveToActivityData = findViewById(R.id.buttonMoveToActivityData);

        // Set click listener for the button
        buttonMoveToActivityData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Move to ActivityData activity
                Intent intent = new Intent(SocialData.this, ActivityData.class);
                startActivity(intent);
            }
        });

    }

    // Function to display the selected contact count value
    // Function to display the selected contact count value
    public void displaySelectedContactCount(View view) {
        // Show the selected contact count value using a Toast
        if (contactCount != -1) {
            // User has selected a valid option
            String message = "Selected Contact Count: " + contactCount;
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        } else {
            // No option selected
            Toast.makeText(this, "Please select an option.", Toast.LENGTH_SHORT).show();
        }
    }

}
