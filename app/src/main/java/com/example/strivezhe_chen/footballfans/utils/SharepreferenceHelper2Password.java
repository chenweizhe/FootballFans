package com.example.strivezhe_chen.footballfans.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by StriveZhe_Chen on 2017/3/6.
 * 本地存储密码
 */

public class SharepreferenceHelper2Password {
    public static final String FILE_NAME = "Password";

    public SharepreferenceHelper2Password() {
    }

    public  void saveSharepreference(Context context, String password){
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        System.out.println("保存数据============="+password);
        System.out.println("sharepreference保存");
        editor.putString("password",password);
        editor.apply();
    }

    public String getSharereference(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);
        String password = sharedPreferences.getString("password","");
        return  password;
    }

}
