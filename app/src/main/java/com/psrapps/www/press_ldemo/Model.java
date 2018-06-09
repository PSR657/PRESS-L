package com.psrapps.www.press_ldemo;

/**
 * Created by poornashekarreddy.p on 19-08-2017.
 */

public class Model {

    private String title="";
    private String link="";
    private String duration="";
    private String category="";
    private String description="";

    public Model(String title, String duration, String category, String description,String link) {
        this.title = title;
        this.duration = duration;
        this.category = category;
        this.description = description;
        this.link = link;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
