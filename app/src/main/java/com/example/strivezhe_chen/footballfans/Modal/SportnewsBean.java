package com.example.strivezhe_chen.footballfans.Modal;

import java.io.Serializable;

/**
 * Created by StriveZhe_Chen on 2017/3/2.
 *
 */

public class SportnewsBean implements Serializable {
    private String title;
    private String link;
    private String desc;
    private String  imageurls;

    public SportnewsBean() {}

    public SportnewsBean(String title, String link, String desc, String imageurls) {
        this.title = title;
        this.link = link;
        this.desc = desc;
        this.imageurls = imageurls;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImageurls() {
        return imageurls;
    }

    public void setImageurls(String imageurls) {
        this.imageurls = imageurls;
    }

}
