package com.pro.rizwan.ppdmuhammadrizwanconmed.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.Random;

public class GetHeartRateServices extends Service {
    public GetHeartRateServices() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
int[] heartRate={99,102,103,98,100};
        Log.d("Random", "onStartCommand: "+randomNumberGen(heartRate));
        stopSelf();
        return super.onStartCommand(intent, flags, startId);
    }
private int randomNumberGen(int[] heartBeat){
        int randomNumber = new Random().nextInt(heartBeat.length);
        return heartBeat[randomNumber];
}
}
