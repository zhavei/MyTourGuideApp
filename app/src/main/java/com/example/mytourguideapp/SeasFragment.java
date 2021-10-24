package com.example.mytourguideapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class SeasFragment extends Fragment {

    private final int LOCATION_SIZE = 10;
    private final int LOCATION_TYPE = 4;


    public SeasFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.word_list_activity, container, false);

        String name, address, imageName;
        Drawable image;
        int imageId, resourceId;

        final ArrayList<WorldDataModel> seasArrays = new ArrayList<>();
        for (int s = 1; s <= LOCATION_SIZE; s++){

            // get name
            resourceId = getResources().getIdentifier("location_name_" + LOCATION_TYPE + "_" + s,
                    "string", getActivity().getPackageName());
            name = getResources().getString(resourceId);

            //get address
            resourceId = getResources().getIdentifier("location_address_" + LOCATION_TYPE + "_" + s,
                    "string", getActivity().getPackageName());
            address = getResources().getString(resourceId);

            //get tumbnail

            resourceId = getResources().getIdentifier("location_thumbnail_" + LOCATION_TYPE + "_" + s,
                    "string", getActivity().getPackageName());
            imageName = getResources().getString(resourceId);
            imageId = getResources().getIdentifier(imageName, "drawable", getActivity().getPackageName());
            image = getResources().getDrawable(imageId);

            seasArrays.add(new WorldDataModel(name, address, image));
        }

        //inflate to recycle view
        WorldAdapter adapter = new WorldAdapter(getActivity(), seasArrays);
        ListView listView = (ListView) rootView.findViewById(R.id.list_layout);
        listView.setAdapter(adapter);

        //add click behavior
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "clidked", Toast.LENGTH_SHORT).show();

                WorldDataModel worldDataModel = seasArrays.get(position);
                Toast.makeText(getActivity(), " finish play", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                intent.putExtra("category", LOCATION_TYPE);
                intent.putExtra("location", position + 1);
                getActivity().startActivity(intent);
            }
        });


        // Inflate the layout for this fragment
        return rootView;
    }
}