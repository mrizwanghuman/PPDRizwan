package com.pro.rizwan.ppdmuhammadrizwanconmed.utils;

/**
 * Created by  Admin on 3/16/2018.
 */

public interface BasePresenter  <V extends BaseView> {
    void onAttachView(V view);
    void onDetachView();
}
