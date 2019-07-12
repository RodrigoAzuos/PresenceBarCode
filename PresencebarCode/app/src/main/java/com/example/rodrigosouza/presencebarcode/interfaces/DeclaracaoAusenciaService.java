package com.example.rodrigosouza.presencebarcode.interfaces;

import com.example.rodrigosouza.presencebarcode.model.DeclaracaoAusencia;
import com.example.rodrigosouza.presencebarcode.model.DeclaracaoInteresse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DeclaracaoAusenciaService {
    @GET("declaracoes-ausencias/")
    Call<List<DeclaracaoAusencia>> getDeclaracaoAusencia();

    @POST("declaracoes-interesses/")
    Call<DeclaracaoInteresse> declararInteresse(@Body DeclaracaoInteresse interesse);

    @POST("declaracoes-ausencias/")
    Call<DeclaracaoAusencia> declararAusencia(@Body DeclaracaoAusencia ausencia);

    @GET("declaracoes-ausencias/?")
    Call<DeclaracaoAusencia> verficaDeclaracaoAusencia(@Query("horario") String id);

    @DELETE("declaracoes-ausencias/{id}")
    Call<DeclaracaoAusencia> deleteDeclaracao(@Path("id") String id);
}