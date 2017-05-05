package com.example.cmss.media_player;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

     Button btn_play,btn_pause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_play=(Button)findViewById(R.id.btn_play);
        btn_pause=(Button)findViewById(R.id.btn_pause);
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Play",Toast.LENGTH_LONG).show();
            }
        });

    btn_pause.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this,"Pause",Toast.LENGTH_LONG).show();
        }
    });
}
}
