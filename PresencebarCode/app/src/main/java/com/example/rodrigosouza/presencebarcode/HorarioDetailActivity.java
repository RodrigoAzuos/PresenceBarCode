package com.example.rodrigosouza.presencebarcode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HorarioDetailActivity extends AppCompatActivity {
    private Button disp;
    private Button cancel;
    private TextView disponivel;
    private TextView data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario_detail);
        bindView();
    }
    public void disponiblizar(View v){
        Toast.makeText(this, "O horário foi disponibilizado para outros professores!", Toast.LENGTH_SHORT).show();
        disp.setVisibility(View.GONE);
        disponivel.setText("Horario disponibilizado");
        cancel.setVisibility(View.VISIBLE);
    }

    public void cancelarDispon(View v){
        Toast.makeText(this, "A disponibilização foi cancelada!", Toast.LENGTH_SHORT).show();
        disp.setVisibility(View.VISIBLE);
        disponivel.setText("Horario Ativo");
        cancel.setVisibility(View.GONE);
    }
    
    private void bindView(){
        Intent intent = getIntent();
        String ano =  intent.getStringExtra("year");
        String mes =  intent.getStringExtra("month");
        String dia =  intent.getStringExtra("dayOfMonth");
        disp = (Button) findViewById(R.id.bt_disponibilizar);
        cancel = (Button)findViewById(R.id.bt_cancelar);
        disponivel = (TextView)findViewById(R.id.txt_disponivel);
        data = (TextView)findViewById(R.id.txt_data);
        data.setText(dia+"/"+mes+"/"+ano);
    }
}
