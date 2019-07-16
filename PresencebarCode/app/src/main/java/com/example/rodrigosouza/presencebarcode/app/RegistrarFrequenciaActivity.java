package com.example.rodrigosouza.presencebarcode.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rodrigosouza.presencebarcode.R;
import com.example.rodrigosouza.presencebarcode.api.ApiService;
import com.example.rodrigosouza.presencebarcode.model.Frequencia;
import com.example.rodrigosouza.presencebarcode.utils.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrarFrequenciaActivity extends AppCompatActivity {
    private Button btnRegistrarFrequencia;
    private EditText editData, editHoraInicio, editHoraFim;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_frequencia);
        bindViews();
        apiService = new ApiService(Constants.TOKEN);

    }

    private void registrarFrequencia(Frequencia frequencia) {
        Call<Frequencia> call = apiService.frequenciaEndPoint.postFrequencia(frequencia);
        call.enqueue(new Callback<Frequencia>() {
            @Override
            public void onResponse(Call<Frequencia> call, Response<Frequencia> response) {
                Toast.makeText(getApplicationContext(),""+response.message(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Frequencia> call, Throwable t) {
                Toast.makeText(getApplicationContext(),""+t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private Frequencia criarFrequencia() {
        String data = editData.getText().toString();
        String horaInicio = editHoraInicio.getText().toString();
        String horaFim = editHoraFim.getText().toString();
        String ativo = "true";
        String disciplina = ""+getIntent().getLongExtra("turmaId",-1);
        return new Frequencia(data,ativo,horaInicio,horaFim,disciplina);
    }


    private void bindViews(){

        editData = findViewById(R.id.edit_data);
        editHoraInicio = findViewById(R.id.edit_hora_inicio);
        editHoraFim = findViewById(R.id.edit_hora_fim);
        btnRegistrarFrequencia = findViewById(R.id.btn_registrar_frequencia);
        btnRegistrarFrequencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarFrequencia(criarFrequencia());
            }
        });
    }
}
