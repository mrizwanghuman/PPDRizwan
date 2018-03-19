package com.pro.rizwan.ppdmuhammadrizwanconmed.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;

/**
 * Created by  Admin on 3/18/2018.
 */

public class HeartRateBroadCastReceiver extends BroadcastReceiver {
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onReceive(Context context, Intent intent) {
        UtilScheduler.scheduleJob(context);
    }
}
