package com.example.mytourguideapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView moveDetail = findViewById(R.id.detail_tv);
        moveDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDetailActivity();
            }
        });
    }

    private void goToDetailActivity() {
        Intent intent = new Intent(this.getApplicationContext(), DetailActivity.class);
        startActivity(intent);
    }
}