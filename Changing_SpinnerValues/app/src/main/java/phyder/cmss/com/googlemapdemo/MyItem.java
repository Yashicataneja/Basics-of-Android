package phyder.cmss.com.googlemapdemo;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;

/**
 * Created by Gouresh on 16/2/17
 * Company PhyderCmss.
 */

public class MyItem implements ClusterItem {
    private final LatLng mPosition;

    private String mTitle;
    private String mSnippet;

    public MyItem(double lat, double lng) {
        mPosition = new LatLng(lat, lng);
    }

    public MyItem(double lat, double lng, String title, String snippet) {
        mPosition = new LatLng(lat, lng);
        mTitle = title;
        mSnippet = snippet;
    }

    @Override
    public LatLng getPosition() {
        return mPosition;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmSnippet() {
        return mSnippet;
    }
}