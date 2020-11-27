package com.example.myweather.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class MainViewPagerAdapter extends FragmentPagerAdapter {

    List<Fragment> fgDataList;

    public MainViewPagerAdapter(@NonNull FragmentManager fm,List<Fragment> fgDataList) {
        super(fm);
        this.fgDataList = fgDataList;
    }


    @Override
    public int getCount() {
        return fgDataList == null ? 0 : fgDataList.size();
    }

    @Override
    public Fragment getItem(int position) {
        return fgDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
