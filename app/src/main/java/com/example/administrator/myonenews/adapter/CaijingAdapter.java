package com.example.administrator.myonenews.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.myonenews.CaijingXiangping;
import com.example.administrator.myonenews.R;
import com.example.administrator.myonenews.entity.CaiJingResult;

/**
 * Created by Administrator on 2016/12/29.
 */

public class CaijingAdapter extends BaseAdapter{
    private Context mContext;
    private CaiJingResult cr=new CaiJingResult();
    private View view;
    private TextView tv_lager,tv_small;
    private ImageView img_item1,img_item2;
    public CaijingAdapter(Context mContext,CaiJingResult cr){
        this.mContext=mContext;
        this.cr=cr;
    }
    @Override
    public int getCount() {
        return cr.getData().size();
    }

    @Override
    public Object getItem(int position) {
        return cr.getData().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            view=View.inflate(mContext,R.layout.caijingadapteritem,null);
            tv_lager= (TextView) view.findViewById(R.id.textView_lageritem);
            tv_lager.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(mContext, CaijingXiangping.class);
                    intent.putExtra("tag",cr.getData().get(position).getUrl());
                    ((Activity)mContext).startActivityForResult(intent,1);
                }
            });
            img_item1= (ImageView) view.findViewById(R.id.imageView_item1);
            img_item2= (ImageView) view.findViewById(R.id.imageView_item2);
            tv_small= (TextView) view.findViewById(R.id.textView_smallitem);
        }else{
            view=convertView;
        }
        tv_lager.setText(cr.getData().get(position).getTitle());
        Glide.with(mContext).load(cr.getData().get(position).getThumbnail_pic_s()).into(img_item1);
        Glide.with(mContext).load(cr.getData().get(position).getThumbnail_pic_s03()).into(img_item2);
        tv_small.setText(cr.getData().get(position).getAuthor_name());
        return view;
    }
}
