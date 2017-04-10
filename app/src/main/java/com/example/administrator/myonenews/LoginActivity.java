package com.example.administrator.myonenews;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.myonenews.entity.User;
import com.example.administrator.myonenews.fragment.FragmentOne;
import com.example.administrator.myonenews.net.MyAsyncTask;
import com.google.gson.Gson;

/**
 * Created by Administrator on 2016/12/28.
 */

public class LoginActivity extends AppCompatActivity implements MyAsyncTask.callMyBack {
    private EditText ed_login,ed_pwd;
    private Button but_login;
    private String telephone;
    private String password;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginactivity);
        ed_login= (EditText) findViewById(R.id.logineditText_phone);
        ed_pwd= (EditText) findViewById(R.id.logineditText_pwd);
        but_login= (Button) findViewById(R.id.button_login);
        but_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                telephone=ed_login.getText().toString().trim();
                 password=ed_pwd.getText().toString().trim();
                String url="http://192.168.13.128:8088/SuccessDataSource/LoginServlet?=&"+"name="+telephone+"&password="+password;
                Log.e("Tag=======","url======="+url);
                MyAsyncTask async=new MyAsyncTask(LoginActivity.this);
                async.execute(url);
            }
        });
    }

    @Override
    public void getResult(String result) {
        getGson(result);
    }
    public void getGson(String result){
       if(result.equals("登录成功")){
          // Intent intent=new Intent(LoginActivity.this,FragmentOne.class);
//           intent.putExtra("tag",1);
//           startActivity(intent);
              finish();
            Toast.makeText(LoginActivity.this,result,Toast.LENGTH_SHORT).show();
       }else{
           Toast.makeText(LoginActivity.this,result,Toast.LENGTH_SHORT).show();
       }
    }
}
