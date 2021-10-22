package com.example.mytourguideapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;


public class MountainFragment extends Fragment {

    private final int LOCATION_SIZE = 10;
    private final int LOCATION_TYPE = 1;

    public MountainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.word_list_activity, container, false);

        String name, imageName, address;
        Drawable image;
        int resourceId, imageId;

        final ArrayList<WorldDataModel> mountainArrays = new ArrayList<WorldDataModel>();
        for (int n = 1; n <= LOCATION_SIZE; n++){
            //get Location Name
            resourceId = getResources().getIdentifier("location_name_" + LOCATION_TYPE
                    + "_" + n, "string", getActivity().getPackageName());
            name = getResources().getString(resourceId);

            //get address
            resourceId = getResources().getIdentifier("location_address_" + LOCATION_TYPE
                    + "_" + n, "string", getActivity().getPackageName());
            address = getResources().getString(resourceId);

            //get image thumbnail
            resourceId = getResources().getIdentifier("location_thumbnail_" + LOCATION_TYPE
                    + "_" + n, "string", getActivity().getPackageName());
            imageName = getResources().getString(resourceId);
            imageId = getResources().getIdentifier(imageName, "drawable", getActivity().getPackageName());
            image = getResources().getDrawable(imageId);

            //add new data to list
            mountainArrays.add(new WorldDataModel(name, address, image ));
        }


        // using simple recycle view
        WorldAdapter adapter = new WorldAdapter(getActivity(), mountainArrays);
        ListView listView = (ListView) rootView.findViewById(R.id.list_layout);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                WorldDataModel worldDataModel = mountainArrays.get(position);
                Intent intent = new Intent(getActivity(), DetailsActivity.class);

                Toast.makeText(getActivity(), " finish play", Toast.LENGTH_SHORT).show();

                intent.putExtra("category", LOCATION_TYPE);
                intent.putExtra("location", position + 1);

                getActivity().startActivity(intent);


            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }
}