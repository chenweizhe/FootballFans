package com.example.strivezhe_chen.footballfans;

import android.app.Activity;
import android.app.Application;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by StriveZhe_Chen on 2017/3/3.
 * xutils导入
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化xutils；
        x.Ext.init(this);
        //设置debug模式
        x.Ext.setDebug(false);
    }
}
