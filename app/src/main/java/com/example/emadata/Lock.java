package com.example.emadata;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class Lock extends AppCompatActivity {

    private static final String LOGTAG = "CheckIfScreenLocked";
    private TextView StartTimeTxtVIew,EndTimeTxtVIew,DurationTxtView;
    long timeStampStart,timeStampEnd,calculatedTimeStamp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lock_timestamp);

        StartTimeTxtVIew = findViewById(R.id.startTime);
        EndTimeTxtVIew = findViewById(R.id.endTime);
        DurationTxtView = findViewById(R.id.duration);

        registerScreenLockStateBroadcastReceiver();
    }

    private void registerScreenLockStateBroadcastReceiver() {
        final IntentFilter the_Filter = new IntentFilter();
        the_Filter.addAction(Intent.ACTION_SCREEN_ON);
        the_Filter.addAction(Intent.ACTION_SCREEN_OFF);
        the_Filter.addAction(Intent.ACTION_USER_PRESENT);

        BroadcastReceiver screenOnOffReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String strAction = intent.getAction();
                KeyguardManager kgMgr = (KeyguardManager) getSystemService(Context.KEYGUARD_SERVICE);
                if (strAction!= null && strAction.equals(Intent.ACTION_SCREEN_OFF)){
                    Log.d(LOGTAG,"Screen off");
                }
                else if (strAction!= null && strAction.equals(Intent.ACTION_SCREEN_ON)){
                    Log.d(LOGTAG,"Screen on");
                }
                if (strAction!= null && strAction.equals(Intent.ACTION_USER_PRESENT) && !kgMgr.isKeyguardLocked()){
                    Log.d(LOGTAG,"Device Unlocked");
                    timeStampEnd = System.currentTimeMillis();
                    calculatedTimeStamp = timeStampEnd - timeStampStart;
                    if (calculatedTimeStamp > 6000){
                        StartTimeTxtVIew.setText(String.valueOf(timeStampStart));
                        EndTimeTxtVIew.setText(String.valueOf(timeStampEnd));
                        DurationTxtView.setText(String.valueOf(calculatedTimeStamp));
                    }
                }
                else {
                    Log.d(LOGTAG,"Device Locked");
                    timeStampStart = System.currentTimeMillis();
                }
            }
        };
        getApplicationContext().registerReceiver(screenOnOffReceiver,the_Filter);
    }
}