package com.example.mytourguideapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    CategoryAdapter categoryAdapter;
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    private String[] titles = new String[]{"Numbers", "Colors", "Family", "Phrases"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        viewPager2 = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);
        categoryAdapter = new CategoryAdapter(this);

        viewPager2.setAdapter(categoryAdapter);
        new TabLayoutMediator(tabLayout, viewPager2,((tab, position) -> tab.setText(titles[position]))).attach();

    }

}