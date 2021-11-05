package com.example.mytourguideapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class WorldAdapter extends ArrayAdapter<WorldDataModel> {

    public WorldAdapter(Context context, ArrayList<WorldDataModel> worldDataModels) {
        super(context, 0, worldDataModels);
    }

    //adapters for inflate data to list item layout.
//    @Override
//    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
//
//        if (convertView == null) {
//            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_layout, parent, false);
//        }
//        // get item posistion
//        WorldDataModel currentWorld = getItem(position);
//
//        ImageView imageView = (ImageView) convertView.findViewById(R.id.image_on_cardview);
//        imageView.setImageDrawable(currentWorld.getImageThumbnail());
//
//        TextView textView = (TextView) convertView.findViewById(R.id.location_name);
//        textView.setText(currentWorld.getName());
//
//        TextView textView1 = (TextView) convertView.findViewById(R.id.places_name);
//        textView1.setText(currentWorld.getAddress());
//
//        return convertView;
//    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;
        ViewHolder viewHolder;

        if (itemView == null) {
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_layout, parent, false);
            viewHolder = new ViewHolder(itemView);
            itemView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) itemView.getTag();
        }
        //get position
        WorldDataModel currentWorld = getItem(position);
        //inflate to viewHolder
        viewHolder.imageView.setImageDrawable(currentWorld.getImageThumbnail());
        viewHolder.textView.setText(currentWorld.getName());
        viewHolder.textView1.setText(currentWorld.getAddress());

        return itemView;
    }

    public static class ViewHolder{
        TextView textView, textView1;
        ImageView imageView;

        public ViewHolder(View converView){
            imageView = converView.findViewById(R.id.image_on_cardview);
            textView = converView.findViewById(R.id.location_name);
            textView1 = converView.findViewById(R.id.places_name);
        }
    }

}

