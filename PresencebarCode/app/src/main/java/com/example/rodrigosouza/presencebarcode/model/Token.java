package com.example.rodrigosouza.presencebarcode.model;

import com.google.gson.annotations.SerializedName;

public class Token {
    @SerializedName("token") private String token;

    public String getToken() {
        return token;
    }
}
