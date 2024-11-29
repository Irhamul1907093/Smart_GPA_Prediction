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

public class ActivityData extends AppCompatActivity {

    int aloneWorking = -1; // Variable for Alone Working
    int aloneRelaxing = -1; // Variable for Alone Relaxing
    int withOthersWorking = -1; // Variable for With Others Working
    int withOthersRelaxing = -1; // Variable for With Others Relaxing

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        RadioGroup aloneWorkingRadioGroup = findViewById(R.id.aloneWorkingRadioGroup);
        RadioGroup aloneRelaxingRadioGroup = findViewById(R.id.aloneRelaxingRadioGroup);
        RadioGroup withOthersWorkingRadioGroup = findViewById(R.id.withOthersWorkingRadioGroup);
        RadioGroup withOthersRelaxingRadioGroup = findViewById(R.id.withOthersRelaxingRadioGroup);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("GPA Prediction");
        // Set listeners for each RadioGroup
        aloneWorkingRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                aloneWorking = getSelectedOption(group, checkedId);
            }
        });

        aloneRelaxingRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                aloneRelaxing = getSelectedOption(group, checkedId);
            }
        });

        withOthersWorkingRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                withOthersWorking = getSelectedOption(group, checkedId);
            }
        });

        withOthersRelaxingRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                withOthersRelaxing = getSelectedOption(group, checkedId);
            }
        });

        // Button to display variable values
       /* Button displayValuesButton = findViewById(R.id.displayValuesButton);
        displayValuesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayVariableValues();
            }
        });*/
        // Find the button by ID
        Button buttonMoveToBehaviourData = findViewById(R.id.buttonMoveToBehaviourData);

        // Set click listener for the button
        buttonMoveToBehaviourData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Move to BehaviourData activity
                Intent intent = new Intent(ActivityData.this, BehaviourData.class);
                startActivity(intent);
            }
        });
    }

    // Updated getSelectedOption method to handle all RadioGroups
    private int getSelectedOption(RadioGroup group, int checkedId) {
        RadioButton radioButton = group.findViewById(checkedId);
        if (radioButton != null) {
            String text = radioButton.getText().toString();
            if (text.equals("0-10%")) {
                return 1;
            } else if (text.equals("11-25%")) {
                return 2;
            } else if (text.equals("26-50%")) {
                return 3;
            } else if (text.equals("51-75%")) {
                return 4;
            } else if (text.equals("76-100%")) {
                return 5;
            } else {
                return -1; // Default value if no option is selected
            }
        }
        return -1; // Default value if no option is selected
    }

    // Function to display the values of the variables
    private void displayVariableValues() {
        String message = "Alone Working: " + aloneWorking +
                "\nAlone Relaxing: " + aloneRelaxing +
                "\nWith Others Working: " + withOthersWorking +
                "\nWith Others Relaxing: " + withOthersRelaxing;

        // Display values in a toast
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
