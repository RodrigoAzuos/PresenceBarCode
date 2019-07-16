package com.example.rodrigosouza.presencebarcode.api.endpoints;

import com.example.rodrigosouza.presencebarcode.model.Token;
import com.example.rodrigosouza.presencebarcode.model.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface LoginEndPoint {

    @POST("logado/")
    Call<Token> getToken(@Body Usuario usuario);

}
