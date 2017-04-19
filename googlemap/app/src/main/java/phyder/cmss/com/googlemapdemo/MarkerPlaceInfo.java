package phyder.cmss.com.googlemapdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MarkerPlaceInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marker_place_info);

       Bundle b = getIntent().getExtras();
        String placeInfo = (String) b.get("title");

        TextView txtplacename = (TextView) findViewById(R.id.txtplacename);

        txtplacename.setText(placeInfo);



    }
}
