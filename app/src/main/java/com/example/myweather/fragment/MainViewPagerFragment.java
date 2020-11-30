package com.example.myweather.fragment;

import android.content.ContentValues;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myweather.R;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class MainViewPagerFragment extends Fragment{
    Context context;
    String city;
    String url;
    String TAG = "MainViewPagerFragment";

    String url1 = "http://api.map.baidu.com/telematics/v3/weather?location=";
    String url2 = "&output=json&ak=FkPhtMBK0HTIQNh7gG4cNUttSTyr0nzo";

    public MainViewPagerFragment(Context context, String city)
    {
        this.context = context;
        this.city = city;
        url = url1 + city + url2;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = getLayoutInflater().inflate(R.layout.main_activity_fragment_pager,container,false);
        loadData();
        return view;
    }

    private void loadData() {
        //先有一个客户端
        OkHttpClient client = new OkHttpClient();

        //再有一个请求
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();

        //Call将客户端和请求这两者连到一起
        Call call = client.newCall(request);

        //Call入队列，异步实现
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.i(TAG,"错误信息"+e.toString());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Log.i(TAG,response.body().string());
            }
        });
    }



}
