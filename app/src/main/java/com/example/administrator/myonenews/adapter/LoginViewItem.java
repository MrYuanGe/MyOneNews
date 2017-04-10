package com.example.administrator.myonenews.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myonenews.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/12/27.
 */

public class LoginViewItem extends BaseAdapter{
    private Context mContext;
    private List<HashMap<String,Object>> arraylist=new ArrayList<HashMap<String,Object>>();

    public LoginViewItem(Context mContext, List<HashMap<String, Object>> arraylist) {
        this.mContext = mContext;
        this.arraylist = arraylist;
    }

    @Override
    public int getCount() {
        return arraylist.size();
    }

    @Override
    public Object getItem(int position) {
        return arraylist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if(convertView==null){
            convertView=View.inflate(mContext, R.layout.dengluitem,null);
            holder=new ViewHolder();
           holder.img= (ImageView) convertView.findViewById(R.id.imageView_login);
            holder.tv= (TextView) convertView.findViewById(R.id.login_text);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        holder.img.setImageResource((Integer) arraylist.get(position).get("image"));
        holder.tv.setText(arraylist.get(position).get("title").toString());
        return convertView;
    }

    class ViewHolder{
        ImageView img;
        TextView tv;
    }
}
