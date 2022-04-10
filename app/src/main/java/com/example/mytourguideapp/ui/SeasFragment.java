package com.example.mytourguideapp.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mytourguideapp.DetailsActivity;
import com.example.mytourguideapp.R;
import com.example.mytourguideapp.RecycleViewWorldAdapter;
import com.example.mytourguideapp.model.WorldDataModel;

import java.util.ArrayList;

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
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.word_list_activity);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        //add click behavior
        RecycleViewWorldAdapter adapter = new RecycleViewWorldAdapter(seasArrays, new RecycleViewWorldAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(WorldDataModel item, int position) {
                WorldDataModel worldDataModel = item;
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                intent.putExtra("category", LOCATION_TYPE);
                intent.putExtra("location", position + 1);
                getActivity().startActivity(intent);
            }
        });

        //set adapter
        recyclerView.setAdapter(adapter);
        
        // Inflate the layout for this fragment
        return rootView;
    }
}