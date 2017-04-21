package com.example.cmss.learningsocialsdk;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cmss.learningsocialsdk.Util.ActivityCoordinator;

public class LoginActivity extends AppCompatActivity {

  TextInputLayout m_pinTextInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
        }

        m_pinTextInputLayout = (TextInputLayout) findViewById(R.id.txt_m_pin);
        EditText editText = m_pinTextInputLayout.getEditText();
        if (editText != null) {
            editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView view, int actionId, KeyEvent event) {
                    if (actionId == EditorInfo.IME_ACTION_DONE) {
                        // Check if no view has focus:
                        if (view != null) {
                            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                        }

                        login(view);
                        return true;
                    }
                    return false;
                }
            });
        }

    }

    public void login(View view) {

        m_pinTextInputLayout.setError(null);
        EditText editText = m_pinTextInputLayout.getEditText();

        if (editText != null) {
            if (InternetConnection.checkInternet(this)) {
                String mPin = editText.getText().toString();

                if (!mPin.equals("") && !mPin.isEmpty()) {
                    final ProgressDialog progress = new ProgressDialog(this);
                    progress.setMessage("Authenticating ...");
                    progress.show();

                    progress.dismiss();
                    ActivityCoordinator.openDashboard(LoginActivity.this);
                    finish();
//
                    return;
                }
                Toast.makeText(this, "Enter valid mpin", Toast.LENGTH_SHORT).show();
                m_pinTextInputLayout.setError("Login Failure");
            }
        } else {
            Log.i("NO Internet ", "Connection");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
