package com.example.rodrigosouza.presencebarcode.interfaces;

import com.example.rodrigosouza.presencebarcode.model.DeclaracaoAusencia;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DeclaracaoAusenciaService {
    @GET("declaracoes-ausencias/")
    Call<List<DeclaracaoAusencia>> getDeclaracaoAusencia();
}
