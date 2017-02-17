package com.lexalenka.recyclerview;

import java.io.Serializable;

/**
 * Created by v622721 on 1/18/17.
 */
public class Properties implements Serializable{
    private String name;
    private String info;
    private int thumbnail;

    public Properties() {
    }

    public Properties(String name, String info, int thumbnail) {
        this.name = name;
        this.info = info;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void getInfo(String info) {
        this.info = info;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
