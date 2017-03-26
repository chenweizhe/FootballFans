package com.example.strivezhe_chen.footballfans.Activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
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
        final ListDataSave dataSave = new ListDataSave();
        final List<Beants2.ShowapiResBodyBean.PagebeanBean.ContentlistBean> list = dataSave.getDataList(ShoucangActivity.this);
        setContentView(R.layout.activity_shoucang);
        ListView listView = (ListView) findViewById(R.id.shoucang_list);
        final sportnewsAdapter adapter = new sportnewsAdapter(this,list,listView);
        listView.setAdapter(adapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                new AlertDialog.Builder(ShoucangActivity.this).setTitle("Delete").setNegativeButton("cancel",null).setPositiveButton("sure", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        list.remove(position);
                        adapter.notifyDataSetChanged();
                        dataSave.RemoveSharePreferenceData(ShoucangActivity.this);
                        dataSave.setDataList(list,ShoucangActivity.this);
                    }
                }).show();
                return false;
            }
        });
    }


}
