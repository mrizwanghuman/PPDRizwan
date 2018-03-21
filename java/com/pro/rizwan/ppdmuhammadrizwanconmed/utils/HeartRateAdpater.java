package com.pro.rizwan.ppdmuhammadrizwanconmed.utils;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pro.rizwan.ppdmuhammadrizwanconmed.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by  Admin on 3/20/2018.
 */

public class HeartRateAdpater extends RecyclerView.Adapter<HeartRateAdpater.ViewHolder> {
    List<String> heartRateList = new ArrayList<>();

//    @BindView(R.id.tvHeartRate)
//    TextView tvHeartRate;

    public HeartRateAdpater(List<String> heartRateList) {
        this.heartRateList = heartRateList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.heart_rate_rc, parent, false);
//        ButterKnife.bind(this, view);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String heartRate = heartRateList.get(position);
        holder.tvHeartRate.setText(position+" "+heartRate);

    }

    @Override
    public int getItemCount() {
        return heartRateList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

@BindView(R.id.tvHeartRate)
TextView tvHeartRate;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
