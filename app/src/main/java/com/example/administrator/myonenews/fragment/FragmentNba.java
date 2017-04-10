package com.example.administrator.myonenews.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.administrator.myonenews.R;
import com.example.administrator.myonenews.adapter.NbaAdapter;
import com.example.administrator.myonenews.entity.NbaResult;
import com.example.administrator.myonenews.entity.NbaShaiShi;
import com.example.administrator.myonenews.net.MyAsyncTask;
import com.google.gson.Gson;

/**
 * Created by Administrator on 2016/12/30.
 */

public class FragmentNba extends Fragment implements MyAsyncTask.callMyBack {
    private View view;
    private ListView lv;
    private NbaShaiShi nss;
    private NbaAdapter nbaAdapter;
    private MyAsyncTask asyncTask;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=View.inflate(getActivity(),R.layout.fragmentnba,null);
        return view;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lv= (ListView) view.findViewById(R.id.listview_nba);
        String url="http://v.juhe.cn/toutiao/index";
        String parmas="type=tiyu&key=0f56fe0ee4c4317939a55a8697918736";
        String urlparmas=url+"?=&"+parmas;
        asyncTask=new MyAsyncTask(FragmentNba.this);
        asyncTask.execute(urlparmas);
    }

    public void getGson(String result){
        Gson gson=new Gson();
       nss=gson.fromJson(result,NbaShaiShi.class);
       nbaAdapter=new NbaAdapter(getActivity(),nss.getResult());
       lv.setAdapter(nbaAdapter);
    }

    @Override
    public void getResult(String result) {
        getGson(result);
    }
}
