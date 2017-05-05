package com.example.social_contacts.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.social_contacts.R;
import com.example.social_contacts.model.DataModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yashica on 22/4/17.
 * Company PhyderCmss
 */
public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    private List<DataModel> mContacts;

    public ContactAdapter(List<DataModel> contactsList) {
        this.mContacts = contactsList;
    }

    public DataModel getItemAt(int pos) {
        return mContacts.get(pos);
    }


    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_model, parent, false);
        return new ContactViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        holder.bind(mContacts.get(position));

    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        private TextView txtContactName;
        private TextView txtContactValue;
        private TextView txtProfileName;

        public ContactViewHolder(View itemView) {
            super(itemView);
            txtContactName = (TextView) itemView.findViewById(R.id.contact_name);
            txtContactValue = (TextView) itemView.findViewById(R.id.contact_value);
            txtProfileName = (TextView) itemView.findViewById(R.id.txt_profile);
        }
        public void bind(DataModel model) {
            txtContactName.setText(model.getContactName());
            txtContactValue.setText(model.getContactValue());
            txtProfileName.setText(model.getContactName().substring(0, 1));
        }
    }
    public void setFilter(List<DataModel> dataModels) {
        mContacts = new ArrayList<>();
        mContacts.addAll(dataModels);
        notifyDataSetChanged();
    }
}

