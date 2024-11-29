package com.example.emadata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

public class Charge extends AppCompatActivity {

    private ChargingReceiver chargingReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.charge_duration);

        TextView textViewChargingStatus = findViewById(R.id.startTime);
        TextView textViewUnChargingStatus = findViewById(R.id.endTime);
        TextView duration = findViewById(R.id.duration);

        chargingReceiver = new ChargingReceiver(textViewChargingStatus, textViewUnChargingStatus,duration);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        registerReceiver(chargingReceiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(chargingReceiver);
    }
}