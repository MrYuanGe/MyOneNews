package com.example.administrator.myonenews.utils;

/**
 * Created by Administrator on 2016/12/31.
 */

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;


import android.provider.MediaStore;
import android.util.Xml;

import com.example.administrator.myonenews.entity.VideoMsg;

public class ParseXMLVideo {

    public static List<VideoMsg> getXmlVideoData(InputStream in)
            throws Exception {

        List<VideoMsg> videoList  = null;
        VideoMsg videoMsg =null;
        //(1)获取xmlpullparser的解析器
        XmlPullParser parser = Xml.newPullParser();
        //(2)设置要解析的参数
        parser.setInput(in, "gbk");
        //(3)获取解析的事件类型
        int type = parser.getEventType();
        //(4)判断事件类型 只要不到文件的末尾就一直解析
        while(type!=XmlPullParser.END_DOCUMENT){


            //(5)判断一下具体的事件类型
            switch (type) {
                case XmlPullParser.START_TAG:    //解析开始标签

                    //判断一下具体解析到了哪个开始标签
                    if ("videomessage".equals(parser.getName())) {

                        videoList =new ArrayList<VideoMsg>();

                    }else if("item".equals(parser.getName())){
                        videoMsg =new VideoMsg();

                    }else if("id".equals(parser.getName())){
//					inews.title(parser.nextText());
                        videoMsg.id = parser.nextText();

                    }else if("videoname".equals(parser.getName())){
//					news.setDescription(parser.nextText());
                        videoMsg.videoname = parser.nextText();

                    }else if("author".equals(parser.getName())){
//					news.setImage(parser.nextText());
                        videoMsg.author = parser.nextText();

                    }else if("image".equals(parser.getName())){
                        videoMsg.image = parser.nextText();

                    }else if("video".equals(parser.getName())){
                        videoMsg.video= parser.nextText();

                    }

                    break;

                case XmlPullParser.END_TAG:  //结束标签

                    if("item".equals(parser.getName())){
                        //把news对象 添加到集合中

                       videoList.add(videoMsg);
                    }


                    break;
            }

            //不停的解析下一个事件
            type =  parser.next();
        }

       // System.out.println("newsList=="+newsLists.size());
        return videoList;
    }

}

