package com.example.administrator.myonenews.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.myonenews.R;
import com.example.administrator.myonenews.adapter.VideoAdapter;
import com.example.administrator.myonenews.entity.VideoMsg;
import com.example.administrator.myonenews.utils.ParseXMLVideo;
import com.example.administrator.myonenews.utils.SharedPrefencesUtils;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/28.
 */

public class FunctionTwo extends Fragment {
    private View view;
    private ListView lv;
    private VideoAdapter videoAdapter;
    private List<VideoMsg> arrayList;
    private Context mContext;
    private ArrayList<String> idList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=View.inflate(getActivity(),R.layout.functiontwo,null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //初始化上下文对象
        mContext=getActivity();
        lv= (ListView) view.findViewById(R.id.listview_video);
        initData();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(!arrayList.get(position).isReading){
                    arrayList.get(position).isReading=true;
                   // 数据发生改变，notifyDataSetChanged();刷新界面
                    videoAdapter.notifyDataSetChanged();
                    //	1.那就需要把状态保存到本地  SharedPreferences对象.
					//2.可能点击很多条，保存每条Id, 并且用 特殊字符分割 ，保存本地
                    String id1 = SharedPrefencesUtils.getData(mContext, "IDS",
                            "");
                    SharedPrefencesUtils.saveData(mContext, "IDS",
                            id1+"#"+ arrayList.get(position).id);

                }

            }
        });
    }
    //联网获取数据
    private void initData(){

//		4.当你重新进来界面，进行初始化initData时， 就先把你上次退出时保存到本地中
//		 * 的Id全部取出来

        String data = SharedPrefencesUtils.getData(mContext, "IDS", "");
//		按特殊符号作为分隔符
        String[] split = data.split("#", -1);
        idList=new ArrayList<String>();
        idList.clear();
//		遍历Id
        for (int i = 0; i < split.length; i++) {
            idList.add(split[i]);
        }


//		NetWorkOnMainThreadException 说明联网的耗时操作放在了主线程中,要开启子线程
//		创建子线程
        new Thread(new Runnable() {

            private VideoMsg videoMsg;
            @Override
            public void run() {
                // TODO Auto-generated method stub

                try {
//					一定要改成本机IP
                    String path = "http://192.168.12.30:8088/video1/videomessage.xml";

//				联网
                    URL url = new URL(path);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                    conn.setRequestMethod("GET");
                    conn.setConnectTimeout(5000);
//					联网结果返回码
                    int code = conn.getResponseCode();
                    if (code == 200) {
//						联网成功
                        InputStream in = conn.getInputStream();
//						把流解析为集合--NewsInfo对象
                        arrayList=  ParseXMLVideo.getXmlVideoData(in);
//
//                        5.一定要记得解析Id的节点
//                        本地的Id都是上次推出前已经点击过的条目，
//   					 * 6.判断如果本地Id包含网络端获取的Id,该Id标记为已读状态
//   					 * 7.initData()中运行是从上到下 ，一定在解析完数据 List<NewsInfo>
//   					 * id做标记，一定在在runonUiThread（）方法之前改变

                        for (int i = 0; i < arrayList.size(); i++) {

                            videoMsg = arrayList.get(i);
                            //判断该videomsg的id是否在idList集合当中
                            if (idList.contains(videoMsg.id)) {
                                videoMsg.isReading = true;
                            }else{
                                videoMsg.isReading= false;
                            }

                        }

                   //     System.out.println("newsList====="+newsList.size());
//						子线程中不能更新UI runOnUiThread对handler的封装,
//						Activity当中调用该方法 ---extends Context
                        getActivity().runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                videoAdapter= new VideoAdapter(getActivity(),arrayList);
                                lv.setAdapter(videoAdapter);
                            }
                        });


                    }else{
                    }

                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }).start();



    }
}
