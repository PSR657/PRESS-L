package com.psrapps.www.press_ldemo;

/**
 * Created by poornashekarreddy.p on 10-09-2017.
 */

public class Modelb {
    private String name;
    private String description;
    private String path;
    private String category;

    public String getName() {
        return name;
    }

    public Modelb(String name, String description, String path, String category) {
        this.name = name;
        this.description = description;
        this.path = path;
        this.category = category;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
