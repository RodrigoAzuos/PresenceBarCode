package com.example.rodrigosouza.presencebarcode.model;

import com.google.gson.annotations.SerializedName;

public class Usuario {

    @SerializedName("id") private long id;
    @SerializedName("username") private String username;
    @SerializedName("password") private String password;

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
