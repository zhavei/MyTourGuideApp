package com.example.mytourguideapp;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;


public class CategoryAdapter extends FragmentStateAdapter {

    private String[] titles = new String[]{"Numbers", "Colors", "Family", "Phrases"};

    public CategoryAdapter( FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0: return new NumbersFragment();
            case 1: return new ColorsFragment();
            case 2: return new FamiliyFragment();
            case 3: return new PhrasesFragment();
        }
        return new NumbersFragment();
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
