package com.example.myweather.fragment;

import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myweather.R;

public class MainViewPagerFragment extends Fragment{
    Context context;
    String city;
    public MainViewPagerFragment(Context context, String city)
    {
        this.context = context;
        this.city = city;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = getLayoutInflater().inflate(R.layout.main_activity_fragment_pager,container,false);
        return view;
    }
}
