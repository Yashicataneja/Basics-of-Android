package com.phyder.androidrnd.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.phyder.androidrnd.R;

/**
 * Created by Yashica on 13/4/17.
 * Company PhyderCmss
 */
public class EditText_Activity extends AppCompatActivity{
    EditText edtName,edttxtpwd,edtnumpwd,edtmail,edtpostalAdd,edtmultiline,edttime,edtdate,edtsalary;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        edtName=(EditText)findViewById(R.id.textPersonName);
        edttxtpwd=(EditText)findViewById(R.id.textPassword);
        edtnumpwd=(EditText)findViewById(R.id.numberPassword);
        edtmail=(EditText)findViewById(R.id.textEmailAddress);
        edtpostalAdd=(EditText)findViewById(R.id.textPostalAddress);
        edtmultiline=(EditText)findViewById(R.id.textMultiLine);
        edttime=(EditText)findViewById(R.id.Time);
        edtdate=(EditText)findViewById(R.id.date);
        edtsalary=(EditText)findViewById(R.id.numberDecimal);
//        finish();
    }
}
