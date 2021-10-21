package com.example.mytourguideapp;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;


public class CategoryAdapter extends FragmentStateAdapter {

    private String[] titles = new String[]{"Mountains", "Cities", "Family", "Phrases"};

    public CategoryAdapter( FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0: return new MountainFragment();
            case 1: return new CityFragment();
            case 2: return new FamiliyFragment();
            case 3: return new PhrasesFragment();
        }
        return new MountainFragment();
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
