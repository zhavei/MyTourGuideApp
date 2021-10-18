package com.example.mytourguideapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ColorsFragment extends Fragment {

    public ColorsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.word_list_activity, container, false);

        final ArrayList<WordDataModel> numbersArray = new ArrayList<WordDataModel>();

        numbersArray.add(new WordDataModel("lutti", "satu", R.drawable.ic_launcher_background));
        numbersArray.add(new WordDataModel("otiiko", "dua", R.drawable.ic_launcher_background));
        numbersArray.add(new WordDataModel("tolookosu", "tiga", R.drawable.ic_launcher_background));
        numbersArray.add(new WordDataModel("oyyisa", "empat", R.drawable.ic_launcher_background));
        numbersArray.add(new WordDataModel("massokka", "lima", R.drawable.ic_launcher_background));
        numbersArray.add(new WordDataModel("temmokka", "enam", R.drawable.ic_launcher_background));
        numbersArray.add(new WordDataModel("kenekaku", "tujuh", R.drawable.ic_launcher_background));
        numbersArray.add(new WordDataModel("kawinta", "delapan", R.drawable.ic_launcher_background));
        numbersArray.add(new WordDataModel("wo’e", "sembilan", R.drawable.ic_launcher_background));
        numbersArray.add(new WordDataModel("na’aacha", "sepuluh", R.drawable.ic_launcher_background));

        // using simple recycle view
        WordAdapater stringArrayAdapter = new WordAdapater(getActivity(), numbersArray, R.color.white);
        ListView listView = (ListView) rootView.findViewById(R.id.word_list_activity);
        listView.setAdapter(stringArrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                WordDataModel wordDataModel = numbersArray.get(position);

                Toast.makeText(getActivity(), " finish play", Toast.LENGTH_SHORT).show();
            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }
}