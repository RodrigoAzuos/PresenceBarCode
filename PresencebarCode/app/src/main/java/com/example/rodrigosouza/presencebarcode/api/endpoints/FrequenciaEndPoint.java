package com.example.rodrigosouza.presencebarcode.api.endpoints;

import com.example.rodrigosouza.presencebarcode.model.Frequencia;
import com.example.rodrigosouza.presencebarcode.model.Token;
import com.example.rodrigosouza.presencebarcode.model.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface FrequenciaEndPoint {

    @GET("frequencias/")
    Call<List<Frequencia>> getFrequencia();

    @POST("frequencias/")
    Call<Frequencia> postFrequencia(@Body Frequencia frequencia);
}
