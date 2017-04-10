package com.example.administrator.myonenews.fragment;



import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.administrator.myonenews.CaijingXiangping;
import com.example.administrator.myonenews.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2016/12/26.
 */

public class FragmentTwo extends Fragment {
    private View view;
    private static WebView webView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=View.inflate(getActivity(),R.layout.fragmenttwo,null);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        webView= (WebView) view.findViewById(R.id.fragmenttwo_webview);
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
                return true;
            }

            // 页面开始加载，进度条显示


            // 页面加载完成，进度条消失
            @Override
            public void onPageFinished(WebView view, String url) {
                // TODO Auto-generated method stub
                super.onPageFinished(view, url);


            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {

                super.onPageStarted(view, url, favicon);


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
                getActivity().setTitle(title);
            }

        });
        webView.loadUrl("http://www.zhibo8.cc/");
    }
    public static boolean clickBack(int keycode,KeyEvent event) {
        if (keycode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack();
        }
        return true;
        }
    }
