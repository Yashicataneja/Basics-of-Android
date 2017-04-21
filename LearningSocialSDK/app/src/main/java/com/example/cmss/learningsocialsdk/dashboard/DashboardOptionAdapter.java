package com.example.cmss.learningsocialsdk.dashboard;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.cmss.learningsocialsdk.R;

import java.util.List;


public class DashboardOptionAdapter extends RecyclerView.Adapter<DashboardOptionHolders> {

    private List<DashboardOption> itemList;
    private Context context;

    public DashboardOptionAdapter(Context context, List<DashboardOption> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public DashboardOptionHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dashboard_options, null);
        DashboardOptionHolders doh = new DashboardOptionHolders(context, layoutView);
        return doh;
    }

    @Override
    public void onBindViewHolder(DashboardOptionHolders holder, int position) {
        holder.bind(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}


