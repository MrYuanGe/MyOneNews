package com.example.administrator.myonenews.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.myonenews.LoginAccount;
import com.example.administrator.myonenews.OnedianActivity;
import com.example.administrator.myonenews.R;
import com.example.administrator.myonenews.adapter.LoginViewItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/12/26.
 */

public class FragmentThree extends Fragment {
    private View view;
    private LoginViewItem lvi;
    private ListView lv;
    private TextView tv;
    private List<HashMap<String,Object>> arraylist=new ArrayList<HashMap<String,Object>>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=View.inflate(getActivity(),R.layout.fragmentthree,null);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lv= (ListView) view.findViewById(R.id.login_listitem);
        tv= (TextView) view.findViewById(R.id.textview_login);
        getItem();
        lvi = new LoginViewItem(getActivity(), arraylist);
        lv.setAdapter(lvi);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent=new Intent(getActivity(), LoginAccount.class);
            startActivity(intent);
            }
        });
    }
    public void getItem(){
        HashMap<String,Object> map=new HashMap<String,Object>();
        map.put("image",R.drawable.personal_icon_collection);
        map.put("title","我的收藏");
        arraylist.add(map);
        map=new HashMap<String,Object>();
        map.put("image",R.drawable.personal_icon_message);
        map.put("title","我的消息");
        arraylist.add(map);
        map=new HashMap<String,Object>();
        map.put("image",R.drawable.personal_icon_push);
        map.put("title","新闻推送");
        arraylist.add(map);
        map=new HashMap<String,Object>();
        map.put("image",R.drawable.personal_icon_history);
        map.put("title","最近阅读");
        arraylist.add(map);
        map=new HashMap<String,Object>();
        map.put("image",R.drawable.personal_icon_activity);
        map.put("title","最新活动");
        arraylist.add(map);
        map.put("image",R.drawable.personal_icon_app);
        map.put("title","应用推荐");
        arraylist.add(map);
    }
}
