package com.example.cmss.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnplay, btnpause;

    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnplay=(Button)findViewById(R.id.Play);
        btnpause=(Button)findViewById(R.id.Pause);

        mediaPlayer = MediaPlayer.create(this, R.raw.baarish2_29274);

        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
//                Toast.makeText(MainActivity.this,"Play",Toast.LENGTH_LONG).show();
            }
        });
        btnpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
//                Toast.makeText(MainActivity.this,"Pause",Toast.LENGTH_LONG).show();
            }
        });
    }
}
