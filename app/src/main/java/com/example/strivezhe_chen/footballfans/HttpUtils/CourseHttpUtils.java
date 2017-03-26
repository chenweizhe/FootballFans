package com.example.strivezhe_chen.footballfans.HttpUtils;

import android.content.Context;
import android.util.Log;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.example.strivezhe_chen.footballfans.Adapter.CourseAdapter;
import com.example.strivezhe_chen.footballfans.Modal.CourseBean;
import com.example.strivezhe_chen.footballfans.utils.JsonResult;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by StriveZhe_Chen on 2017/3/3.
 * 赛程的网络请求
 */

public class CourseHttpUtils {
    private String league_id,season_id,key;
    private String resultcode = null;
    public CourseHttpUtils(String league_id, String season_id, String key) {
        this.league_id = league_id;
        this.season_id = season_id;
        this.key = key;
        System.out.println("构造方法");
    }

    //get请求
    public void doHttpGet(final Context context, final ListView listView) {

        System.out.println("网络请求");
        String COURSE_URL = "http://v.juhe.cn/football/query_schedule.php";
        RequestParams reqparams = new RequestParams(COURSE_URL);
        reqparams.addBodyParameter("league_id",league_id);
        reqparams.addBodyParameter("season_id",season_id);
        reqparams.addBodyParameter("key",key);

        x.http().get(reqparams, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                //返回获取的数据

                List<CourseBean> beanList = new ArrayList<CourseBean>();
                JSONObject jsonObject = JSON.parseObject(result);
                CourseBean bean;
                JSONObject jsonbean;
                System.out.println(jsonObject.getString("reason"));
//                jsonObject = jsonObject.getJSONObject("result");
//                jsonObject = jsonObject.getJSONObject("views");
//                JSONArray array = jsonObject.getJSONArray("saicheng1");
                JSONArray array = jsonObject.getJSONArray("result");
                for (int i=0;i<array.size();i++) {
                    jsonbean = (JSONObject) array.get(i);
                    if (jsonbean.getInteger("home_score") == null){
                        bean = new CourseBean(jsonbean.getInteger("league_id"),jsonbean.getString("home_name"),jsonbean.getString("away_name"),
                                jsonbean.getInteger("match_date_cn"),0,0,jsonbean.getInteger("game_status"),jsonbean.getString("stadium_name"));

                    }else {
                        bean = new CourseBean(jsonbean.getInteger("league_id"),jsonbean.getString("home_name"),jsonbean.getString("away_name"),jsonbean.getInteger("match_date_cn"),jsonbean.getInteger("home_score"),jsonbean.getInteger("away_score"),jsonbean.getInteger("game_status"),jsonbean.getString("stadium_name"));

                    }
                    beanList.add(bean);

                }
//                 beanList = array.toJavaList(CourseBean.class);
//                beanList = JSON.parseArray(result,CourseBean.class);
                System.out.println("zoudaozheli");
                CourseAdapter adapter = new CourseAdapter(context,beanList);
                listView.setAdapter(adapter);
                System.out.println(beanList.get(0).getAway_name());


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
