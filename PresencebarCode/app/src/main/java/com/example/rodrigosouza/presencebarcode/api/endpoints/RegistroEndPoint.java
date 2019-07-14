package com.example.rodrigosouza.presencebarcode.api.endpoints;

import com.example.rodrigosouza.presencebarcode.model.Registro;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RegistroEndPoint {

    @POST("registros/")
    Call<Registro> postRegistro(@Body Registro registro);

}
