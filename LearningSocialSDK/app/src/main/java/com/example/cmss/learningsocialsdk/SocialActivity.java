package com.example.cmss.learningsocialsdk;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.cmss.learningsocialsdk.dashboard.DashboardOption;
import com.example.cmss.learningsocialsdk.dashboard.DashboardOptionAdapter;

import java.util.ArrayList;
import java.util.List;

public class SocialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        RecyclerView dashboard = (RecyclerView) findViewById(R.id.social_social);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        dashboard.setHasFixedSize(true);
        // use a grid layout manager
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        dashboard.setLayoutManager(mLayoutManager);

        RecyclerView.Adapter adapter = new DashboardOptionAdapter(this, getAllItemList());
        dashboard.setAdapter(adapter);
    }

    private List<DashboardOption> getAllItemList() {

        List<DashboardOption> allItems=new ArrayList<>();
        allItems.add(new DashboardOption(getString(R.string.social_send_money), R.drawable.ic_send_money_24dp));
        allItems.add(new DashboardOption(getString(R.string.social_request_money), R.drawable.ic_request_money_24dp));
        allItems.add(new DashboardOption(getString(R.string.social_split_share), R.drawable.ic_split_share_24dp));
        return  allItems;
    }
}


