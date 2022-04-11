package com.example.mytourguideapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytourguideapp.model.WorldDataModel;

import java.util.ArrayList;

public class RecycleViewWorldAdapter extends RecyclerView.Adapter<RecycleViewWorldAdapter.MyViewHolder> {

    private final ArrayList<WorldDataModel> worldDataModelArrayList;
    private final OnItemClickListener listener;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewLocationName, textViewPlacesName;
        public ImageView imageOnCard;
        public LinearLayout linearLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            textViewLocationName = (TextView) itemView.findViewById(R.id.location_name);
            textViewPlacesName = (TextView) itemView.findViewById(R.id.places_name);
            imageOnCard = (ImageView) itemView.findViewById(R.id.image_on_cardview);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearlayout_on_rv);

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(worldDataModelArrayList.get(getAdapterPosition()), getAdapterPosition());
                }
            });
        }
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewWorldAdapter.MyViewHolder holder, int position) {
        WorldDataModel worldDataModel = worldDataModelArrayList.get(position);
        holder.textViewLocationName.setText(worldDataModel.getAddress());
        holder.textViewPlacesName.setText(worldDataModel.getName());
        holder.imageOnCard.setImageDrawable(worldDataModel.getImageThumbnail());

    }

    @Override
    public int getItemCount() {
        return worldDataModelArrayList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(WorldDataModel item, int position);
    }

    public RecycleViewWorldAdapter(ArrayList<WorldDataModel> worldDataModelArrayList, OnItemClickListener listener) {
        this.worldDataModelArrayList = worldDataModelArrayList;
        this.listener = listener;
    }

}