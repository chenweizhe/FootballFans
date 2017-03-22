package com.example.strivezhe_chen.footballfans.Modal;

import java.util.List;

/**
 * Created by StriveZhe_Chen on 2017/3/7.
 *
 */

public class beants {
    /**
     * pubDate : 2017-03-07 08:45:33
     * havePic : true
     * title :
     * channelName :
     * imageurls :
     * desc :
     * source :
     * channelId :
     * link :
     */

    private String pubDate;
    private boolean havePic;
    private String title;
    private String channelName;
    private String desc;
    private String source;
    private String channelId;
    private String link;
    private List<ImageurlsBean> imageurls;

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public boolean isHavePic() {
        return havePic;
    }

    public void setHavePic(boolean havePic) {
        this.havePic = havePic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<ImageurlsBean> getImageurls() {
        return imageurls;
    }

    public void setImageurls(List<ImageurlsBean> imageurls) {
        this.imageurls = imageurls;
    }

    public static class ImageurlsBean {
        /**
         * height : 0
         * width : 0
         * url : http://n.sinaimg.cn/sports/transform/20170307/JQ71-fycapec2554648.jpg
         */

        private int height;
        private int width;
        private String url;

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
