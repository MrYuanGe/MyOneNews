package com.example.administrator.myonenews;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/12/27.
 */

public class LoginAccount extends AppCompatActivity{
    private ImageView img;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        setContentView(R.layout.loginaccount);
        img= (ImageView) findViewById(R.id.img_loginaccount);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent=new Intent(LoginAccount.this,AccountActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
