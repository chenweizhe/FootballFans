package com.example.strivezhe_chen.footballfans;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;

import com.example.strivezhe_chen.footballfans.utils.SharepreferenceHelper2Font;

/**
 * Created by StriveZhe_Chen on 2017/3/5.
 * 设置全局字体 这个很麻烦可以加钱吗。。。。。
 * @全局字体
 */

public class BaseActivity extends AppCompatActivity{



    @Override
    public Resources getResources() {

        SharepreferenceHelper2Font sh = new SharepreferenceHelper2Font();
        float num = sh.getSharereference(this);
        Resources res = super.getResources();
        Configuration config = res.getConfiguration();
        config.fontScale = num;//1 为正常大小
        res.updateConfiguration(config,res.getDisplayMetrics());
        return  res;

    }
}
