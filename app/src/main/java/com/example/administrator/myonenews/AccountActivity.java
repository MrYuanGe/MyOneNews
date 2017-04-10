package com.example.administrator.myonenews;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.myonenews.entity.User;
import com.example.administrator.myonenews.net.MyAsyncTask;
import com.google.gson.Gson;

import java.util.HashMap;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;

/**
 * Created by Administrator on 2016/12/28.
 */

public class AccountActivity extends AppCompatActivity implements MyAsyncTask.callMyBack,View.OnClickListener {
    private EditText ed_phone,ed_pwd;
    private Button but_Account,but_Test;
    private User user;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        setContentView(R.layout.accountactivity);
        ed_phone= (EditText) findViewById(R.id.editText_phone);
        ed_pwd= (EditText) findViewById(R.id.editText_pwd);
        but_Account= (Button) findViewById(R.id.button_ac);
        but_Test= (Button) findViewById(R.id.button_test);

        but_Account.setOnClickListener(this);
        but_Test.setOnClickListener(this);




    }

    @Override
    public void getResult(String result) {
        getGson(result);

    }
    public void getGson(String result){
            if (result.equals("注册成功")) {
                Intent intent = new Intent(AccountActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }else{
                Toast.makeText(AccountActivity.this,result,Toast.LENGTH_SHORT).show();
            }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button_ac:
                String telephone=ed_phone.getText().toString().trim();
                String password=ed_pwd.getText().toString().trim();
                String url="http://192.168.13.128:8088/SuccessDataSource/RegistServlet?=&name="+telephone+"&password="+password;
                MyAsyncTask asyncTask=new MyAsyncTask(this);
                asyncTask.execute(url);

                break;
            case R.id.button_test:
                SMSSDK.initSDK(this, "1a207e592897b", "cdeca3e9b15af57ff136dcc66a485c14");
                //打开注册页面
                RegisterPage registerPage = new RegisterPage();
                registerPage.setRegisterCallback(new EventHandler() {
                    public void afterEvent(int event, int result, Object data) {
                        // 解析注册结果
                        if (result == SMSSDK.RESULT_COMPLETE) {
                            @SuppressWarnings("unchecked")
                            HashMap<String,Object> phoneMap = (HashMap<String, Object>) data;
                            String country = (String) phoneMap.get("country");
                            String phone = (String) phoneMap.get("phone");
                            // 提交用户信息（此方法可以不调用）
                            //registerUser(country, phone);
                        }
                    }
                });
                registerPage.show(this);

                break;
        }
    }
}
