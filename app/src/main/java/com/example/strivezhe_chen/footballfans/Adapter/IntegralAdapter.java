package com.example.strivezhe_chen.footballfans.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.strivezhe_chen.footballfans.Holder.IntegralViewHolder;
import com.example.strivezhe_chen.footballfans.Modal.integralBean;
import com.example.strivezhe_chen.footballfans.R;

import java.util.List;

/**
 * Created by StriveZhe_Chen on 2017/3/5.
 *
 */

public class IntegralAdapter extends BaseAdapter{
    private List<integralBean> mData;
    private LayoutInflater inflater;

    public IntegralAdapter(Context context, List<integralBean> mData) {
        this.mData = mData;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        IntegralViewHolder viewHolder;
        if (convertView == null){
            viewHolder = new IntegralViewHolder();
            convertView = inflater.inflate(R.layout.integral_item,null);
            viewHolder.rank = (TextView) convertView.findViewById(R.id.rank);
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            viewHolder.round = (TextView) convertView.findViewById(R.id.round);
            viewHolder.score = (TextView) convertView.findViewById(R.id.score);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (IntegralViewHolder) convertView.getTag();
        }

        viewHolder.rank.setText(mData.get(position).getRank_index());
        viewHolder.name.setText(mData.get(position).getName_zh());
        viewHolder.round.setText(mData.get(position).getPlayed());
        viewHolder.score.setText(mData.get(position).getScore());
        return convertView;
    }
}
