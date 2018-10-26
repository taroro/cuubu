package com.example.artid.cuubu.classes;

public class Subject {
    private String id;
    private String title;

    public Subject() { }

    public Subject(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }
}
