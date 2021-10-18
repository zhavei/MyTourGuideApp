package com.example.mytourguideapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String namaGunung = getIntent().getStringExtra("namaGunung");
        int imageUrl = getIntent().getIntExtra("imageUrl", R.drawable.ic_launcher_background);
        String tinggiGunung = getIntent().getStringExtra("tinggiGunung");
        String deskripsiGunung = getIntent().getStringExtra("deskripsiGunung");



    }
}