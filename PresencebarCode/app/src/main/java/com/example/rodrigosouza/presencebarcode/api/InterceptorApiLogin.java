package com.example.rodrigosouza.presencebarcode.api;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class InterceptorApiLogin implements Interceptor {

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request().newBuilder()
                .build();

        return chain.proceed(request);
    }
}

