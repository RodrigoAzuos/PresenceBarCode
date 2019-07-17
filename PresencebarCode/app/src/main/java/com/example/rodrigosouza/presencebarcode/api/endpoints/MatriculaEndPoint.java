package com.example.rodrigosouza.presencebarcode.api.endpoints;

import com.example.rodrigosouza.presencebarcode.model.Aluno;
import com.example.rodrigosouza.presencebarcode.model.Matricula;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MatriculaEndPoint {

    @GET("matriculas-aluno/")
    Call<List<Matricula>> getMatriculas();
}
