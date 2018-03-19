package com.pro.rizwan.ppdmuhammadrizwanconmed.module.component;

import com.pro.rizwan.ppdmuhammadrizwanconmed.module.module.HomeModule;
import com.pro.rizwan.ppdmuhammadrizwanconmed.view.MainActivity;

import dagger.Subcomponent;


@Subcomponent(modules = HomeModule.class)
public interface HomeComponent {
    void inject(MainActivity homeActivity);
}
