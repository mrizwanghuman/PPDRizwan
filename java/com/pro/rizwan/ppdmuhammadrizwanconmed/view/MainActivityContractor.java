package com.pro.rizwan.ppdmuhammadrizwanconmed.view;


import android.content.Context;

import com.pro.rizwan.ppdmuhammadrizwanconmed.utils.BasePresenter;
import com.pro.rizwan.ppdmuhammadrizwanconmed.utils.BaseView;

/**
 * Created by  Admin on 3/16/2018.
 */



    public interface MainActivityContractor {
        interface View extends BaseView {
            void showProgress(String progress);

        }
        interface Presenter extends BasePresenter<View> {
            void startHeartRateService(Context context);


        }
    }

