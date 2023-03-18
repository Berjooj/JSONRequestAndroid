package com.berjooj.consumodeapi.controllers;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.berjooj.consumodeapi.models.Comment;
import com.berjooj.consumodeapi.models.Post;
import com.berjooj.consumodeapi.models.Todo;
import com.berjooj.consumodeapi.models.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RequestController {
    public static ArrayList<User> userList = new ArrayList<>();

    public static void init(Context context) {
        RequestController.fetchUsers(context);
    }

    public static void fetchUsers(Context context) {
        String url = "https://jsonplaceholder.typicode.com/users";

        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                response -> {
                    for (int i = 0; i < response.length(); i++) {
                        User user = new User();

                        try {
                            JSONObject json = response.getJSONObject(i);

                            user.id = Integer.parseInt(json.getString("id"));
                            user.name = json.getString("name");
                            user.username = json.getString("username");
                            user.email = json.getString("email");
                            user.address = json.getString("address");
                            user.phone = json.getString("phone");
                            user.website = json.getString("website");

                            RequestController.userList.add(user);
                        } catch (JSONException e) {
                            Toast.makeText(context, "Erro ao buscar usuários: " + e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }

                    RequestController.fetchPost(context);
                },
                error -> {
                    Toast.makeText(context, "Erro na requisição: " + url, Toast.LENGTH_LONG).show();
                }
        );

        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(request);
    }

    public static void fetchPost(Context context) {
        String url = "https://jsonplaceholder.typicode.com/posts";

        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                response -> {
                    for (int i = 0; i < response.length(); i++) {
                        Post post = new Post();

                        try {
                            JSONObject json = response.getJSONObject(i);

                            post.userId = Integer.parseInt(json.getString("userId"));
                            post.id = Integer.parseInt(json.getString("id"));
                            post.body = json.getString("body");
                            post.title = json.getString("title");

                            RequestController.userList.stream().filter(
                                    user -> post.userId == user.id
                            ).findFirst().ifPresent(user -> user.postList.add(post));

                        } catch (JSONException e) {
                            Toast.makeText(context, "Erro ao buscar usuários: " + e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }

                    RequestController.fetchTodo(context);
                },
                error -> {
                    Toast.makeText(context, "Erro na requisição: " + url, Toast.LENGTH_LONG).show();
                }
        );

        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(request);
    }

    public static void fetchTodo(Context context) {
        String url = "https://jsonplaceholder.typicode.com/todos";

        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                response -> {
                    for (int i = 0; i < response.length(); i++) {
                        Todo todo = new Todo();

                        try {
                            JSONObject json = response.getJSONObject(i);

                            todo.userId = Integer.parseInt(json.getString("userId"));
                            todo.id = Integer.parseInt(json.getString("id"));
                            todo.title = json.getString("title");
                            todo.completed = Boolean.parseBoolean(json.getString("completed"));

                            RequestController.userList.stream().filter(
                                    user -> todo.userId == user.id
                            ).findFirst().ifPresent(user -> user.todoList.add(todo));

                        } catch (JSONException e) {
                            Toast.makeText(context, "Erro ao buscar usuários: " + e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }

                    RequestController.fetchComment(context);
                },
                error -> {
                    Toast.makeText(context, "Erro na requisição: " + url, Toast.LENGTH_LONG).show();
                }
        );

        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(request);
    }

    public static void fetchComment(Context context) {
        String url = "https://jsonplaceholder.typicode.com/comments";

        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                response -> {
                    for (int i = 0; i < response.length(); i++) {
                        Comment comment = new Comment();

                        try {
                            JSONObject json = response.getJSONObject(i);

                            comment.postId = Integer.parseInt(json.getString("postId"));
                            comment.id = Integer.parseInt(json.getString("id"));
                            comment.body = json.getString("body");
                            comment.email = json.getString("email");
                            comment.name = json.getString("name");

                            RequestController.userList.forEach(user -> {
                                user.postList.stream().filter(
                                        post -> comment.postId == post.id
                                ).findFirst().ifPresent(post -> post.commentList.add(comment));
                            });

                        } catch (JSONException e) {
                            Toast.makeText(context, "Erro ao buscar usuários: " + e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }

                    System.out.println(
                            RequestController.userList.get(9)
                    );
                },
                error -> {
                    Toast.makeText(context, "Erro na requisição: " + url, Toast.LENGTH_LONG).show();
                }
        );

        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(request);
    }
}
