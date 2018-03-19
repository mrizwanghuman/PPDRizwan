package com.pro.rizwan.ppdmuhammadrizwanconmed.module.module;



import com.pro.rizwan.ppdmuhammadrizwanconmed.view.MainActivityPresenter;

import dagger.Module;
import dagger.Provides;


@Module
public class HomeModule {
    @Provides
    MainActivityPresenter providesHomePresenter(){
        return new MainActivityPresenter();
    }
}
