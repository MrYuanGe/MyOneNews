package com.example.administrator.myonenews.fragment;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.myonenews.CaijingXiangping;
import com.example.administrator.myonenews.R;
import com.example.administrator.myonenews.adapter.CaijingAdapter;
import com.example.administrator.myonenews.entity.CaiJingResult;
import com.example.administrator.myonenews.entity.CaijinNews;
import com.example.administrator.myonenews.net.MyAsyncTask;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by Administrator on 2016/12/29.
 */

public class FragmentOne extends Fragment implements MyAsyncTask.callMyBack {
    private View view;
    private ListView lv;
    private CaijinNews cjn=new CaijinNews();
    private CaijingAdapter adapter;
    private MyAsyncTask async;
    private CaiJingResult cr;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    view=View.inflate(getActivity(),R.layout.functionone,null);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lv= (ListView) view.findViewById(R.id.caijing_listview);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        });

        String url="http://v.juhe.cn/toutiao/index";
        String parmas="type=caijing&key=0f56fe0ee4c4317939a55a8697918736";
        String urlparmas=url+"?=&"+parmas;
        async=new MyAsyncTask(FragmentOne.this);
        async.execute(urlparmas);
    }

    @Override
    public void getResult(String result) {
        getGson(result);
    }
    public void getGson(String result){
        Gson gson=new Gson();
        cjn=gson.fromJson(result,CaijinNews.class);
        adapter=new CaijingAdapter(getActivity(),cjn.getResult());
        lv.setAdapter(adapter);

    }

}
