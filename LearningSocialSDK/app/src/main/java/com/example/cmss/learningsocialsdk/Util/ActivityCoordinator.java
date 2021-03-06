package com.example.cmss.learningsocialsdk.Util;

import android.app.Activity;
import android.content.Intent;

import com.example.cmss.learningsocialsdk.SocialActivity;
import com.example.cmss.learningsocialsdk.dashboard.DashBoardActivity;
import com.example.social_contacts.BeneficiaryChooserActivity;
import com.example.social_contacts.requestMoney.RequestMoneyChooserActivity;
import com.example.social_contacts.splitAndShare.ShareMoneyChooserActivity;


/**
 * Created by Yashica on 11/4/17.
 * Company PhyderCmss
 */
public class ActivityCoordinator {

    public static void openDashboard(Activity activity) {
        Intent intent = new Intent(activity, DashBoardActivity.class);
        activity.startActivity(intent);
    }

    public static void openSocial(Activity activity ) {
        Intent intent = new Intent(activity, SocialActivity.class);
        activity.startActivity(intent);
    }

    public static void openSocialSendMoney(Activity activity) {
        Intent intent = new Intent(activity, BeneficiaryChooserActivity.class);
        activity.startActivity(intent);
    }

    public static void openSplitShareMoney(Activity activity) {
        Intent intent = new Intent(activity, RequestMoneyChooserActivity.class);
        activity.startActivity(intent);
    }

    public static void openSocialRequestMoney(Activity activity) {
        Intent intent = new Intent(activity, ShareMoneyChooserActivity.class);
        activity.startActivity(intent);
    }
}
