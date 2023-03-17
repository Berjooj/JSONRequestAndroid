package com.berjooj.consumodeapi.models;

import java.util.ArrayList;

public class Post {
    public int userId;
    public int id;
    public String title;
    public String body;

    private ArrayList<Comment> commentList;

    public Post(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;

        this.commentList = new ArrayList<>();
    }
}
