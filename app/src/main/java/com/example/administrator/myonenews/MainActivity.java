package com.example.administrator.myonenews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.AlphaAnimation;

import com.example.administrator.myonenews.utils.UpdateManager;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private UpdateManager mUpdateManager;
    public UpdateManager um;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_main);
        //这里来检测版本是否需要更新
        mUpdateManager = new UpdateManager(this);
        mUpdateManager.checkUpdateInfo();
        um=new UpdateManager(this);
        AlphaAnimation animation=new AlphaAnimation(0.2f,1.0f);
        animation.setDuration(3000);

        //动画作用域
        findViewById(R.id.activity_main).startAnimation(animation);

    }

}
