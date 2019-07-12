package com.example.rodrigosouza.presencebarcode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.rodrigosouza.presencebarcode.adapters.AdapterTurma;
import com.example.rodrigosouza.presencebarcode.model.Turma;
import com.example.rodrigosouza.presencebarcode.utils.ConnectionRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaDeTurmaActivity extends AppCompatActivity {

    public RecyclerView rvTurmas;
    private AdapterTurma adapterTurma;

    private Turma turmaRes;
    private ListView list;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_turma);
        rvTurmas = findViewById(R.id.recycle_view_lista_turmas_id);
        rvTurmas.setLayoutManager(new LinearLayoutManager(this));
        getLIst();
    }
    public void getLIst(){

        final Call<List<Turma>> turmaCall = new ConnectionRetrofit().turmaService().getTurma();
        turmaCall.enqueue(new Callback<List<Turma>>() {
            @Override
            public void onResponse(Call<List<Turma>> call, Response<List<Turma>> response) {

                if(response.isSuccessful()) {
                    populateListView(response.body());
                }else{
                     Log.i("MyLOG","OK response: ");
                }

            }
            @Override
            public void onFailure(Call<List<Turma>> call, Throwable t) {
                Log.i("MyLOG","Houve um erro: "+t.toString());
            }
        });
    }



    private void populateListView(List<Turma> turmas) {
        Log.i("MyLOG",turmas.toString());
        adapterTurma = new AdapterTurma(turmas, this);
        rvTurmas.setAdapter(adapterTurma);
    }


}