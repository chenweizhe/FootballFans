package com.example.strivezhe_chen.footballfans.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.strivezhe_chen.footballfans.Modal.Beants2;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by StriveZhe_Chen on 2017/3/6.
 * 保存list数据
 */

public class ListDataSave {
    public static final String FILE_NAME = "Shoucang";
    public ListDataSave() { }

    /**
     * 保存List
     * @param datalist
     */
    public void setDataList(List<Beants2.ShowapiResBodyBean.PagebeanBean.ContentlistBean> datalist,Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (null == datalist || datalist.size() <= 0)
            return;

        Gson gson = new Gson();
        //转换成json数据，再保存
        String strJson = gson.toJson(datalist);
        editor.clear();
        editor.putString("shoucang", strJson);
        editor.apply();

    }

    /**
     * 获取List
     * @return
     */
    public List<Beants2.ShowapiResBodyBean.PagebeanBean.ContentlistBean> getDataList(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);
        List<Beants2.ShowapiResBodyBean.PagebeanBean.ContentlistBean> datalist=new ArrayList<Beants2.ShowapiResBodyBean.PagebeanBean.ContentlistBean>();
        String strJson = preferences.getString("shoucang", "");
        if ("".equals(strJson)) {
            return datalist;
        }
        Gson gson = new Gson();
        datalist = gson.fromJson(strJson, new TypeToken<List<Beants2.ShowapiResBodyBean.PagebeanBean.ContentlistBean>>() {
        }.getType());
        return datalist;

    }
}
