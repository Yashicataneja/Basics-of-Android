package com.example.cmss.learningsocialsdk.dashboard;

import android.support.annotation.DrawableRes;


public class DashboardOption {

    private String mName;

    @DrawableRes
    private int mIcon;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public int getIcon() {
        return mIcon;
    }

    public void setIcon(int icon) {
        this.mIcon = icon;
    }

    public DashboardOption(String name, @DrawableRes int icon) {
        mName = name;
        mIcon = icon;
    }

    @Override
    public String toString() {
        return "Dashboard Option: " + mName;
    }
}
