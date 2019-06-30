package com.example.rodrigosouza.presencebarcode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.rodrigosouza.presencebarcode.adapters.DeclaracaoAusenciaAdapter;
import com.example.rodrigosouza.presencebarcode.model.DeclaracaoAusencia;
import com.example.rodrigosouza.presencebarcode.util.ConnectionRetrofit;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HorarioDisponivelActivity extends AppCompatActivity {
    private List<DeclaracaoAusencia> ausencias;
    private ListView list;
    private DeclaracaoAusenciaAdapter ausenciaAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario_disponivel);
        list = (ListView)findViewById(R.id.lit_horario_disponivel);
        getLIst();
        //DeclaracaoAusenciaAdapter ausenciaAdapter = new DeclaracaoAusenciaAdapter(ausencias, this);
        //list.setAdapter(ausenciaAdapter);
    }
    public void getLIst(){

        final Call<List<DeclaracaoAusencia>> ausenciaCall = new ConnectionRetrofit().service().getDeclaracaoAusencia();
        ausenciaCall.enqueue(new Callback<List<DeclaracaoAusencia>>() {
            @Override
            public void onResponse(Call<List<DeclaracaoAusencia>> call, Response<List<DeclaracaoAusencia>> response) {
                Log.i("MyLOG",response.body().toString());
                //ausencias = response.body();
                populateListView(response.body());

            }
            @Override
            public void onFailure(Call<List<DeclaracaoAusencia>> call, Throwable t) {
                Log.i("MyLOG","Houve um erro: "+t.toString());
            }
        });
    }
    private void populateListView(List<DeclaracaoAusencia> ausencias) {
        list = findViewById(R.id.lit_horario_disponivel);
        ausenciaAdapter = new DeclaracaoAusenciaAdapter(ausencias, this);
        list.setAdapter(ausenciaAdapter);
    }


}
