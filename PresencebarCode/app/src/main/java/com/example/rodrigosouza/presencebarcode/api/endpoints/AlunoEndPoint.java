package com.example.rodrigosouza.presencebarcode.api.endpoints;

import com.example.rodrigosouza.presencebarcode.model.Aluno;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AlunoEndPoint {

    @GET("alunos/")
    Call<List<Aluno>> getAlunos();
}
