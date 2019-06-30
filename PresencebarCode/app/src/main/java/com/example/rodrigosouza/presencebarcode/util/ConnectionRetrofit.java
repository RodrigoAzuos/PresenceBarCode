package com.example.rodrigosouza.presencebarcode.util;

import com.example.rodrigosouza.presencebarcode.interfaces.DeclaracaoAusenciaService;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class ConnectionRetrofit {
    private final Retrofit retrofit;
    public ConnectionRetrofit(){
        this.retrofit =  new Retrofit.Builder().baseUrl("http://192.168.0.108:8000/api/")
                .addConverterFactory(JacksonConverterFactory.create()).build();
    }

    public DeclaracaoAusenciaService service(){
        return this.retrofit.create(DeclaracaoAusenciaService.class);
    }
}
