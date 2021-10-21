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

public class WorldAdapter extends ArrayAdapter <WorldDataModel> {

    public WorldAdapter( Context context, ArrayList<WorldDataModel> worldDataModels) {
        super(context, 0,  worldDataModels);
    }

    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        View listItem = convertView;
        if (listItem == null ) {
            listItem = LayoutInflater.from(getContext()).inflate(R.layout.list_item_layout, parent, false);
        }

        WorldDataModel currentWorld = getItem(position);

        ImageView imageView = (ImageView) listItem.findViewById(R.id.image_on_cardview);
        imageView.setImageDrawable(currentWorld.getImageThumbnail());

        TextView textView = (TextView) listItem.findViewById(R.id.location_name);
        textView.setText(currentWorld.getName());

        TextView textView1 = (TextView) listItem.findViewById(R.id.places_name);
        textView1.setText(currentWorld.getAddress());

        return listItem;
    }
}

