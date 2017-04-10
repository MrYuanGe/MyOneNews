package com.example.administrator.myonenews.net;

import android.os.AsyncTask;

import com.example.administrator.myonenews.utils.HttpUtil;

/**
 * Created by Administrator on 2016/12/29.
 */

public class MyAsyncTask extends AsyncTask<String,Integer,String>{
    callMyBack call;
    public interface callMyBack{
        public void getResult(String result);
    }
    public MyAsyncTask(callMyBack call){
        this.call=call;
    }
    @Override
    protected String doInBackground(String... params) {
        String data="";
        data= HttpUtil.getHttpUtil(params[0]);
        return data;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        call.getResult(s);
        super.onPostExecute(s);
    }
}
