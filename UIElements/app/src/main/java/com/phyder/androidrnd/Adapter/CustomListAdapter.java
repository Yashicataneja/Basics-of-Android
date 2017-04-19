package com.phyder.androidrnd.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.phyder.androidrnd.R;
import com.phyder.androidrnd.activity.FifthActivty;
import com.phyder.androidrnd.activity.TextView_Activity;
import com.phyder.androidrnd.activity.FourthActivity;
import com.phyder.androidrnd.activity.EditText_Activity;
import com.phyder.androidrnd.activity.ThirdActivity;

import java.util.ArrayList;

/**
 * Created by Yashica on 13/4/17.
 * Company PhyderCmss
 */

public class CustomListAdapter extends RecyclerView.Adapter<CustomListAdapter.MyViewHolder> {
    ArrayList<String> UIElements;
    ArrayList<Integer> Images;
    Context context;

    public CustomListAdapter(Context context, ArrayList<String> uiElements, ArrayList<Integer> images) {
        this.UIElements = uiElements;
        this.Images = images;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        // init the item view's
        TextView element;
        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);

            // get the reference of item view's
            element = (TextView) itemView.findViewById(R.id.element);
            image = (ImageView) itemView.findViewById(R.id.image);


        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_contents, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        // set the data in items
        holder.element.setText(UIElements.get(position));
        holder.image.setImageResource(Images.get(position));
        // implement setOnClickListener event on item view.

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (position) {

                    case 0:
                        Toast.makeText(context, "Position: " + position, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(context, TextView_Activity.class);
                        context.startActivity(intent);
                        break;

                    case 1:
                        Intent intent1 = new Intent(context, EditText_Activity.class);
                        context.startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(context, ThirdActivity.class);
                        context.startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(context, FourthActivity.class);
                        context.startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(context, FifthActivty.class);
                        context.startActivity(intent4);
                        break;


                }
                // display a toast with person name on item click
                Toast.makeText(context, UIElements.get(position), Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return UIElements.size();
    }


}
