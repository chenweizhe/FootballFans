package com.example.strivezhe_chen.footballfans.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.strivezhe_chen.footballfans.Holder.CourseViewHolder;
import com.example.strivezhe_chen.footballfans.Modal.CourseBean;
import com.example.strivezhe_chen.footballfans.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by StriveZhe_Chen on 2017/3/2.
 *
 */

public class CourseAdapter extends BaseAdapter {
    private List<CourseBean> courseList;
    private LayoutInflater inflater;

    public CourseAdapter(Context context, List<CourseBean> courseList) {
        inflater = LayoutInflater.from(context);
        this.courseList = courseList;
    }

    @Override
    public int getCount() {
        return courseList.size();
    }

    @Override
    public Object getItem(int position) {
        return courseList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CourseViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new CourseViewHolder();
            convertView = inflater.inflate(R.layout.course_item,null);
            viewHolder.item_game_date = (TextView) convertView.findViewById(R.id.item_game_date);
            viewHolder.item_game_league = (TextView) convertView.findViewById(R.id.item_game_league);
            viewHolder.stadium_name = (TextView) convertView.findViewById(R.id.stadium_name);
            viewHolder.item_game_name = (TextView) convertView.findViewById(R.id.item_game_name);
            viewHolder.home_score = (TextView) convertView.findViewById(R.id.home_score);
            viewHolder.game_status = (TextView) convertView.findViewById(R.id.game_status);
            viewHolder.away_score = (TextView) convertView.findViewById(R.id.away_score);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (CourseViewHolder) convertView.getTag();
        }
        viewHolder.item_game_date.setText(longToString(courseList.get(position).getMatch_date_cn()));
        viewHolder.item_game_league.setText(matchType(courseList.get(position).getLeague_id()));
        viewHolder.stadium_name.setText(courseList.get(position).getStadium_name());
        viewHolder.item_game_name.setText(courseList.get(position).getHome_name()+"                  "+courseList.get(position).getAway_name());
        viewHolder.home_score.setText(Integer.toString(courseList.get(position).getHome_score()));
        viewHolder.game_status.setText(getGame_status(courseList.get(position).getGame_status()));
        viewHolder.away_score.setText(Integer.toString(courseList.get(position).getAway_score()));
        return convertView;
    }

    /**比赛状态	未开始=0，比赛推迟=1，比赛延期=2，比赛取消=3，弃赛=4, 比赛中断=5， 比赛进行中=32，比赛 结束 =30**/
    private String getGame_status(int num) {
        String str = null;
        switch (num){
            case 0:
                str = "未开始";
                break;
            case 1:
                str = "比赛推迟";
                break;
            case 2:
                str = "延期";
                break;
            case 3:
                str = "取消";
                break;
            case 4:
                str = "弃赛";
                break;
            case 5:
                str = "中断";
                break;
            case 32:
                str = "进行中";
                break;
            case 30:
                str = "已结束";
                break;
        }
        return str;
    }

    //long类型时间转换成string类型
    private String longToString(long time){
        Date dt = new Date(time);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        return simpleDateFormat.format(dt);
    }

    /**	联赛ID	英超=2，西甲=3，意甲=4，德甲=5，法甲=6，欧冠=9，中超=128，
     * 英足总杯=110，英联杯=111，国王杯(西)=112，德国杯=113，意大利杯=114，法国杯=115**/
    private String matchType(int num){
        String str = null;
        switch (num){
            case 2:
                str = "英超";
                break;
            case 5:
                str = "德甲";
                break;
            case 128:
                str = "中超";
                break;
        }
        return str;
    }
}
