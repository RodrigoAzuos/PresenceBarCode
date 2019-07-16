package com.example.rodrigosouza.presencebarcode.api;

import com.example.rodrigosouza.presencebarcode.api.endpoints.LoginEndPoint;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiServiceLogin {

    public static  final String BASE_URL = "http://192.168.0.106:8000/api/";
    public Retrofit retrofit;
    public Interceptor interceptor;

    public LoginEndPoint loginEndPoint;

    public ApiServiceLogin(){
        this.interceptor = new InterceptorApiLogin();

        OkHttpClient.Builder builderCliente = new OkHttpClient.Builder();
        builderCliente.interceptors().add(this.interceptor);
        OkHttpClient cliente = builderCliente.build();

        Retrofit.Builder builder = new Retrofit.Builder();
        retrofit = builder.baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(cliente)
                .build();

        loginEndPoint = retrofit.create(LoginEndPoint.class);
    }
}
