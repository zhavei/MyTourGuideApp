package com.example.mytourguideapp;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class IslandFragment extends Fragment {
    private final int LOCATION_SIZE = 10;
    private final int LOCATION_TYPE = 3;

    public IslandFragment() {
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
        int resourceId, imageId;

        final ArrayList<WorldDataModel> islandArray = new ArrayList<WorldDataModel>();
        for (int i = 1; i <= LOCATION_SIZE; i++){
            //get location name
            resourceId = getResources().getIdentifier("location_name_" + LOCATION_TYPE + "_" + i, "string", getActivity().getPackageName());
            name = getResources().getString(resourceId);

            //get address name
            resourceId = getResources().getIdentifier("location_address_" + LOCATION_TYPE + "_" + i, "string", getActivity().getPackageName());
            address = getResources().getString(resourceId);

            //get image tubmnail
            resourceId = getResources().getIdentifier("location_thumbnail_" + LOCATION_TYPE + "_" + i, "string", getActivity().getPackageName());
            imageName = getResources().getString(resourceId);
            imageId = getResources().getIdentifier(imageName, "drawable", getActivity().getPackageName());
            image = getResources().getDrawable(imageId);

            //add data to list
            islandArray.add(new WorldDataModel(name, address, image));

        }

        //using simple rcyceview adapter
        WorldAdapter adapter = new WorldAdapter(getActivity(), islandArray);
        ListView listView = (ListView) rootView.findViewById(R.id.list_layout);
        listView.setAdapter(adapter);

        //onitem click behavior
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getActivity(), "clicked", Toast.LENGTH_SHORT).show();
            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }
}