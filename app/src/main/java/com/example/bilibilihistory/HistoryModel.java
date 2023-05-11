package com.example.bilibilihistory;

public class HistoryModel {

    private Integer id;
    private String videoTitle;
    private String bv;
    private String cover;
    private String introduction;
    private String upId;

    public HistoryModel(Integer id, String videoTitle, String bv, String cover, String introduction, String upId) {
        this.id = id;
        this.videoTitle = videoTitle;
        this.bv = bv;
        this.cover = cover;
        this.introduction = introduction;
        this.upId = upId;
    }

    @Override
    public String toString() {
        return "HistoryModel{" +
                "id=" + id +
                ", videoTitle='" + videoTitle + '\'' +
                ", bv='" + bv + '\'' +
                ", cover='" + cover + '\'' +
                ", introduction='" + introduction + '\'' +
                ", upId='" + upId + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getBv() {
        return bv;
    }

    public void setBv(String bv) {
        this.bv = bv;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getUpId() {
        return upId;
    }

    public void setUpId(String upId) {
        this.upId = upId;
    }
}
