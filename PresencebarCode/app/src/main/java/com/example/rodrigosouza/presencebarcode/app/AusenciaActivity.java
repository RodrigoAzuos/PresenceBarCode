package com.example.rodrigosouza.presencebarcode.app;

import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.rodrigosouza.presencebarcode.R;

public class AusenciaActivity extends AppCompatActivity {

    public AppBarLayout appBarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ausencia);
        setupViews();
    }

    public void setupViews(){
        final Toolbar toolbar = findViewById(R.id.toolbar_ausencia);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Declarar Ausência");

        appBarLayout = findViewById(R.id.app_bar_ausencia);

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
