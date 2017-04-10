package com.example.administrator.myonenews;



import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.myonenews.fragment.FragmentNba;
import com.example.administrator.myonenews.fragment.FragmentOne;
import com.example.administrator.myonenews.fragment.FragmentThree;
import com.example.administrator.myonenews.fragment.FragmentTwo;
import com.example.administrator.myonenews.fragment.FunctionOne;
import com.example.administrator.myonenews.fragment.FunctionTwo;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2016/12/24.
 */

public class OnedianActivity extends FragmentActivity implements View.OnClickListener{
    private ImageView img_home,img_discover,img_person;
    private TextView shouye,faxian,wo;
    private FragmentOne fo;
    private FragmentTwo ft;
    private FragmentThree fr;
    private FunctionOne functionOne;
    private FunctionTwo functionTwo;
    private FragmentNba fn;
    private LinearLayout layout_main,layout_honz;
    private HorizontalScrollView hsv;
    private TextView caijing,video,tiyu;
    private EditText et_shuru;
    private int id;
    private int currentIndex;
  //  private List<Fragment> fragmentList;
  //  private ViewPager viewPager;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        if (getSupportActionBar() != null){
//            getSupportActionBar().hide();
//        }
        setContentView(R.layout.onedianactivity);
//        Intent intent=getIntent();
//        intent.getIntExtra("tag",-1);
//        if(id>0){
//            if(id==1){
//                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_qiehuan,fo).commit();
//            }
//        }
        layout_main= (LinearLayout) findViewById(R.id.linearlayout_main);
        layout_honz= (LinearLayout) findViewById(R.id.linearlayout_hornzition);
        img_home= (ImageView) findViewById(R.id.imageView_home);
        shouye= (TextView) findViewById(R.id.textView_shouye);
        img_discover= (ImageView) findViewById(R.id.imageView_discover);
        faxian= (TextView) findViewById(R.id.textView_faxian);
        img_person= (ImageView) findViewById(R.id.imageView_personal);
        wo= (TextView)findViewById(R.id.textView_wo);
        hsv= (HorizontalScrollView)findViewById(R.id.horizontalscroll_view);
        caijing= (TextView)findViewById(R.id.textview_caijing);
        video= (TextView)findViewById(R.id.textview_video);
        tiyu= (TextView) findViewById(R.id.textview_tiyu);
        et_shuru= (EditText) findViewById(R.id.editText_shuru);
//        viewPager= (ViewPager) findViewById(R.id.vp_content);
//        fragmentList=new ArrayList<Fragment>();
//        fragmentList.add(new FunctionOne());
//        fragmentList.add(new FunctionTwo());
//        fragmentList.add(new FragmentNba());
//        viewPager.setAdapter(new MenuApaper(getSupportFragmentManager()));
        caijing.setOnClickListener(this);
        video.setOnClickListener(this);
        tiyu.setOnClickListener(this);

        img_home.setOnClickListener(this);
        shouye.setOnClickListener(this);
        img_discover.setOnClickListener(this);
        faxian.setOnClickListener(this);
        img_person.setOnClickListener(this);
        wo.setOnClickListener(this);
        fo=new FragmentOne();
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_qiehuan,fo).commit();
      //  viewPager.setCurrentItem(0);
        layout_honz.setVisibility(View.VISIBLE);
        et_shuru.setHint("大家都在搜：人民币7乌龙");
        caijing.setTextColor(Color.BLUE);
        video.setTextColor(Color.GRAY);
        tiyu.setTextColor(Color.GRAY);
        img_home.setImageResource(R.drawable.tab_home_h);
        shouye.setTextColor(Color.BLUE);


    }

    @Override
    public void onClick(View v) {
    switch (v.getId()){
        case R.id.imageView_home:
            layout_main.setVisibility(View.VISIBLE);
            layout_honz.setVisibility(View.VISIBLE);
            fo=new FragmentOne();
            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_qiehuan,fo).commit();
            et_shuru.setHint("大家都在搜：人民币7乌龙");
            img_home.setImageResource(R.drawable.tab_home_h);
            shouye.setTextColor(Color.BLUE);
            img_discover.setImageResource(R.drawable.tab_discover_nt);
            faxian.setTextColor(Color.GRAY);
            img_person.setImageResource(R.drawable.tab_personal_nt);
            wo.setTextColor(Color.GRAY);
            break;
        case R.id.imageView_discover:
            layout_main.setVisibility(View.VISIBLE);
            layout_honz.setVisibility(View.GONE);
            ft=new FragmentTwo();
            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_qiehuan,ft).commit();
            et_shuru.setHint("搜索你感兴趣的");
            img_home.setImageResource(R.drawable.tab_home_nt);
            shouye.setTextColor(Color.GRAY);
            img_discover.setImageResource(R.drawable.tab_discover_h);
            faxian.setTextColor(Color.BLUE);
            img_person.setImageResource(R.drawable.tab_personal_nt);
            wo.setTextColor(Color.GRAY);
            break;
        case R.id.imageView_personal:
            layout_main.setVisibility(View.GONE);
            layout_honz.setVisibility(View.GONE);
            fr=new FragmentThree();
            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_qiehuan,fr).commit();
            img_home.setImageResource(R.drawable.tab_home_nt);
            shouye.setTextColor(Color.GRAY);
            img_discover.setImageResource(R.drawable.tab_discover_nt);
            faxian.setTextColor(Color.GRAY);
            img_person.setImageResource(R.drawable.tab_personal_h);
            wo.setTextColor(Color.BLUE);
            break;
        case R.id.textview_caijing:
            fo=new FragmentOne();
            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_qiehuan,fo).commit();
            //viewPager.setCurrentItem(0);
            et_shuru.setHint("大家都在搜：人民币7乌龙");
            caijing.setTextColor(Color.BLUE);
            video.setTextColor(Color.GRAY);
            tiyu.setTextColor(Color.GRAY);
            break;
        case R.id.textview_video:
            functionTwo=new FunctionTwo();
            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_qiehuan,functionTwo).commit();
            //viewPager.setCurrentItem(1);
            et_shuru.setHint("大家都在搜:凤凰视频");
            video.setTextColor(Color.BLUE);
            caijing.setTextColor(Color.GRAY);
            tiyu.setTextColor(Color.GRAY);
            break;
        case R.id.textview_tiyu:
            fn=new FragmentNba();
            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_qiehuan,fn).commit();
          //  viewPager.setCurrentItem(2);
            caijing.setTextColor(Color.GRAY);
            video.setTextColor(Color.GRAY);
            tiyu.setTextColor(Color.BLUE);
            et_shuru.setHint("搜索你感兴趣的");
            break;
        default:
                break;
    }
     }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /**
         *  判断requestCode, resultCode 来确定要执行的代码
         */
        if(requestCode==1 && resultCode == 2){
            // 在这设置选中你要显示的fragment
            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_qiehuan,fo).commit();

        }
    }
//    class MenuApaper extends FragmentPagerAdapter {
//
//        public MenuApaper(FragmentManager fm) {
//            super(fm);
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            // tyy 将fm_list中添加到了adapter中
//
//            return fragmentList.get(position);
//        }
//
//        @Override
//        public int getCount() {
//            // TODO Auto-generated method stub
//            return fragmentList.size();
//        }
//    }
@Override
public boolean onKeyDown(int keyCode, KeyEvent event) {
    // TODO Auto-generated method stub
    if(currentIndex==1){
        FragmentTwo.clickBack(keyCode, event);
        return true;
    }
    return super.onKeyDown(keyCode, event);
}

}
