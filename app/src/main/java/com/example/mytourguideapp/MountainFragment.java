package com.example.mytourguideapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MountainFragment extends Fragment {

    private final int LOCATION_SIZE = 10;
    private final int LOCATION_TYPE = 1;

    public MountainFragment() {
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

        String name, imageName, address;
        Drawable image;
        int resourceId, imageId;

        final ArrayList<WorldDataModel> mountainArrays = new ArrayList<WorldDataModel>();
        for (int n = 1; n <= LOCATION_SIZE; n++) {
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
            mountainArrays.add(new WorldDataModel(name, address, image));
        }

        // using simple recycle view
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.word_list_activity);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        //on list item click
        RecycleViewWorldAdapter adapter = new RecycleViewWorldAdapter(mountainArrays, new RecycleViewWorldAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(WorldDataModel item, int position) {
                Log.i("MountainFragment", "MountainFragment.getView() — get item number " + position);

                WorldDataModel worldDataModel = item;
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                intent.putExtra("category", LOCATION_TYPE);
                intent.putExtra("location",position + 1);
                getActivity().startActivity(intent);
            }
        });

        recyclerView.setAdapter(adapter);

        // Inflate the layout for this fragment
        return rootView;
    }
}