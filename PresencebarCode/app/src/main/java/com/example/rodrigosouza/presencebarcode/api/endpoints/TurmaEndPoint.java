package com.example.rodrigosouza.presencebarcode.api.endpoints;

import com.example.rodrigosouza.presencebarcode.model.Frequencia;
import com.example.rodrigosouza.presencebarcode.model.Turma;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TurmaEndPoint {

    @GET("turmas/")
    Call<List<Turma>> getTurmas();
}
