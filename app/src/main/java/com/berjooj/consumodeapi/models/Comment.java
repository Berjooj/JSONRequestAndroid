package com.berjooj.consumodeapi.models;

public class Comment {
    public int postId;
    public int id;
    public String name;
    public String email;
    public String body;

    public Comment() {

    }

    public Comment(int postId, int id, String name, String email, String body) {
        this.postId = postId;
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "postId=" + postId +
                ", id=" + id +
                ", name='" + name.substring(0, 5) + "..." + '\'' +
                ", email='" + email + '\'' +
                ", body='" + body.substring(0, 5) + "..." +  + '\'' +
                '}';
    }
}
