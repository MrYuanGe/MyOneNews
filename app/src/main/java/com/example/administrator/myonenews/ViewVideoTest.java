package com.example.administrator.myonenews;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by Administrator on 2017/1/1.
 */

public class ViewVideoTest extends AppCompatActivity{
    private VideoView videoView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
       if (getSupportActionBar() != null){
           getSupportActionBar().hide();
       }
        setContentView(R.layout.videoviewtest);
        videoView= (VideoView) findViewById(R.id.videoView);
        Intent intent=getIntent();
        String url=intent.getStringExtra("tag");
        Uri uri= Uri.parse(url);
        //获得一个多媒体的控制器
        videoView.setMediaController(new MediaController(this));
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();
    }
}
