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

public class BehaviourData extends AppCompatActivity {

    // Variables to hold responses for 10 questions
    private int response1 = -1;
    private int response2 = -1;
    private int response3 = -1;
    private int response4 = -1;
    private int response5 = -1;
    private int response6 = -1;
    private int response7 = -1;
    private int response8 = -1;
    private int response9 = -1;
    private int response10 = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.behaviour_data);

        // Find the button
        /*Button displayButton = findViewById(R.id.displayResponsesButton);

        // Set a click listener for the button
        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayResponses();
            }
        });*/
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("GPA Prediction");
        // RadioGroup and RadioButton handling for 10 questions
        RadioGroup radioGroup1 = findViewById(R.id.radioGroupQuestion1);
        RadioGroup radioGroup2 = findViewById(R.id.radioGroupQuestion2);
        RadioGroup radioGroup3 = findViewById(R.id.radioGroupQuestion3);
        RadioGroup radioGroup4 = findViewById(R.id.radioGroupQuestion4);
        RadioGroup radioGroup5 = findViewById(R.id.radioGroupQuestion5);
        RadioGroup radioGroup6 = findViewById(R.id.radioGroupQuestion6);
        RadioGroup radioGroup7 = findViewById(R.id.radioGroupQuestion7);
        RadioGroup radioGroup8 = findViewById(R.id.radioGroupQuestion8);
        RadioGroup radioGroup9 = findViewById(R.id.radioGroupQuestion9);
        RadioGroup radioGroup10 = findViewById(R.id.radioGroupQuestion10);
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                response1 = getSelectedOption(checkedId);
            }
        });

        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                response2 = getSelectedOption(checkedId);
            }
        });
        radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                response3 = getSelectedOption(checkedId);
            }
        });
        radioGroup4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                response4 = getSelectedOption(checkedId);
            }
        });
        radioGroup5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                response5 = getSelectedOption(checkedId);
            }
        });
        radioGroup6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                response6 = getSelectedOption(checkedId);
            }
        });
        radioGroup7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                response7 = getSelectedOption(checkedId);
            }
        });
        radioGroup8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                response8 = getSelectedOption(checkedId);
            }
        });
        radioGroup9.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                response9 = getSelectedOption(checkedId);
            }
        });
        radioGroup10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                response10 = getSelectedOption(checkedId);
            }
        });


        Button moveToHomeButton = findViewById(R.id.buttonMoveToHome);
        moveToHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BehaviourData.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    // Method to get the selected option from RadioButton ID
    private int getSelectedOption(int checkedId) {
        int selectedOption = -1;

        // Question 1
        if (checkedId == R.id.question1Option1) {
            selectedOption = 1;
        } else if (checkedId == R.id.question1Option2) {
            selectedOption = 2;
        } else if (checkedId == R.id.question1Option3) {
            selectedOption = 3;
        } else if (checkedId == R.id.question1Option4) {
            selectedOption = 4;
        } else if (checkedId == R.id.question1Option5) {
            selectedOption = 5;
        }

        // Question 2
        else if (checkedId == R.id.question2Option1) {
            selectedOption = 1;
        } else if (checkedId == R.id.question2Option2) {
            selectedOption = 2;
        } else if (checkedId == R.id.question2Option3) {
            selectedOption = 3;
        } else if (checkedId == R.id.question2Option4) {
            selectedOption = 4;
        } else if (checkedId == R.id.question2Option5) {
            selectedOption = 5;
        }
        // Question 3
        else if (checkedId == R.id.question3Option1) {
            selectedOption = 1;
        } else if (checkedId == R.id.question3Option2) {
            selectedOption = 2;
        } else if (checkedId == R.id.question3Option3) {
            selectedOption = 3;
        } else if (checkedId == R.id.question3Option4) {
            selectedOption = 4;
        } else if (checkedId == R.id.question3Option5) {
            selectedOption = 5;
        }
        // Question 4
        else if (checkedId == R.id.question4Option1) {
            selectedOption = 1;
        } else if (checkedId == R.id.question4Option2) {
            selectedOption = 2;
        } else if (checkedId == R.id.question4Option3) {
            selectedOption = 3;
        } else if (checkedId == R.id.question4Option4) {
            selectedOption = 4;
        } else if (checkedId == R.id.question4Option5) {
            selectedOption = 5;
        }
        // Question 5
        else if (checkedId == R.id.question5Option1) {
            selectedOption = 1;
        } else if (checkedId == R.id.question5Option2) {
            selectedOption = 2;
        } else if (checkedId == R.id.question5Option3) {
            selectedOption = 3;
        } else if (checkedId == R.id.question5Option4) {
            selectedOption = 4;
        } else if (checkedId == R.id.question5Option5) {
            selectedOption = 5;
        }
        // Question 6
        else if (checkedId == R.id.question6Option1) {
            selectedOption = 1;
        } else if (checkedId == R.id.question6Option2) {
            selectedOption = 2;
        } else if (checkedId == R.id.question6Option3) {
            selectedOption = 3;
        } else if (checkedId == R.id.question6Option4) {
            selectedOption = 4;
        } else if (checkedId == R.id.question6Option5) {
            selectedOption = 5;
        }
        // Question 7
        else if (checkedId == R.id.question7Option1) {
            selectedOption = 1;
        } else if (checkedId == R.id.question7Option2) {
            selectedOption = 2;
        } else if (checkedId == R.id.question7Option3) {
            selectedOption = 3;
        } else if (checkedId == R.id.question7Option4) {
            selectedOption = 4;
        } else if (checkedId == R.id.question7Option5) {
            selectedOption = 5;
        }
        // Question 8
        else if (checkedId == R.id.question8Option1) {
            selectedOption = 1;
        } else if (checkedId == R.id.question8Option2) {
            selectedOption = 2;
        } else if (checkedId == R.id.question8Option3) {
            selectedOption = 3;
        } else if (checkedId == R.id.question8Option4) {
            selectedOption = 4;
        } else if (checkedId == R.id.question8Option5) {
            selectedOption = 5;
        }
        // Question 9
        else if (checkedId == R.id.question9Option1) {
            selectedOption = 1;
        } else if (checkedId == R.id.question9Option2) {
            selectedOption = 2;
        } else if (checkedId == R.id.question9Option3) {
            selectedOption = 3;
        } else if (checkedId == R.id.question9Option4) {
            selectedOption = 4;
        } else if (checkedId == R.id.question9Option5) {
            selectedOption = 5;
        }
        // Question 10
        else if (checkedId == R.id.question10Option1) {
            selectedOption = 1;
        } else if (checkedId == R.id.question10Option2) {
            selectedOption = 2;
        } else if (checkedId == R.id.question10Option3) {
            selectedOption = 3;
        } else if (checkedId == R.id.question10Option4) {
            selectedOption = 4;
        } else if (checkedId == R.id.question10Option5) {
            selectedOption = 5;
        }

        return selectedOption;
    }


    // Example method to display the collected responses (replace with your logic)
    private void displayResponses() {
        // Example: Display a toast with the responses
        String message = "Responses: " +
                response1 + ", " +
                response2 + ", " +
                response3 + ", " +
                response4 + ", " +
                response5 + ", " +
                response6 + ", " +
                response7 + ", " +
                response8 + ", " +
                response9 + ", " +
                response10;
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}

