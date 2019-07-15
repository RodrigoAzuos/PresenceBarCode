package com.example.rodrigosouza.presencebarcode.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.rodrigosouza.presencebarcode.R;
import com.example.rodrigosouza.presencebarcode.adapters.TurmaAdapter;
import com.example.rodrigosouza.presencebarcode.api.ApiService;
import com.example.rodrigosouza.presencebarcode.model.Disciplina;
import com.example.rodrigosouza.presencebarcode.model.Turma;
import com.example.rodrigosouza.presencebarcode.utils.Constants;
import com.example.rodrigosouza.presencebarcode.utils.SecurityPreferences;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TurmasActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private TurmaAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ApiService apiService;
    private SecurityPreferences securityPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turmas);

        Toolbar toolbar = findViewById(R.id.toolbar_turmas);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Turmas Disponíveis");

        securityPreferences = new SecurityPreferences(this);

        mRecyclerView = findViewById(R.id.rv_turmas);

        mRecyclerView.setHasFixedSize(true);

        apiService = new ApiService(Constants.TOKEN);
        getTurmas();

    }

    private void getTurmas(){
        Call<List<Turma>> turmasCall = apiService.turmaEndPoint.getTurmas();

        turmasCall.enqueue(new Callback<List<Turma>>() {
            @Override
            public void onResponse(Call<List<Turma>> call, Response<List<Turma>> response) {
                Toast.makeText(TurmasActivity.this, ""+response.body().toString(), Toast.LENGTH_LONG).show();
                exibirTurmas(response.body());
            }

            @Override
            public void onFailure(Call<List<Turma>> call, Throwable t) {
                Toast.makeText(TurmasActivity.this, "Conexão Falha: " + t.getCause(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void exibirTurmas(List<Turma> turmas){
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new TurmaAdapter(turmas, this);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mRecyclerView.setAdapter(mAdapter);
            }
        }, 300);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_home_drawer,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.nav_sair){
            securityPreferences.limpar();
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
