package com.example.strivezhe_chen.footballfans.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.strivezhe_chen.footballfans.Adapter.sportnewsAdapter;
import com.example.strivezhe_chen.footballfans.HttpUtils.SportnewHttpUtils;
import com.example.strivezhe_chen.footballfans.Modal.Beants2;
import com.example.strivezhe_chen.footballfans.Modal.SportnewsBean;
import com.example.strivezhe_chen.footballfans.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by StriveZhe_Chen on 2017/3/1.
 *
 */

public class FirstFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private ListView listView;
    private SwipeRefreshLayout swipeRefreshLayout;
    SportnewHttpUtils httpUtils = new SportnewHttpUtils();
    int page = 2;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first,container,false);
        listView = (ListView) view.findViewById(R.id.sportnews_list);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refresh);
        //为SwipeRefreshLayout设置刷新时的颜色变化，最多可以设置4种
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        httpUtils.doHttpGet("足球","5","1",getContext(),listView,swipeRefreshLayout);

        swipeRefreshLayout.setOnRefreshListener(this);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onRefresh() {
        if(page < 4){
			String pagenum = String.valueOf(page);
           System.out.println("下拉刷新"+pagenum);
           httpUtils.doHttpGet("足球","2",pagenum,getContext(),listView,swipeRefreshLayout);
           page++;
		}else{
            Toast.makeText(getContext(),"已加载到最新内容",Toast.LENGTH_SHORT).show();
            if (swipeRefreshLayout.isRefreshing()){
                swipeRefreshLayout.setRefreshing(false);
            }
		}
        
    }

}
