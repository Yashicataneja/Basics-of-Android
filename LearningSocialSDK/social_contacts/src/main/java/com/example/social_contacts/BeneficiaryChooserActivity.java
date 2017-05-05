package com.example.social_contacts;

import android.Manifest;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.social_contacts.Adapter.ContactAdapter;
import com.example.social_contacts.model.DataModel;

import java.util.ArrayList;
import java.util.List;

public class BeneficiaryChooserActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private static final String TAG = BeneficiaryChooserActivity.class.getSimpleName();
    private static final int CONTACT_PERM_REQUEST = 1;
    private static final int EMAIL_PERM_REQUEST = 1;
    RelativeLayout ll;
    String[] socialNetwork;
    String mSocialId;
    private WebView webView;

    ProgressDialog progressDialog;
    DataModel selectedData;
    ContactAdapter mContactAdapter;
    String code = "";

    private RecyclerView recyclerView;
    Context mContext;
    //    String[] socialChannel = new String[]{"email", "sms", "WhatsApp", "facebook"};
    String[] socialChannel = new String[]{"facebook"};

    ArrayList<DataModel> smsContact;

    private AdapterView.OnItemSelectedListener mOnItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            if (mSocialId.equals(getString(R.string.social_channel_sms))) {
                LoadContactsAyscn contactsAyscn = new LoadContactsAyscn();
                contactsAyscn.execute();
            } else if (mSocialId.equals(getString(R.string.social_channel_email))) {
                GetEmailContact emailContact = new GetEmailContact();
                emailContact.execute();
            } else if (mSocialId.equals(getString(R.string.social_channel_whatsapp))) {
                LoadWhatsappContacts whatsappContacts = new LoadWhatsappContacts();
                whatsappContacts.execute();
            } else {
                Log.i("No Contact Found", "");
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            Toast.makeText(getApplicationContext(), "Please select one", Toast.LENGTH_LONG).show();
        }
    };

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
    ListView socialListChannel;
    Integer[] imageID={
            R.drawable.email,
            R.drawable.sms,
            R.drawable.whatsapp,
            R.drawable.facebook,
            R.drawable.twitter,
            R.drawable.linkedin
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beneficiary_chooser);
    }

    public class LoadContactsAyscn extends AsyncTask<Void, Void, ArrayList<DataModel>> {
        ProgressDialog pd;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd = ProgressDialog.show(BeneficiaryChooserActivity.this, "Loading Contacts",
                    "Please Wait");
        }

        @Override
        protected ArrayList<DataModel> doInBackground(Void... params) {

            smsContact = new ArrayList<DataModel>();

            Cursor c = getContentResolver().query(
                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                    null, null, null + " ASC");
            while (c.moveToNext()) {

                String name = c
                        .getString(c
                                .getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String number = c
                        .getString(c
                                .getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));


                DataModel dataModel = new DataModel(name, number, false);
                smsContact.add(dataModel);

                Log.i("Contacts: Dharam", "" + smsContact.size());
            }

            c.close();
            return smsContact;
        }

        @Override
        protected void onPostExecute(ArrayList<DataModel> contacts) {
            super.onPostExecute(smsContact);
            pd.dismiss();
            mContactAdapter = new ContactAdapter(smsContact);
            recyclerView.setAdapter(mContactAdapter);
        }
    }

    class LoadWhatsappContacts extends AsyncTask<Void, Void, ArrayList<DataModel>> {
        ProgressDialog pd;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd = ProgressDialog.show(BeneficiaryChooserActivity.this, getString(R.string.whatsapp_contact_message),
                    "Please Wait");
        }

        @Override
        protected ArrayList<DataModel> doInBackground(Void... params) {

            smsContact = new ArrayList<DataModel>();

            ContentResolver cr = getContentResolver();
            Cursor c = getApplicationContext().getContentResolver().query(
                    ContactsContract.RawContacts.CONTENT_URI,
                    new String[]{
                            ContactsContract.RawContacts.CONTACT_ID, ContactsContract.RawContacts.DISPLAY_NAME_PRIMARY
                    },
                    ContactsContract.RawContacts.ACCOUNT_TYPE + "= ?",
                    new String[]{
                            "com.whatsapp"
                    },
                    null);
            if (c != null) {
                if (c.getCount() > 0) {
                    if (c.moveToFirst()) {
                        do {
                            String whatsappContactId = c.getString(c.getColumnIndex(ContactsContract.RawContacts.CONTACT_ID));
                            if (whatsappContactId != null) {
                                Cursor whatsAppContactCursor = cr.query(
                                        ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                                        new String[]{ContactsContract.CommonDataKinds.Phone.CONTACT_ID,
                                                ContactsContract.CommonDataKinds.Phone.NUMBER,
                                                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME},
                                        ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                                        new String[]{whatsappContactId}, null);
                                if (whatsAppContactCursor != null) {
                                    whatsAppContactCursor.moveToFirst();
                                    String id = whatsAppContactCursor.getString(whatsAppContactCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.CONTACT_ID));
                                    String name = whatsAppContactCursor.getString(whatsAppContactCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                                    String number = whatsAppContactCursor.getString(whatsAppContactCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                                    DataModel dataModel = new DataModel(name, number, false);
                                    whatsAppContactCursor.close();
                                    smsContact.add(dataModel);
                                    int a = smsContact.size();
                                    Log.e(TAG, "no of contact whatsapps: " + a);
                                }
                            }
                        } while (c.moveToNext());
                        c.close();
                    }
                }
            }
            return smsContact;
        }

        @Override
        protected void onPostExecute(ArrayList<DataModel> whatsappContacts) {
            super.onPostExecute(smsContact);
            pd.dismiss();

            mContactAdapter = new ContactAdapter(smsContact);

            recyclerView.setAdapter(mContactAdapter);
        }
    }

    class GetEmailContact extends AsyncTask<Void, Void, ArrayList<DataModel>> {

        ProgressDialog pd;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd = ProgressDialog.show(BeneficiaryChooserActivity.this, "loading contacts",
                    "please wait");
        }

        @Override
        protected ArrayList<DataModel> doInBackground(Void... params) {

            smsContact = new ArrayList<DataModel>();

            ContentResolver cr = getContentResolver();
            Cursor emailCur = cr.query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, null, null, null, null);

            while (emailCur.moveToNext()) {
                String name = emailCur.getString(emailCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME_PRIMARY));
                String email = emailCur.getString(emailCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DATA));
                DataModel dataModel = new DataModel(name, email, false);
                smsContact.add(dataModel);
            }
            emailCur.close();
            return smsContact;
        }

        @Override
        protected void onPostExecute(ArrayList<DataModel> emailContacts) {
            super.onPostExecute(smsContact);
            pd.dismiss();
            mContactAdapter = new ContactAdapter(smsContact);
            recyclerView.setAdapter(mContactAdapter);
        }
    }


}
