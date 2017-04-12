package com.example.cmss.learningsocialsdk;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.support.v7.app.AlertDialog;
import android.util.Log;

/**
 * Created by Yashica on 11/4/17.
 * Company PhyderCmss
 */
public class InternetConnection {
    public static boolean checkInternet(Activity mActivity) {
        ConnectivityManager connec = (ConnectivityManager) mActivity.getSystemService(Context.CONNECTIVITY_SERVICE);
        android.net.NetworkInfo wifi = connec.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        android.net.NetworkInfo mobile = connec.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (wifi.isConnected() || mobile.isConnected()) {
            return true;
        } else if (!mobile.isConnected() || !wifi.isConnected()) {
            alert(mActivity);
            return false;
        }
        return false;
    }

    public static boolean alert(final Context context) {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);

        // Setting Dialog Title
        alertDialog.setTitle("No Internet Connection Found");

        // Setting Dialog Message
        alertDialog.setMessage("Enable your internet connection");

        // Setting Icon to Dialog
        alertDialog.setIcon(R.drawable.warning);

        // Setting Positive "Yes" Button
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                // Write your code here to invoke YES event
                Log.i("Please enable ", "internet connection");
            }
        });
        alertDialog.show();
        return true;
    }
}
