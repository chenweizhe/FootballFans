package com.example.strivezhe_chen.footballfans;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.strivezhe_chen.footballfans.Activity.SettingActivity;
import com.example.strivezhe_chen.footballfans.Adapter.myFragmentPagerAdapter;
import com.example.strivezhe_chen.footballfans.Fragment.FirstFragment;
import com.example.strivezhe_chen.footballfans.Fragment.ForthFragment;
import com.example.strivezhe_chen.footballfans.Fragment.SecondFragment;
import com.example.strivezhe_chen.footballfans.Fragment.ThirdFragment;


import java.util.ArrayList;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private ViewPager myviewPager;
    private Button btn_first,btn_second,btn_third,btn_four;
    //作为指示标签的按钮
    private ImageView cursor;
    //标志指示标签的横坐标
    float cursorX;
    //所有按钮的宽度的数组
    private int[] widthArgs;
    //所有标题按钮的数组
    private Button[] btnArgs;
    //fragment集合
    private ArrayList<Fragment> fragments;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化布局
        initView();
        //将fragment传到Adapter
        fragments = new ArrayList<Fragment>();
        fragments = new ArrayList<Fragment>();
        fragments.add(new FirstFragment());
        fragments.add(new SecondFragment());
        fragments.add(new ThirdFragment());
        fragments.add(new ForthFragment());
        myFragmentPagerAdapter fragmentPagerAdapter = new myFragmentPagerAdapter(getSupportFragmentManager(),fragments);
        //将装载了数据的adapter设置给viewpager
        myviewPager.setAdapter(fragmentPagerAdapter);
        myviewPager.setOffscreenPageLimit(3);
        //实现viewpager监听事件
        myviewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //每次滑动首先重置所有按钮的颜色
                resetButtonColor();
                //将滑动到的当前按钮颜色设置为红色
                btnArgs[position].setTextColor(Color.WHITE);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void initView() {
        myviewPager = (ViewPager) findViewById(R.id.myviewpager);
        btn_first = (Button)findViewById(R.id.sport_news);
        btn_second = (Button)findViewById(R.id.course);
        btn_third = (Button)findViewById(R.id.scoreboard);
        btn_four = (Button)findViewById(R.id.collection);

        //初始化按钮数组
        btnArgs = new Button[]{btn_first,btn_second,btn_third,btn_four};
        //指示标签设置为红色
        cursor = (ImageView)this.findViewById(R.id.cursor_btn);
        cursor.setBackgroundColor(Color.WHITE);

        btn_first.setOnClickListener(this);
        btn_second.setOnClickListener(this);
        btn_third.setOnClickListener(this);
        btn_four.setOnClickListener(this);


        //先重置所有按钮颜色
        resetButtonColor();
        //再将第一个按钮字体设置为红色，表示默认选中第一个
        btn_first.setTextColor(Color.WHITE);

    }

    @Override
    public void onClick(View v) {
        //为上部的按钮注册监听事件,使对应每一个子页面
        switch (v.getId()){
            case R.id.sport_news:
                myviewPager.setCurrentItem(0);
                break;
            case R.id.course:
                myviewPager.setCurrentItem(1);
                break;
            case R.id.scoreboard:
                myviewPager.setCurrentItem(2);
                break;
            case R.id.collection:
                myviewPager.setCurrentItem(3);
                break;
        }
    }

    /***********颜色重置***************/
    private void resetButtonColor() {
        btn_first.setTextColor(Color.BLACK);
        btn_second.setTextColor(Color.BLACK);
        btn_third.setTextColor(Color.BLACK);
        btn_four.setTextColor(Color.BLACK);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.serch_share_menu,menu);
//        MenuItem searchItem = menu.findItem(R.id.search);
//        SearchManager searchManager = (SearchManager)getSystemService(Context.SEARCH_SERVICE);

        SearchManager searchManager = (SearchManager)getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView)menu.findItem(R.id.search).getActionView();
        searchView.setQueryHint("新闻搜索,例:恒大");
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.setting:
                Intent intent = new Intent(this, SettingActivity.class);
                startActivity(intent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
