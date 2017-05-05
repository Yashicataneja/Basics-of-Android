package com.example.social_contacts.model;

import java.io.Serializable;

/**
 * Created by Yashica on 22/4/17.
 * Company PhyderCmss
 */

public class DataModel implements Serializable {

    private String mContactName;
    private String mContactValue;
    public Boolean isItemSelected;

    public DataModel(String ContactName, String ContactValue, Boolean ItemSelected) {
        this.mContactName = ContactName;
        this.mContactValue = ContactValue;
        this.isItemSelected = ItemSelected;
    }

    public String getContactName() {
        return mContactName;
    }

    public void setmContactName(String mContactName) {
        this.mContactName = mContactName;
    }

    public String getContactValue() {
        return mContactValue;
    }

    public void setmContactValue(String mContactValue) {
        this.mContactValue = mContactValue;
    }

    public Boolean getItemSelected() {
        return isItemSelected;
    }

    public void setItemSelected(Boolean itemSelected) {
        isItemSelected = itemSelected;
    }

    @Override
    public String toString() {
        return "DataModel{" +
                "mContactName='" + mContactName + '\'' +
                ", mContactValue='" + mContactValue + '\'' +
                '}';
    }
}
