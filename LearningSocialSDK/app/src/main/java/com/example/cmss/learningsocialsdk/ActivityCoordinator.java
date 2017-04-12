package com.example.cmss.learningsocialsdk;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by Yashica on 11/4/17.
 * Company PhyderCmss
 */
public class ActivityCoordinator {

    public static void openDashboard(Activity activity) {
        Intent intent = new Intent(activity, DashBoardActivity.class);
        activity.startActivity(intent);
    }

}
