package com.example.administrator.myonenews.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2016/12/31.
 */

public class SharedPrefencesUtils {
    private static SharedPreferences sp;


    //	保存本地对象
    public static void saveData(Context context, String key, String value){
//		创建SP两种方法name--sp文件名   mode文件权限（private）
        if (sp == null) {
//			sp为空时。创建对象
            sp = context.getSharedPreferences("config.xml", Context.MODE_PRIVATE);
        }else{
            sp.edit().putString(key, value).commit();
        }

    }
    //
//	取出本地对象
    public static String getData(Context context, String key, String defValue){
//		创建SP两种方法name--sp文件名   mode文件权限（private）
        if (sp == null) {
//			sp为空时。创建对象
            sp = context.getSharedPreferences("config.xml", Context.MODE_PRIVATE);
        }


        return sp.getString(key, defValue);

    }
}
