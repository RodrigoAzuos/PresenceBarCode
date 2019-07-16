package com.example.rodrigosouza.presencebarcode.app;

import android.graphics.Color;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.rodrigosouza.presencebarcode.R;
import com.example.rodrigosouza.presencebarcode.adapters.CardHorarioAdapter;
import com.example.rodrigosouza.presencebarcode.adapters.CardPresencaAdapter;
import com.example.rodrigosouza.presencebarcode.adapters.CardFrequenciaAdapter;
import com.example.rodrigosouza.presencebarcode.api.ApiService;
import com.example.rodrigosouza.presencebarcode.model.Item;
import com.example.rodrigosouza.presencebarcode.utils.Constants;
import com.example.rodrigosouza.presencebarcode.utils.SecurityPreferences;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    TextView tvToolbar;
    private RecyclerView rvPresenca, rvFrequencia, rvHorario;
    private RecyclerView.Adapter mAdapter, frequenciaAdapter, horarioAdapter;
    private RecyclerView.LayoutManager mLayoutManager, layoutManagerFrequencia, layoutManagerHorario;
    private AppBarLayout appBarLayout;
    private ScrollView scrollView;
    private boolean scrollFlag = false;
    private long turmaId;

    ApiService apiService;
    SecurityPreferences securityPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        final Toolbar toolbar = findViewById(R.id.toolbar_home);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(getIntent().getStringExtra("turmaDisciplinaNome"));

        initComponents();

        scrollView = findViewById(R.id.scrollView);
        scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                int scrollY = scrollView.getScrollY();
                if (scrollY > 100){
                    if (!scrollFlag) {
                        toolbar.setBackgroundColor(Color.WHITE);
                        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_hamburgar_2);
                        tvToolbar.setVisibility(View.VISIBLE);
                        scrollFlag = true;
                    }
                } else {
                    if (scrollFlag) {
                        toolbar.setBackgroundColor(Color.TRANSPARENT);
                        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_hamburgar);
                        tvToolbar.setVisibility(View.INVISIBLE);
                        scrollFlag = false;
                    }
                }
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home){
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public List<Item> setupItemPresenca(){
        List<Item> itens = new ArrayList<Item>();
        Item item1 = new Item("Código de Barras");
        Item item2 = new Item("Carga Horária");
        itens.add(item1);
        itens.add(item2);
        return itens;
    }

    public List<Item> setupItemHorario(){
        List<Item> itens = new ArrayList<Item>();
        Item item1 = new Item("Declarar Ausência");
        Item item2 = new Item("Declarar Interesse");
        itens.add(item1);
        itens.add(item2);
        return itens;
    }
    public void initComponents(){

        securityPreferences = new SecurityPreferences(this);
        apiService = new ApiService(securityPreferences.getSavedString(Constants.TOKEN));

        turmaId = getIntent().getLongExtra("turmaId",-1);

        setupAdapters();

        appBarLayout = findViewById(R.id.app_bar_home);

        appBarLayout.bringToFront();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void setupAdapters(){

        rvPresenca = findViewById(R.id.rv_card_presenca);
        rvPresenca.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(this, 2);
        rvPresenca.setLayoutManager(mLayoutManager);
        mAdapter = new CardPresencaAdapter(setupItemPresenca(), this, this);
        rvPresenca.setAdapter(mAdapter);

        rvFrequencia = findViewById(R.id.rv_card_frequencia);
        rvFrequencia.setHasFixedSize(true);
        layoutManagerFrequencia = new GridLayoutManager(this,1);
        rvFrequencia.setLayoutManager(layoutManagerFrequencia);
        frequenciaAdapter = new CardFrequenciaAdapter(new String[]{"0"}, this, this);
        rvFrequencia.setAdapter(frequenciaAdapter);

        rvHorario = findViewById(R.id.rv_card_horarios);
        rvHorario.setHasFixedSize(true);
        layoutManagerHorario = new GridLayoutManager(this,2);
        rvHorario.setLayoutManager(layoutManagerHorario);
        horarioAdapter = new CardHorarioAdapter(setupItemHorario(), this, this);
        rvHorario.setAdapter(horarioAdapter);


    }
}
