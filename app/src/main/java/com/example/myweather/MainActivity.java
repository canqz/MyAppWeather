package com.example.myweather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.myweather.adapter.MainViewPagerAdapter;
import com.example.myweather.fragment.MainViewPagerFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ViewPager mainViewPager;
    ImageView addIv,moreIv;
    LinearLayout pointLl;
    MainViewPagerAdapter adapter;

    //数据源
    List<String> cityList;
    List<Fragment> fgList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件内容
        initView();
        cityList = new ArrayList<>();
        fgList = new ArrayList<>();
        if (cityList.size() == 0) {
            cityList.add("北京");
            cityList.add("上海");
        }
        //设置监听事件
        addIv.setOnClickListener(this);
        moreIv.setOnClickListener(this);
        //设置有多少个Fragment数据
        setViewPagerData();
        //设置ViewPager适配器
        adapter = new MainViewPagerAdapter(getSupportFragmentManager(),fgList);
        mainViewPager.setAdapter(adapter);
    }

    private void setViewPagerData() {
        for(int i = 0; i < cityList.size(); i++)
        {
            MainViewPagerFragment itemFg = new MainViewPagerFragment(this,cityList.get(i));
            fgList.add(itemFg);
        }
    }

    private void initView() {
        mainViewPager = findViewById(R.id.main_view_pager);
        addIv = findViewById(R.id.main_add_im);
        moreIv = findViewById(R.id.main_more_iv);
        pointLl = findViewById(R.id.main_point_ll);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_add_im:
                Toast.makeText(this, "you click add button", Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_more_iv:
                Toast.makeText(this, "you click more button", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
