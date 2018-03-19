package com.pro.rizwan.ppdmuhammadrizwanconmed.module.component;

import com.pro.rizwan.ppdmuhammadrizwanconmed.module.module.AppsModule;
import com.pro.rizwan.ppdmuhammadrizwanconmed.module.module.HomeModule;


import dagger.Component;


@Component(modules=AppsModule.class)
public interface AppComponent {
    HomeComponent add(HomeModule homeModule);
}
