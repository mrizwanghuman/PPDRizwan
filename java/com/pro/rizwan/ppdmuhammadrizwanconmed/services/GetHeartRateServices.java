package com.pro.rizwan.ppdmuhammadrizwanconmed.services;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Random;

public class GetHeartRateServices extends IntentService {
    public static final String NOTIFICATION = "com.pro.rizwan.ppdmuhammadrizwanconmed.services";
    public static final String HEARTRate = "heartRate";

    public GetHeartRateServices() {
        super("GetHeartRateServices");
    }

    @Override
    protected void onHandleIntent( Intent intent) {
        int[] heartRateArray={99,102,103,98,100};

        int heartRate= randomNumberGen(heartRateArray);
        publishHeartRate(heartRate);

    }

    private void publishHeartRate(int heartRate){

        Intent intent = new Intent(NOTIFICATION);

        intent.putExtra(HEARTRate, heartRate);
        sendBroadcast(intent);
    }

private int randomNumberGen(int[] heartBeat){
        int randomNumber = new Random().nextInt(heartBeat.length);
        return heartBeat[randomNumber];
}
}
