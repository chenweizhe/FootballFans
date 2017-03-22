package com.example.strivezhe_chen.footballfans.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;

import com.example.strivezhe_chen.footballfans.Adapter.sportnewsAdapter;
import com.example.strivezhe_chen.footballfans.BaseActivity;
import com.example.strivezhe_chen.footballfans.Modal.Beants2;
import com.example.strivezhe_chen.footballfans.R;
import com.example.strivezhe_chen.footballfans.utils.ListDataSave;

import java.util.List;

/**
 * Created by StriveZhe_Chen on 2017/3/6.
 *
 */

public class ShoucangActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListDataSave dataSave = new ListDataSave();
        List<Beants2.ShowapiResBodyBean.PagebeanBean.ContentlistBean> list = dataSave.getDataList(ShoucangActivity.this);
        setContentView(R.layout.activity_shoucang);
        ListView listView = (ListView) findViewById(R.id.shoucang_list);
        sportnewsAdapter adapter = new sportnewsAdapter(this,list,listView);
        listView.setAdapter(adapter);
    }
}
