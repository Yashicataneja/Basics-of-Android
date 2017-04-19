package com.phyder.androidrnd.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.phyder.androidrnd.R;

/**
 * Created by Yashica on 13/4/17.
 * Company PhyderCmss
 */
public class ThirdActivity extends AppCompatActivity {
    Button btnsimple;
    ImageButton imgbtn;
    ToggleButton toggle;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        btnsimple = (Button) findViewById(R.id.simple_button);
        imgbtn = (ImageButton) findViewById(R.id.imgButton);
         toggle = (ToggleButton) findViewById(R.id.toggleButton);
        btnsimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ThirdActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ThirdActivity.this, MainActivity.class);
                startActivity(i);
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                // The toggle is enabled
            } else {
                // The toggle is disabled
            }
        }
    });
    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_yes:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.radio_no:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }

    public void onCheckboxClicked(View view) {
//         Is the view now checked?
            boolean checked = ((CheckBox) view).isChecked();

            // Check which checkbox was clicked
            switch(view.getId()) {
                case R.id.checkbox_Veg:
                    if (checked)
                        Toast.makeText(getApplicationContext(),"Veg Sandwich",Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(getApplicationContext(),"Choice other",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.checkbox_NonVeg:
                    if (checked)
                        Toast.makeText(getApplicationContext(),"NonVeg Sandwich",Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(getApplicationContext(),"choice other",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.checkbox_Both:
                    Toast.makeText(getApplicationContext(),"Mix Sandwich",Toast.LENGTH_SHORT).show();
            }
        }

    }

