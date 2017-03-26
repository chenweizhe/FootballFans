package com.example.strivezhe_chen.footballfans.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.strivezhe_chen.footballfans.Activity.NewsDetail_Activity;
import com.example.strivezhe_chen.footballfans.Holder.sportnewsViewHolder;
import com.example.strivezhe_chen.footballfans.Modal.Beants2;
import com.example.strivezhe_chen.footballfans.Modal.SportnewsBean;
import com.example.strivezhe_chen.footballfans.R;
import com.example.strivezhe_chen.footballfans.utils.ImageLoader;

import java.util.List;

/**
 * Created by StriveZhe_Chen on 2017/3/2.
 *
 */

public class sportnewsAdapter extends BaseAdapter implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener {
    private List<Beants2.ShowapiResBodyBean.PagebeanBean.ContentlistBean> mData;

    private LayoutInflater inflater;
    private ImageLoader imageLoader;
    private int start,end;


    public static String[] PicUrls;
    private boolean firstIn;
    public sportnewsAdapter(Context context, List<Beants2.ShowapiResBodyBean.PagebeanBean.ContentlistBean> mData, ListView sportListView) {

        inflater = LayoutInflater.from(context);
        this.mData = mData;

        imageLoader = new ImageLoader(sportListView);
        //注册listview的滚动监听事件
        PicUrls = new String[mData.size()];
        for (int i=0; i<mData.size();i++){
            PicUrls[i] = mData.get(i).getImageurls().get(0).getUrl();
        }

        firstIn = true;

        sportListView.setOnScrollListener(this);
        sportListView.setOnItemClickListener(this);
    }


    @Override
    public int getCount() {
        return  mData.size();
    }

    @Override
    public Beants2.ShowapiResBodyBean.PagebeanBean.ContentlistBean getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        sportnewsViewHolder viewHolder;
        if (convertView == null){
            viewHolder = new sportnewsViewHolder();
            convertView = inflater.inflate(R.layout.sportnews_item,null);
            viewHolder.ic_tag = (TextView) convertView.findViewById(R.id.ic_tag);
            viewHolder.sportnews_title = (TextView) convertView.findViewById(R.id.sportnews_title);
            viewHolder.sportnews_desc = (TextView) convertView.findViewById(R.id.sportnews_desc);
            viewHolder.sportnews_pic = (ImageView) convertView.findViewById(R.id.sportnews_pic);

            convertView.setTag(viewHolder);
        }else {
            viewHolder = (sportnewsViewHolder) convertView.getTag();
        }
        viewHolder.sportnews_pic.setImageResource(R.mipmap.newssquarepic2);
//        String url = mData.get(position).getImageurls();
        String url = mData.get(position).getImageurls().get(0).getUrl();
        viewHolder.sportnews_pic.setTag(url);
        imageLoader.showImageByAsyncTask(viewHolder.sportnews_pic,url);
        viewHolder.ic_tag.setText("新闻资讯");
        viewHolder.sportnews_title.setText(mData.get(position).getTitle());
        viewHolder.sportnews_desc.setText(mData.get(position).getDesc());
        return convertView;
    }


    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (scrollState == SCROLL_STATE_IDLE){
            //加载可见项
            imageLoader.loadImage(start,end);
        }else {
            //停止可见项
            imageLoader.cancelAllTasks();
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            start = firstVisibleItem;
            end = firstVisibleItem+visibleItemCount;

            //第一次显示调用
            if (firstIn && visibleItemCount >0){
                imageLoader.loadImage(0,totalItemCount);
                firstIn = false;
            }

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent  = new Intent(inflater.getContext(), NewsDetail_Activity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("bean",mData.get(position));
        intent.putExtras(bundle);
        inflater.getContext().startActivity(intent);
    }
}
