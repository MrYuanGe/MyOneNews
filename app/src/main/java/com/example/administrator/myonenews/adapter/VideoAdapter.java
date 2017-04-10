package com.example.administrator.myonenews.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.myonenews.R;
import com.example.administrator.myonenews.ViewVideoTest;
import com.example.administrator.myonenews.entity.VideoMsg;

import java.util.List;

/**
 * Created by Administrator on 2017/1/1.
 */

public class VideoAdapter extends BaseAdapter {
    private Context mContext;
    private List<VideoMsg> arrayList;
    private View view;
    private TextView tv_name,tv_author;
    private ImageView image_video;
    public VideoAdapter(Context mContext,List<VideoMsg> arrayList){
        this.mContext=mContext;
        this.arrayList=arrayList;
    }
    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            view=View.inflate(mContext, R.layout.videolistviewitem,null);
            tv_name= (TextView) view.findViewById(R.id.textView_videoname);
            image_video= (ImageView) view.findViewById(R.id.imageView_video);
            tv_author= (TextView) view.findViewById(R.id.textView_author);

        }else{
            view=convertView;
        }
        tv_name.setText(arrayList.get(position).videoname.toString());
        tv_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, ViewVideoTest.class);
                intent.putExtra("tag",arrayList.get(position).video);
                mContext.startActivity(intent);
            }
        });
        Glide.with(mContext).load(arrayList.get(position).image).into(image_video);
        tv_author.setText(arrayList.get(position).author.toString());
        VideoMsg videoMsg=arrayList.get(position);
        if(videoMsg.isReading){
            tv_name.setTextColor(Color.GRAY);
            tv_author.setTextColor(Color.BLACK);
        }else{
            tv_name.setTextColor(Color.BLACK);
            tv_author.setTextColor(Color.BLACK);
        }

        return view;
    }

}
