package com.example.administrator.myonenews.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2016/12/29.
 */

public class HttpUtil {
    public static String getHttpUtil(String url){
        StringBuilder sb=new StringBuilder();
        try {
            URL urls=new URL(url);
            HttpURLConnection conn= (HttpURLConnection) urls.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(3000);
            InputStream in=conn.getInputStream();
            InputStreamReader isr=new InputStreamReader(in,"utf-8");
            BufferedReader br=new BufferedReader(isr);
            String data="";
            while((data=br.readLine())!=null){
                sb.append(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
