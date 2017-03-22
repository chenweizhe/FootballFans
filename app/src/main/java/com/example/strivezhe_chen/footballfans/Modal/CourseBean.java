package com.example.strivezhe_chen.footballfans.Modal;

/**
 * Created by StriveZhe_Chen on 2017/3/2.
 *
 */

public class CourseBean {
    private int league_id;
    private String home_name;
    private String away_name;
    private long match_date_cn;
    private int home_score;
    private int away_score;
    private int game_status;
    private String stadium_name;

    public CourseBean() {
    }

    public CourseBean(int league_id, String home_name, String away_name, long match_date_cn,
                      int home_score, int away_score, int game_status, String stadium_name) {
        this.league_id = league_id;
        this.home_name = home_name;
        this.away_name = away_name;
        this.match_date_cn = match_date_cn;
        this.home_score = home_score;
        this.away_score = away_score;
        this.game_status = game_status;
        this.stadium_name = stadium_name;
    }


    public int getLeague_id() {
        return league_id;
    }

    public void setLeague_id(int league_id) {
        this.league_id = league_id;
    }

    public String getHome_name() {
        return home_name;
    }

    public void setHome_name(String home_name) {
        this.home_name = home_name;
    }

    public String getAway_name() {
        return away_name;
    }

    public void setAway_name(String away_name) {
        this.away_name = away_name;
    }

    public long getMatch_date_cn() {
        return match_date_cn;
    }

    public void setMatch_date_cn(long match_date_cn) {
        this.match_date_cn = match_date_cn;
    }

    public int getHome_score() {
        return home_score;
    }

    public void setHome_score(int home_score) {
        this.home_score = home_score;
    }

    public int getAway_score() {
        return away_score;
    }

    public void setAway_score(int away_score) {
        this.away_score = away_score;
    }

    public int getGame_status() {
        return game_status;
    }

    public void setGame_status(int game_status) {
        this.game_status = game_status;
    }

    public String getStadium_name() {
        return stadium_name;
    }

    public void setStadium_name(String stadium_name) {
        this.stadium_name = stadium_name;
    }

}
