package com.example.strivezhe_chen.footballfans.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.strivezhe_chen.footballfans.HttpUtils.integralHttputils;
import com.example.strivezhe_chen.footballfans.R;

/**
 * Created by StriveZhe_Chen on 2017/3/1.
 *
 */

public class ThirdFragment extends Fragment {
    private String key = "9656a816bba369e963019057a8775769";
    private String league_id = null;
    private ListView listView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third,container,false);
        listView = (ListView) view.findViewById(R.id.scoreboard_listview);
        league_id = "128";

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){
            integralHttputils httputils = new integralHttputils(league_id,key);
            httputils.doHttpGet(getContext(),listView);
        }

    }
}
