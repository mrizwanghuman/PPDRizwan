package com.pro.rizwan.ppdmuhammadrizwanconmed.utils;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.pro.rizwan.ppdmuhammadrizwanconmed.services.GetHeartRateServices;

/**
 * Created by  Admin on 3/18/2018.
 */

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class HeartRateSchedular extends JobService {
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        Intent intent = new Intent(this, GetHeartRateServices.class);
        startService(intent);
        UtilScheduler.scheduleJob(this);
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
