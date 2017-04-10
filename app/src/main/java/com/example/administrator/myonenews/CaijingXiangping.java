package com.example.administrator.myonenews;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2016/12/29.
 */

public class CaijingXiangping extends AppCompatActivity {
    private WebView webView;
    private ProgressDialog pDialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caijingxiangqing);
        webView= (WebView)findViewById(R.id.caijing_webview);
        webView.requestFocus();
        //设置一些属性让页面可以方大缩小，支持js等功能
        WebSettings ws=webView.getSettings();
        //创建缩放zoom
        ws.setBuiltInZoomControls(true);
        ws.setDisplayZoomControls(true);
        ws.setSupportZoom(true);
        ws.setJavaScriptEnabled(true);

        webView.clearHistory();//清除历史
        webView.clearCache(true);//清除缓存
        getWebView();

    }
    public void getWebView(){
        webView.setWebViewClient(new WebViewClient() {

            // 是否重写url路径，是不是用webView自带的浏览器，true用
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                webView.loadUrl(url);
                return false;
            }

            // 页面开始加载，进度条显示


            // 页面加载完成，进度条消失
            @Override
            public void onPageFinished(WebView view, String url) {
                // TODO Auto-generated method stub
                super.onPageFinished(view, url);
                if (pDialog != null && pDialog.isShowing()) {
                    pDialog.dismiss();
                    pDialog = null;
                }

            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {

                super.onPageStarted(view, url, favicon);

                if (pDialog == null) {
                    pDialog = ProgressDialog.show(CaijingXiangping.this, "网络加载",
                            "加载中...");
                    Timer timer=new Timer();
                    TimerTask tt=new TimerTask() {
                        @Override
                        public void run() {
                        pDialog.dismiss();
                        }
                    };
                    timer.schedule(tt,3000);
                } else {
                    if(!pDialog.isShowing())
                        pDialog.show();
                }

            }

        });
        // 第三个辅助类, WebChromeClient 处理网站图标，对话框，标题，网页加载进度等

        webView.setWebChromeClient(new WebChromeClient() {

            // 网页加载进度
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                // TODO Auto-generated method stub
                super.onProgressChanged(view, newProgress);


            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                // TODO Auto-generated method stub
                super.onReceivedTitle(view, title);
                CaijingXiangping.this.setTitle(title);
            }

        });
        Intent intent=getIntent();
        String url=intent.getStringExtra("tag");
        webView.loadUrl(url);
        //webView.loadUrl("http://mini.eastday.com/mobile/161229134419358.html?qid=juheshuju");
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode== KeyEvent.KEYCODE_BACK){
            if(webView.canGoBack()){
                webView.goBack();

            }else{
                CaijingXiangping.this.setResult(2);
                CaijingXiangping.this.finish();
            }

        }
        return true;
    }
}
