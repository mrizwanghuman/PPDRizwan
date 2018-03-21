package com.pro.rizwan.ppdmuhammadrizwanconmed.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.pro.rizwan.ppdmuhammadrizwanconmed.PPDRizwanAppApplication;
import com.pro.rizwan.ppdmuhammadrizwanconmed.R;
import com.pro.rizwan.ppdmuhammadrizwanconmed.services.GetHeartRateServices;
import com.pro.rizwan.ppdmuhammadrizwanconmed.utils.HeartRateAdpater;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainActivityContractor.View {
    @Inject
    MainActivityPresenter mainActivityPresenter;
    List<String> heartRateList = new ArrayList<>();
    @BindView(R.id.rcHeartRate)
    RecyclerView rcHeartRate;
    @BindView(R.id.textview)
    TextView textview;

    private Timer t;
    private HeartRateAdpater heartRateAdpater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        PPDRizwanAppApplication.get(this).getHomeComponent().inject(this);
        mainActivityPresenter.onAttachView(this);

        rcHeartRate.setLayoutManager(new LinearLayoutManager(this));


    }

    private BroadcastReceiver heartRateReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {


            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                int heartRate = bundle.getInt(GetHeartRateServices.HEARTRate);
                String heartBeat = Integer.toString(heartRate);

                textview.setText(heartBeat);
                heartRateList.add(heartBeat);
                heartRateAdpater = new HeartRateAdpater(heartRateList);
                rcHeartRate.setAdapter(heartRateAdpater);

            }
        }
    };

    @Override
    protected void onResume() {
        super.onResume();

        registerReceiver(heartRateReceiver, new IntentFilter(GetHeartRateServices.NOTIFICATION));
        scheduleService();


    }


    void scheduleService() {

        t = new Timer();

        t.scheduleAtFixedRate(new TimerTask() {

                                  @Override
                                  public void run() {
                                      //Called each time when 1000 milliseconds (1 second) (the period parameter)
                                      mainActivityPresenter.startHeartRateService(getApplicationContext());
                                      Log.d("Janu", "run: " + heartRateList.size());

                                  }

                              },
//Set how long before to start calling the TimerTask (in milliseconds)
                0,
//Set the amount of time between each execution (in milliseconds)
                1000);

    }

    @Override
    public void showError(String e) {

    }

    @Override
    public void showProgress(String progress) {
        // Toast.makeText(this, progress, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void setHeartRateList(List<Integer> heartRateList) {
        for (int i = 0; i < heartRateList.size(); i++) {
            Log.d("PAPA", "setHeartRateList: " + heartRateList.get(i));
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        PPDRizwanAppApplication.get(this).clearHomeComponent();
    }

    @Override
    protected void onPause() {
        super.onPause();

        unregisterReceiver(heartRateReceiver);
        t.cancel();

    }
}
