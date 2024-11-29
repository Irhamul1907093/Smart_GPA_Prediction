package com.example.emadata;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Light extends AppCompatActivity {

    private TextView textViewOutput,textView1Output,durationTxtView;
    private EditText editTextThreshold;

    private SensorManager sensorManager;
    private Sensor sensorLight;
    private long darkStartTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.light_timestamp);

        textViewOutput = findViewById(R.id.startTime);
        textView1Output = findViewById(R.id.endTime);
        durationTxtView = findViewById(R.id.duration);


        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorLight = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        if (sensorLight == null) {
            // Handle the case where the light sensor is not available on the device.
            Toast.makeText(this, "Light sensor is not available on this device.", Toast.LENGTH_SHORT).show();
        }

        SensorEventListener sensorEventListenerLight = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                float floatSensorValue = event.values[0]; // Lux

                // Check if light level is less than 5 lux
                if (floatSensorValue < 5) {
                    if (darkStartTime == 0) {
                        // Set the start time only if it's the first time light level is less than 5 lux
                        darkStartTime = System.currentTimeMillis();
                    }
                } else {
                    // Light level is above 5 lux
                    if (darkStartTime != 0) {
                        // If darkStartTime is set, calculate the duration
                        long duration = System.currentTimeMillis() - darkStartTime;
                        if (duration >= 5000) { // 5000 milliseconds (5 seconds)
                            // Display the start time and end time only when duration is 5 seconds or more
                            textViewOutput.setText(String.valueOf(darkStartTime));
                            textView1Output.setText(String.valueOf(System.currentTimeMillis()));
                            durationTxtView.setText(String.valueOf(duration/1000));
                        }
                        darkStartTime = 0; // Reset darkStartTime
                    }
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };

        sensorManager.registerListener(sensorEventListenerLight,sensorLight,SensorManager.SENSOR_DELAY_NORMAL);

    }

    public void buttonSetThreshold(View view){

        if (editTextThreshold.getText().toString().isEmpty()){
            return;
        }

        float floatThreshold = Float.valueOf(editTextThreshold.getText().toString());

    }
}
