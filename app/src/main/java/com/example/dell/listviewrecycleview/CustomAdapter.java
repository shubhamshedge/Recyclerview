package com.example.dell.listviewrecycleview;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.listviewrecycleview.model.DataModel;

import java.util.ArrayList;

/**
 * Created by DELL on 1/24/2017.
 */

public class CustomAdapter extends RecyclerView.Adapter< CustomAdapter.ViewHolder>
{

    private ArrayList<DataModel> dataSet;
    Context mContext;


    public CustomAdapter(ArrayList<DataModel> data, Context context) {
        this.dataSet = data;
        this.mContext = context;

    }



    public static class ViewHolder extends RecyclerView.ViewHolder
    {

        TextView txtName;
        TextView txtType;
        TextView txtVersion;
        ImageView info;

        public ViewHolder(View V)

        {
            super(V);
            txtName = (TextView) V.findViewById(R.id.name);
            txtType = (TextView) V.findViewById(R.id.type);
            txtVersion = (TextView) V.findViewById(R.id.version_number);
            info = (ImageView) V.findViewById(R.id.item_info);
        }
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item, parent, false);
        // set the view's size, margins, paddings and layout parameters

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DataModel model = dataSet.get(position);
        holder.txtName.setText(model.getName());
        holder.txtType.setText(model.getType());
        holder.txtVersion.setText(model.getVersion_number());
        holder.info.setTag(position);



    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}