package com.pro.rizwan.ppdmuhammadrizwanconmed.view;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.HeaderViewListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.pro.rizwan.ppdmuhammadrizwanconmed.services.GetHeartRateServices;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by  Admin on 3/16/2018.
 */

public class MainActivityPresenter implements MainActivityContractor.Presenter {
    private MainActivityContractor.View mainContractView;
    private List<Integer> heartRateList = new ArrayList<>();


    @Override
    public void onAttachView(MainActivityContractor.View view) {
        this.mainContractView = view;
    }

    @Override
    public void onDetachView() {
        this.mainContractView = null;
    }

    @Override
    public void startHeartRateService(Context context) {
        mainContractView.showProgress("Service Started");
        Intent intent = new Intent(context, GetHeartRateServices.class);
        context.startService(intent);
        mainContractView.showProgress("Service ended");
    }

    @Override
    public void registerService(Context context) {
        context.registerReceiver(heartRateReceiver, new IntentFilter(GetHeartRateServices.NOTIFICATION));
    }


    @Override
    public void unRegisterService(Context context) {
        context.unregisterReceiver(heartRateReceiver);
    }

    @Override
    public void getHeartRateList() {
        Log.d("GETIT", "getHeartRateList: "+heartRateList.size());
        mainContractView.setHeartRateList(heartRateList);
    }


    private BroadcastReceiver heartRateReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {

            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                int heartRate = bundle.getInt(GetHeartRateServices.HEARTRate);

                Log.d("Heart", "onReceive: " + heartRate);
                heartRateList.add(heartRate);

                Toast.makeText(context, "" + heartRate, Toast.LENGTH_LONG).show();


            }
        }
    };


}
