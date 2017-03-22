package com.example.strivezhe_chen.footballfans.HttpUtils;

import android.content.Context;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.strivezhe_chen.footballfans.Adapter.CourseAdapter;
import com.example.strivezhe_chen.footballfans.Adapter.IntegralAdapter;
import com.example.strivezhe_chen.footballfans.Modal.CourseBean;
import com.example.strivezhe_chen.footballfans.Modal.integralBean;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by StriveZhe_Chen on 2017/3/5.
 *
 */

public class integralHttputils {
    private String league_id,key;

    public integralHttputils(String league_id, String key) {
        this.league_id = league_id;
        this.key = key;
    }

    //get请求
    public void doHttpGet(final Context context, final ListView listView) {

        System.out.println("网络请求");
        String COURSE_URL = "http://v.juhe.cn/football/scorerank.php";
        RequestParams reqparams = new RequestParams(COURSE_URL);
        reqparams.addBodyParameter("league_id",league_id);
        reqparams.addBodyParameter("key",key);

        x.http().get(reqparams, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                //返回获取的数据

                List<integralBean> beanList = new ArrayList<integralBean>();
                JSONObject jsonObject = JSON.parseObject(result);
                integralBean bean;
                JSONObject jsonbean;
                System.out.println(jsonObject.getString("reason"));
                JSONArray array = jsonObject.getJSONArray("result");
                for (int i=0;i<array.size();i++) {
                    jsonbean = (JSONObject) array.get(i);
                    bean = new integralBean(jsonbean.getString("rank_index"),jsonbean.getString("name_zh"),jsonbean.getString("played"),jsonbean.getString("score"));
                    beanList.add(bean);
                }
                System.out.println("zoudaozheli");

                IntegralAdapter adapter = new IntegralAdapter(context,beanList);
                listView.setAdapter(adapter);

            }
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
            }
        });
    }
}
