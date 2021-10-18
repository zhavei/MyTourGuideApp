package com.example.mytourguideapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GunungListAdapter extends RecyclerView.Adapter<GunungListAdapter.Holder> {

    private final List<DataModelGunung> namaGunungList;

    public GunungListAdapter(List<DataModelGunung> gunungList) {
        namaGunungList = gunungList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view, parent, false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(GunungListAdapter.Holder holder, int position) {
        final DataModelGunung dataModelGunung = namaGunungList.get(position);
        holder.tvMontainName.setText(dataModelGunung.getNamaGunung());
        holder.tvMontainTinggi.setText(dataModelGunung.getTinggiGungung());
        holder.ivMontainImage.setImageResource(dataModelGunung.getImageUrl());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToDetailActivity(view, dataModelGunung.getNamaGunung(), dataModelGunung.getImageUrl(),
                        dataModelGunung.getTinggiGungung(), dataModelGunung.getDeskripsiGunung());
            }
        });

    }

    private void goToDetailActivity(View view, String namaGunung, int imageUrl, String tinggiGungung, String deskripsiGunung) {
        Intent intent = new Intent(view.getContext(), DetailActivity.class);
        intent.putExtra("namaGunung", namaGunung);
        intent.putExtra("imageUrl", imageUrl);
        intent.putExtra("tinggiGunung", tinggiGungung);
        intent.putExtra("deskripsiGunung", deskripsiGunung);

        view.getContext().startActivity(intent);
    }


    @Override
    public int getItemCount() {
        return namaGunungList.size();
    }


    class Holder extends RecyclerView.ViewHolder {

        ImageView ivMontainImage;
        TextView tvMontainName;
        TextView tvMontainTinggi;

        public Holder(View itemView) {
            super(itemView);
            ivMontainImage = itemView.findViewById(R.id.iv_mountain_image);
            tvMontainName = itemView.findViewById(R.id.tv_nama_gunung);
            tvMontainTinggi = itemView.findViewById(R.id.tv_tinggi_gunung);
        }
    }

}
