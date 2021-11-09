package com.example.mytourguideapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
        for (int i = 1; i <= LOCATION_SIZE; i++) {
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
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.word_list_activity);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        //onitem click behavior
        RecycleViewWorldAdapter adapter = new RecycleViewWorldAdapter(islandArray, new RecycleViewWorldAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(WorldDataModel item, int position) {
                WorldDataModel worldDataModel = item;
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                intent.putExtra("category", LOCATION_TYPE);
                intent.putExtra("location", position + 1);
                getActivity().startActivity(intent);
            }
        });

        recyclerView.setAdapter(adapter);

        // Inflate the layout for this fragment
        return rootView;
    }
}