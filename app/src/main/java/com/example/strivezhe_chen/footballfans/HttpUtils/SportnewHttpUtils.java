package com.example.strivezhe_chen.footballfans.HttpUtils;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ListView;

import com.example.strivezhe_chen.footballfans.Adapter.sportnewsAdapter;
import com.example.strivezhe_chen.footballfans.Modal.Beants2;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by StriveZhe_Chen on 2017/3/4.
 *
 */

public class SportnewHttpUtils{

    List<Beants2.ShowapiResBodyBean.PagebeanBean.ContentlistBean>  lists = new ArrayList<Beants2.ShowapiResBodyBean.PagebeanBean.ContentlistBean>();
    public SportnewHttpUtils() {
        System.out.println("构造方法");
    }

    public void doHttpGet(String title,String maxResult,String page,final Context context,final ListView listView,final SwipeRefreshLayout swipeRefreshLayout){

        swipeRefreshLayout.setRefreshing(true);
        System.out.println("网络请求");
        String NEWS_URL  = "http://route.showapi.com/109-35";
        //设置请求的参数
        RequestParams requestParams = new RequestParams(NEWS_URL);
        String showapi_appid = "33027";
        requestParams.addBodyParameter("showapi_appid", showapi_appid);
        String showapi_sign = "3600708933564bddbce50987a759d850";
        requestParams.addBodyParameter("showapi_sign", showapi_sign);
        requestParams.addBodyParameter("title",title);
        requestParams.addBodyParameter("page",page);
        requestParams.addBodyParameter("maxResult",maxResult);
        requestParams.addBodyParameter("needContent","0");
        requestParams.addBodyParameter("needAllList","0");
        requestParams.addBodyParameter("needHtml","0");

        x.http().get(requestParams, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {

                Gson gson = new Gson();
                Beants2 bean = gson.fromJson(result,Beants2.class);
//                List<Beants2.ShowapiResBodyBean.PagebeanBean.ContentlistBean>  lists = bean.getShowapi_res_body().getPagebean().getContentlist();
                lists.addAll(0,bean.getShowapi_res_body().getPagebean().getContentlist());
                System.out.println("sportnews----");
                    sportnewsAdapter adapter = new sportnewsAdapter(context,lists,listView);
                    listView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                   swipeRefreshLayout.setRefreshing(false);
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
