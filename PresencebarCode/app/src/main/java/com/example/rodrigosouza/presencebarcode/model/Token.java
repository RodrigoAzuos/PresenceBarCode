package com.example.rodrigosouza.presencebarcode.model;

import com.google.gson.annotations.SerializedName;

public class Token {
    @SerializedName("token") private String token;
    @SerializedName("username") private String username;
    @SerializedName("id") private long id;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
