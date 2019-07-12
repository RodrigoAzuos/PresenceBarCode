package com.example.rodrigosouza.presencebarcode.utils;
import com.example.rodrigosouza.presencebarcode.interfaces.AusenciaInteresseService;
import com.example.rodrigosouza.presencebarcode.interfaces.DeclaracaoAusenciaService;
import com.example.rodrigosouza.presencebarcode.interfaces.HorarioService;
import com.example.rodrigosouza.presencebarcode.interfaces.TurmaService;
import com.example.rodrigosouza.presencebarcode.model.AusenciaInteresse;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class ConnectionRetrofit {
    private final Retrofit retrofit;
    public ConnectionRetrofit(){
        this.retrofit =  new Retrofit.Builder().baseUrl("http://192.168.0.104:8000/api/")
                .addConverterFactory(JacksonConverterFactory.create()).build();
    }

    public DeclaracaoAusenciaService service(){
        return this.retrofit.create(DeclaracaoAusenciaService.class);
    }

    public HorarioService horarioService(){
        return this.retrofit.create(HorarioService.class);
    }
    public TurmaService turmaService(){
        return  this.retrofit.create(TurmaService.class);
    }


}