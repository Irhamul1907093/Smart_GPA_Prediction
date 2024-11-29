package com.example.emadata;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SensingData extends AppCompatActivity implements View.OnClickListener {

    private CardView activityCardView,audioCardView,sleepCardView,lockCardView,chargeCardView,locationCardView,lightCardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_sensing_data);

        activityCardView = findViewById(R.id.activity);
        sleepCardView = findViewById(R.id.sleep);
        audioCardView = findViewById(R.id.audio);
        locationCardView = findViewById(R.id.location);
        lockCardView = findViewById(R.id.lock);
        chargeCardView = findViewById(R.id.charge);
        lightCardView = findViewById(R.id.light);

        activityCardView.setOnClickListener(this);
        audioCardView.setOnClickListener(this);
        sleepCardView.setOnClickListener(this);
        locationCardView.setOnClickListener(this);
        lockCardView.setOnClickListener(this);
        chargeCardView.setOnClickListener(this);
        lightCardView.setOnClickListener(this);
//        buttonLockScreen.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Move to Lock activity
//                Intent intent = new Intent(SensingData.this, Lock.class);
//                startActivity(intent);
//            }
//        });
//
//        buttonLight.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Move to Light activity
//                Intent intent = new Intent(SensingData.this, Light.class);
//                startActivity(intent);
//            }
//        });
//        buttonLocation.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Move to Location activity
//                Intent intent = new Intent(SensingData.this, Location.class);
//                startActivity(intent);
//            }
//        });
//        buttonCharge.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Move to Charge activity
//                Intent intent = new Intent(SensingData.this, Charge.class);
//                startActivity(intent);
//            }
//        });
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        if (v.getId() == R.id.activity) {
            intent = new Intent(this, ActivityPrediction.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.audio) {
            intent = new Intent(this, AudioPrediction.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.sleep) {
            intent = new Intent(this, SleepPrediction.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.lock) {
            intent = new Intent(this, Lock.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.location) {
            intent = new Intent(this, Location.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.charge) {
            intent = new Intent(this, Charge.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.light) {
            intent = new Intent(this, Light.class);
            startActivity(intent);
        }
    }
}