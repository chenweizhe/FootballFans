package com.example.strivezhe_chen.footballfans.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.strivezhe_chen.footballfans.BaseActivity;
import com.example.strivezhe_chen.footballfans.Modal.Beants2;
import com.example.strivezhe_chen.footballfans.R;
import com.example.strivezhe_chen.footballfans.utils.ListDataSave;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by StriveZhe_Chen on 2017/3/4.
 *
 */

public class NewsDetail_Activity extends BaseActivity {

    private WebView webView;
    private Toolbar toolbar;
    private Beants2.ShowapiResBodyBean.PagebeanBean.ContentlistBean bean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsdetail);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitle("新闻详情");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        bean  = (Beants2.ShowapiResBodyBean.PagebeanBean.ContentlistBean) intent.getSerializableExtra("bean");
        String link = bean.getLink();
        webView = (WebView) findViewById(R.id.detail_webview);
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);

        webView.loadUrl(link);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.newsdetail_memu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.shoucang){
             ListDataSave dataSave = new ListDataSave();
            List<Beants2.ShowapiResBodyBean.PagebeanBean.ContentlistBean> list;
            if (dataSave.getDataList(NewsDetail_Activity.this) == null){
                list = new ArrayList<Beants2.ShowapiResBodyBean.PagebeanBean.ContentlistBean>();
                list.add(bean);
            }else {
                list = dataSave.getDataList(NewsDetail_Activity.this);
                list.add(bean);
            }
            dataSave.setDataList(list,NewsDetail_Activity.this);
            Toast.makeText(NewsDetail_Activity.this,"已收藏",Toast.LENGTH_SHORT).show();
        }
        if (id == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
