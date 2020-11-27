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

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainViewPagerFragment extends Fragment{
    Context context;
    String city;
    String url;

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
        new MyNetJob().execute();
    }


    class MyNetJob extends AsyncTask<String,Void,String>{

        //这里做网络耗时的操作
        @Override
        protected String doInBackground(String... strings) {
            String result = null;
            if (url == null) {
                Toast.makeText(context, "输入的城市为空", Toast.LENGTH_SHORT).show();
//                Log.i("LWT","HELLO---1");
            }else{
                try {
//                    Log.i("LWT","HELLO---2");
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url(url)
                            .build();
                    Response response = client.newCall(request).execute();
                    result = response.body().toString();
//                    Log.i("LWT","HELLO---3");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return result;
        }

        //这里返回数据得到result
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            Log.i("LWT",result);
        }
    }
}
