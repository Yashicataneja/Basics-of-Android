package com.example.cmss.learningsocialsdk.dashboard;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.cmss.learningsocialsdk.R;

import java.util.ArrayList;
import java.util.List;

public class DashBoardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board2);
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
        RecyclerView dashboard = (RecyclerView) findViewById(R.id.dashboard);
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
        List<DashboardOption>allItems=new ArrayList<>();
        allItems.add(new DashboardOption(getString(R.string.account),R.drawable.ic_account_24dp));
        allItems.add(new DashboardOption(getString(R.string.transfer),R.drawable.ic_transfer_24dp));
        allItems.add(new DashboardOption(getString(R.string.payment),R.drawable.ic_payment_24px));
        allItems.add(new DashboardOption(getString(R.string.social_social),R.drawable.ic_social_24dp));
        return allItems;
    }


}
