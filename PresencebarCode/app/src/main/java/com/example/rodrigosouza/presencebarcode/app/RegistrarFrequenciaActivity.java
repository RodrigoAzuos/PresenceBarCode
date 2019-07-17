package com.example.rodrigosouza.presencebarcode.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rodrigosouza.presencebarcode.R;
import com.example.rodrigosouza.presencebarcode.api.ApiService;
import com.example.rodrigosouza.presencebarcode.model.Disciplina;
import com.example.rodrigosouza.presencebarcode.model.Frequencia;
import com.example.rodrigosouza.presencebarcode.utils.Constants;
import com.example.rodrigosouza.presencebarcode.utils.SecurityPreferences;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrarFrequenciaActivity extends AppCompatActivity {
    private Button btnRegistrarFrequencia;
    private EditText editData, editHoraInicio, editHoraFim;
    private ApiService apiService;
    private SecurityPreferences securityPreferences;
    private long idExtra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_frequencia);
        bindViews();
        setupViews();
        apiService = new ApiService(securityPreferences.getSavedString(Constants.TOKEN));

    }

    private void registrarFrequencia(Frequencia frequencia) {
        Call<Frequencia> call = apiService.frequenciaEndPoint.postFrequencia(frequencia);
        call.enqueue(new Callback<Frequencia>() {
            @Override
            public void onResponse(Call<Frequencia> call, Response<Frequencia> response) {
                Toast.makeText(getApplicationContext(),""+response.message() +"- " + response.code(), Toast.LENGTH_LONG).show();
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
        long disciplina = this.idExtra;
        return new Frequencia(data,horaInicio,horaFim,disciplina);
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

    public void setupViews(){
        this.securityPreferences = new SecurityPreferences(this);
        this.idExtra = securityPreferences.getSavedLong(Constants.TURMA_ID);

    }
}
