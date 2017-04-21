package com.example.cmss.learningsocialsdk.dashboard;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cmss.learningsocialsdk.R;
import com.example.cmss.learningsocialsdk.Util.ActivityCoordinator;

public class DashboardOptionHolders extends RecyclerView.ViewHolder implements View.OnClickListener {

    private DashboardOption mOption;
    private Context mContext;

    public ImageView icon;
    public TextView name;


    public DashboardOptionHolders(Context context, View itemView) {
        super(itemView);

        mContext = context;
        name = (TextView) itemView.findViewById(R.id.option_name);
        icon = (ImageView) itemView.findViewById(R.id.option_icon);
        itemView.setOnClickListener(this);
    }

    public void bind(DashboardOption option) {
        mOption = option;
        name.setText(option.getName());
        icon.setImageResource(option.getIcon());
        icon.setContentDescription(option.getName());
    }

    @Override
    public void onClick(View view) {
        if (mOption.getName().equals(mContext.getString(R.string.social_social))) {


                    ActivityCoordinator.openSocial((Activity) mContext);

            return;
        }
        if (mOption.getName().equals(mContext.getString(R.string.social_send_money))) {
            ActivityCoordinator.openSocialSendMoney((Activity) mContext);
            return;
        }
        if (mOption.getName().equals(mContext.getString(R.string.social_split_share))) {
            ActivityCoordinator.openSplitShareMoney((Activity) mContext);
        }
        if (mOption.getName().equals(mContext.getString(R.string.social_request_money))) {
            ActivityCoordinator.openSocialRequestMoney((Activity) mContext);
        }
    }
}
