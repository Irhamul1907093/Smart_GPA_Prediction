package com.example.emadata;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

public class ChargingReceiver extends BroadcastReceiver {
    private TextView textViewChargingStatus,textViewUnChargingStatus,duration;
    private long StartTime=-1,EndTime,CalculateTime;

    public ChargingReceiver(TextView chargingStatus, TextView unchargingStatus,TextView durationTimeNew) {
        textViewChargingStatus = chargingStatus;
        textViewUnChargingStatus = unchargingStatus;
        duration = durationTimeNew;
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action != null) {
            if (action.equals(Intent.ACTION_POWER_CONNECTED)) {
                // Phone is plugged in for charging
                // Do something when plugged in
                StartTime = System.currentTimeMillis();
            } else if (action.equals(Intent.ACTION_POWER_DISCONNECTED) && StartTime != -1) {
                // Phone is unplugged
                // Do something when unplugged
                EndTime = System.currentTimeMillis();
                CalculateTime = EndTime - StartTime;
                if (CalculateTime > 6000){ // 6s
                    textViewChargingStatus.setText(String.valueOf(StartTime));
                    textViewUnChargingStatus.setText(String.valueOf(EndTime));
                    duration.setText(String.valueOf(CalculateTime/1000));
                }
            }
        }
    }

}
