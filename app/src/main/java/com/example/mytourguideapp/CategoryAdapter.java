package com.example.mytourguideapp;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.mytourguideapp.ui.CityFragment;
import com.example.mytourguideapp.ui.IslandFragment;
import com.example.mytourguideapp.ui.MountainFragment;
import com.example.mytourguideapp.ui.SeasFragment;


public class CategoryAdapter extends FragmentStateAdapter {

    //create category for fragment
    private String[] titles = new String[]{"Mountains", "Cities", "Islands", "seas"};

    public CategoryAdapter( FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0: return new MountainFragment();
            case 1: return new CityFragment();
            case 2: return new IslandFragment();
            case 3: return new SeasFragment();
        }
        return new MountainFragment();
    }

    //indicate size off fragment

    public int getItemCount() {
        return titles.length;
    }
}
