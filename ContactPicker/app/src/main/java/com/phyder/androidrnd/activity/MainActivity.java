package com.phyder.androidrnd.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.phyder.androidrnd.Adapter.CustomListAdapter;
import com.phyder.androidrnd.R;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> UIElements= new ArrayList<>(Arrays.asList("TextView","EditText","Button","Spinner","Picker"));
    ArrayList<Integer> Images=new ArrayList<Integer>(Arrays.asList(R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        // set a LinearLayoutManager with default horizontal orientation and false value for reverseLayout to show the items from start to end
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        CustomListAdapter customListAdapter = new CustomListAdapter(MainActivity.this, UIElements,Images);
        recyclerView.setAdapter(customListAdapter); // set the Adapter to RecyclerView



    }
}
