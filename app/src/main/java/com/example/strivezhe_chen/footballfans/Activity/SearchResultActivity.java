package com.example.strivezhe_chen.footballfans.Activity;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.example.strivezhe_chen.footballfans.HttpUtils.SportnewHttpUtils;
import com.example.strivezhe_chen.footballfans.R;

/**
 * Created by StriveZhe_Chen on 2017/3/5.
 *
 */

public class SearchResultActivity extends AppCompatActivity {
    private ListView listView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setHomeButtonEnabled(true);
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setTitle("             搜索结果");
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.search_swipe);
        listView = (ListView) findViewById(R.id.search_listview);
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())){
            String query = intent.getStringExtra(SearchManager.QUERY);
            SportnewHttpUtils httpUtils = new SportnewHttpUtils();
            httpUtils.doHttpGet(query,"4","1",SearchResultActivity.this,listView,swipeRefreshLayout);
        }
        swipeRefreshLayout.setEnabled(false);

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}
