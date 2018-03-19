package com.pro.rizwan.ppdmuhammadrizwanconmed.view;


import android.content.Context;
import android.content.Intent;

import com.pro.rizwan.ppdmuhammadrizwanconmed.services.GetHeartRateServices;

/**
 * Created by  Admin on 3/16/2018.
 */

public class MainActivityPresenter implements MainActivityContractor.Presenter {
    private MainActivityContractor.View mainContractView;

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
}
