package com.example.strivezhe_chen.footballfans.Modal;

/**
 * Created by StriveZhe_Chen on 2017/3/5.
 * 积分榜的数据模型
 */

public class integralBean {

    private String rank_index;
    private  String name_zh;
    private String 	played;
    private String 	score;

    public integralBean(String rank_index, String name_zh, String played, String score) {
        this.rank_index = rank_index;
        this.name_zh = name_zh;
        this.played = played;
        this.score = score;
    }

    public String getRank_index() {
        return rank_index;
    }

    public void setRank_index(String rank_index) {
        this.rank_index = rank_index;
    }

    public String getName_zh() {
        return name_zh;
    }

    public void setName_zh(String name_zh) {
        this.name_zh = name_zh;
    }

    public String getPlayed() {
        return played;
    }

    public void setPlayed(String played) {
        this.played = played;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
