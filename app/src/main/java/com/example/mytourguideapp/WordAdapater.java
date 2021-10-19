package com.example.mytourguideapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdapater extends ArrayAdapter<WordDataModel> {

    private int colorResouceId;


    public WordAdapater(Activity context, ArrayList<WordDataModel> wordDataModelArrayList, int colorCategory) {
        super(context, 0, wordDataModelArrayList);
        colorResouceId = colorCategory;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_layout, parent, false);
        }
        WordDataModel currentNumbersList = getItem(position);

        TextView listItemDefaultTranslation = (TextView) listItemView.findViewById(R.id.places_name);
        listItemDefaultTranslation.setText(currentNumbersList.getDefaultTrasnlation());

        TextView indoTranslationList = (TextView) listItemView.findViewById(R.id.location_name);
        indoTranslationList.setText(currentNumbersList.getLanguangeTranslation());

        ImageView imageViewList = (ImageView) listItemView.findViewById(R.id.image_on_cardview);
        if (currentNumbersList.hasImage()){
            imageViewList.setImageResource(currentNumbersList.getImageDrawable());

            imageViewList.setVisibility(View.VISIBLE);
        } else {
            imageViewList.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), colorResouceId);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}

