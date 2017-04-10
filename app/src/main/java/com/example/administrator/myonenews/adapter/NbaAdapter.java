package com.example.administrator.myonenews.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.myonenews.R;
import com.example.administrator.myonenews.entity.NbaResult;

/**
 * Created by Administrator on 2016/12/30.
 */

public class NbaAdapter extends BaseAdapter {
    private NbaResult nbaResult;
    private Context mContext;
    private View view;
    private TextView tv_lager,tv_small;
    private ImageView img_item1,img_item2;
    public NbaAdapter(Context mContext,NbaResult nbaResult){
        this.mContext=mContext;
        this.nbaResult=nbaResult;
    }
    @Override
    public int getCount() {
        return nbaResult.getData().size();
    }

    @Override
    public Object getItem(int position) {
        return nbaResult.getData().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            view=View.inflate(mContext, R.layout.caijingadapteritem,null);
            tv_lager= (TextView) view.findViewById(R.id.textView_lageritem);
            img_item1= (ImageView) view.findViewById(R.id.imageView_item1);
            img_item2= (ImageView) view.findViewById(R.id.imageView_item2);
            tv_small= (TextView) view.findViewById(R.id.textView_smallitem);
        }else{
            view=convertView;
        }
        tv_lager.setText(nbaResult.getData().get(position).getTitle());
        Glide.with(mContext).load(nbaResult.getData().get(position).getThumbnail_pic_s()).into(img_item1);
        Glide.with(mContext).load(nbaResult.getData().get(position).getThumbnail_pic_s03()).into(img_item2);
        tv_small.setText(nbaResult.getData().get(position).getAuthor_name());
        return view;
    }

}
