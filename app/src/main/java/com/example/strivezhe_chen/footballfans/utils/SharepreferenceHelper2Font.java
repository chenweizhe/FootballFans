package com.example.strivezhe_chen.footballfans.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by StriveZhe_Chen on 2017/3/6.
 *
 */

public class SharepreferenceHelper2Font {
    public static final String FILE_NAME = "fontsize";

    public SharepreferenceHelper2Font() {
    }

    public  void saveSharepreference(Context context, float num){
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        System.out.println("保存数据============="+num);
        System.out.println("sharepreference保存");
        editor.putFloat("fontsize",num);
        editor.apply();
    }

    public float getSharereference(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);
        float num = sharedPreferences.getFloat("fontsize", 1);
        return  num;
    }

}
