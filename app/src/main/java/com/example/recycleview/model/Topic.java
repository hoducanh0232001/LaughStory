package com.example.recycleview.model;

public class Topic {

    private String idName;
    private String title;
    public Topic(String title, String idName) {
        this.title = title;
        this.idName = idName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIdName() {
        return idName;
    }

    public void setIdName(String idName) {
        this.idName = idName;
    }
}
