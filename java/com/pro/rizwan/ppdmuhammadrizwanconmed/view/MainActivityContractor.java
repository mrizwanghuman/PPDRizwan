package com.pro.rizwan.ppdmuhammadrizwanconmed.view;


import android.content.Context;
import android.widget.TextView;

import com.pro.rizwan.ppdmuhammadrizwanconmed.utils.BasePresenter;
import com.pro.rizwan.ppdmuhammadrizwanconmed.utils.BaseView;

import java.util.List;

/**
 * Created by  Admin on 3/16/2018.
 */



    public interface MainActivityContractor {
        interface View extends BaseView {
            void showProgress(String progress);
            void setHeartRateList(List<Integer> heartRateList);

        }
        interface Presenter extends BasePresenter<View> {
            void startHeartRateService(Context context);


        }
    }

