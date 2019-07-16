package com.example.rodrigosouza.presencebarcode.app;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rodrigosouza.presencebarcode.R;
import com.example.rodrigosouza.presencebarcode.adapters.CardAcaoFrequenciaAdapter;
import com.example.rodrigosouza.presencebarcode.api.ApiService;
import com.example.rodrigosouza.presencebarcode.model.Frequencia;
import com.example.rodrigosouza.presencebarcode.model.Token;
import com.example.rodrigosouza.presencebarcode.model.Usuario;
import com.example.rodrigosouza.presencebarcode.utils.Constants;
import com.example.rodrigosouza.presencebarcode.utils.SecurityPreferences;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FrequenciaActivity extends AppCompatActivity {

    TextView title;
    private RecyclerView mRecyclerView;
    private CardAcaoFrequenciaAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private AppBarLayout appBarLayout;
    private SecurityPreferences securityPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frequencia);

        setupViews();

        securityPreferences = new SecurityPreferences(this);

        title = findViewById(R.id.tv_title);

        Shader textShader=new LinearGradient(0, 0, 200, 20,
                new int[]{Color.BLUE, Color.parseColor("#00BCD4")},
                new float[]{0, 1}, Shader.TileMode.CLAMP);
        title.getPaint().setShader(textShader);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_frequencia);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new CardAcaoFrequenciaAdapter(new String[]{"0"}, this, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void setupViews(){

        final Toolbar toolbar = findViewById(R.id.toolbar_frequencia);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(getIntent().getStringExtra("turmaDisciplinaNome"));

        appBarLayout = findViewById(R.id.app_bar_frequencia);

        appBarLayout.bringToFront();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home){
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
