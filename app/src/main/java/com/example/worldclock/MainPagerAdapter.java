package com.example.worldclock;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MainPagerAdapter extends FragmentPagerAdapter {
    private final String[] countries = {
            "Asia/Tokyo",
            "Asia/Calcutta",
            "US/Alaska"};

    public MainPagerAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @Override
    public int getCount() {
        return countries.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return getCountry(position);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return MainFragment.newInstance(getCountry(position));
    }

    private String getCountry(int position) {
        return countries[existsCountry(position) ? position : 0];
    }

    private boolean existsCountry(int position) {
        return countries.length > position;
    }
}
