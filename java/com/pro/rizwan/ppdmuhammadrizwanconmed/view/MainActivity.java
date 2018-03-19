package com.pro.rizwan.ppdmuhammadrizwanconmed.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.pro.rizwan.ppdmuhammadrizwanconmed.PPDRizwanAppApplication;
import com.pro.rizwan.ppdmuhammadrizwanconmed.R;
import com.pro.rizwan.ppdmuhammadrizwanconmed.services.GetHeartRateServices;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainActivityContractor.View{
@Inject
MainActivityPresenter mainActivityPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mainActivityPresenter.onAttachView(this);
        PPDRizwanAppApplication.get(this).getHomeComponent().inject(this);
        mainActivityPresenter.onAttachView(this);

    }

    public void startHeartRateService(View view) {
mainActivityPresenter.startHeartRateService(this);
    }

    @Override
    public void showError(String e) {

    }

    @Override
    public void showProgress(String progress) {
        Toast.makeText(this, progress, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStop() {
        super.onStop();
        PPDRizwanAppApplication.get(this).clearHomeComponent();
    }
}
