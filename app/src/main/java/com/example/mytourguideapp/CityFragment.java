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

public class CityFragment extends Fragment {

    // location size limit to 10
    // cityfragment is no 2
    private final int LOCATION_SIZE = 10;
    private final int LOCATION_TYPE = 2;

    public CityFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //inflate to list xml
        View rootView = inflater.inflate(R.layout.word_list_activity, container, false);

        String name, imageName, address;
        Drawable image;
        int resourceId, imageId;

        //add list
        final ArrayList<WorldDataModel> cityArrays = new ArrayList<WorldDataModel>();
        for (int c = 1; c <= LOCATION_SIZE; c++) {

            //get name location
            resourceId = getResources().getIdentifier("location_name_" + LOCATION_TYPE
                    + "_" + c, "string", getActivity().getPackageName());
            name = getResources().getString(resourceId);

            //get address location
            resourceId = getResources().getIdentifier("location_address_" + LOCATION_TYPE
                    + "_" + c, "string", getActivity().getPackageName());
            address = getResources().getString(resourceId);

            //get image thumbnail
            resourceId = getResources().getIdentifier("location_thumbnail_" + LOCATION_TYPE
                    + "_" + c, "string", getActivity().getPackageName());
            imageName = getResources().getString(resourceId);
            imageId = getResources().getIdentifier(imageName, "drawable", getActivity().getPackageName());
            image = getResources().getDrawable(imageId);

            cityArrays.add(new WorldDataModel(name, address, image));
        }

        // using simple recyceview
        WorldAdapter adapter = new WorldAdapter(getActivity(), cityArrays);
        ListView listView = (ListView) rootView.findViewById(R.id.word_list_activity);
        listView.setAdapter(adapter);

        //add onclick behavior
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), " item clicked", Toast.LENGTH_SHORT).show();

                WorldDataModel worldDataModel = cityArrays.get(position);
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