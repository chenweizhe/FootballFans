package com.example.strivezhe_chen.footballfans.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.strivezhe_chen.footballfans.Adapter.CourseAdapter;
import com.example.strivezhe_chen.footballfans.HttpUtils.CourseHttpUtils;
import com.example.strivezhe_chen.footballfans.Modal.CourseBean;
import com.example.strivezhe_chen.footballfans.R;

import java.util.List;

/**
 * Created by StriveZhe_Chen on 2017/3/1.
 *
 */

public class SecondFragment extends Fragment {
    private ListView listView;
    private List<CourseBean> beanList;
    private String key = "9656a816bba369e963019057a8775769";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second,container,false);
        listView = (ListView) view.findViewById(R.id.listview_course);
        System.out.println("第二个fragment");

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            CourseHttpUtils httpUtils = new CourseHttpUtils("128","2017",key);
            httpUtils.doHttpGet(getContext(),listView);
        }

    }
}
