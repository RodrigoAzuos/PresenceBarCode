package com.example.rodrigosouza.presencebarcode.interfaces;

import com.example.rodrigosouza.presencebarcode.model.AusenciaInteresse;
import com.example.rodrigosouza.presencebarcode.model.DeclaracaoInteresse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AusenciaInteresseService {
    @POST("ausencias-interesses/")
    Call<AusenciaInteresse> confirmar(@Body AusenciaInteresse ausenciaInteresse);
}
