package com.example.emadata;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CardView emaCardView,gpaCardView,sensingCardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity_main);

        emaCardView = findViewById(R.id.ema);
        gpaCardView = findViewById(R.id.gpa);
        sensingCardView = findViewById(R.id.sensing);

        emaCardView.setOnClickListener(this);
        gpaCardView.setOnClickListener(this);
        sensingCardView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        if (v.getId() == R.id.ema) {
            intent = new Intent(this, MoodData.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.gpa) {
            intent = new Intent(this, GpaPrediction.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.sensing) {
            intent = new Intent(this, SensingData.class);
            startActivity(intent);
        }
    }
}
