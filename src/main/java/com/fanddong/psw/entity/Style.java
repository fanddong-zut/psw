package com.fanddong.psw.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "style")
public class Style {
    @Id
    private int id;

    private String styleName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }
}
