package com.berjooj.consumodeapi.models;

import java.util.ArrayList;
import java.util.Arrays;

public class Post {
    public int userId;
    public int id;
    public String title;
    public String body;

    public ArrayList<Comment> commentList;

    public Post() {
        this.commentList = new ArrayList<>();
    }

    public Post(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;

        this.commentList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Post{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body.substring(0, 5) + "..." + '\'' +
                ", commentList=" + commentList.toString() +
                '}';
    }
}
