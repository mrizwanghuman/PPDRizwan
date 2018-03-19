package com.pro.rizwan.ppdmuhammadrizwanconmed;

import android.app.Application;
import android.content.Context;


import com.pro.rizwan.ppdmuhammadrizwanconmed.module.component.AppComponent;
import com.pro.rizwan.ppdmuhammadrizwanconmed.module.component.DaggerAppComponent;
import com.pro.rizwan.ppdmuhammadrizwanconmed.module.component.HomeComponent;
import com.pro.rizwan.ppdmuhammadrizwanconmed.module.module.AppsModule;
import com.pro.rizwan.ppdmuhammadrizwanconmed.module.module.HomeModule;

public class PPDRizwanAppApplication extends Application {


    private AppComponent appComponent;
    private HomeComponent homeComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        AppsModule appsModule = new AppsModule();
        appComponent = DaggerAppComponent.builder().appsModule(appsModule).build();
    }

    public static PPDRizwanAppApplication get(Context context) {
        return (PPDRizwanAppApplication) context.getApplicationContext();
    }

    public HomeComponent getHomeComponent() {
        homeComponent = appComponent.add(new HomeModule());
        return homeComponent;
    }

    public void clearHomeComponent() {
        homeComponent = null;

    }
}
