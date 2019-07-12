package com.example.rodrigosouza.presencebarcode.interfaces;

import com.example.rodrigosouza.presencebarcode.model.Turma;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface TurmaService {


    @GET("turmas/")
    Call<List<Turma>> getTurma();

    @POST("turmas/")
    Call<Turma> turma(@Body Turma turma);

}