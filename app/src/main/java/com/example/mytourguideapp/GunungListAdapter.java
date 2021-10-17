package com.example.mytourguideapp;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GunungListAdapter extends RecyclerView.Adapter<GunungListAdapter.Holder> {


    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public GunungListAdapter.Holder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull GunungListAdapter.Holder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class Holder extends RecyclerView.ViewHolder {

        public Holder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
        }
    }

}
