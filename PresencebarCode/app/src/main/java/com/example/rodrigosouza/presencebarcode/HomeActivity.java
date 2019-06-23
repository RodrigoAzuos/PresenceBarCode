package com.example.rodrigosouza.presencebarcode;

import android.graphics.Color;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.rodrigosouza.presencebarcode.adapters.CardAdapter;

public class HomeActivity extends AppCompatActivity {

    TextView tvWish, tvName, tvToolbar;
    private RecyclerView rvPresenca;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private AppBarLayout appBarLayout;
    private ScrollView scrollView;
    private boolean scrollFlag = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvWish = findViewById(R.id.tv_wish);
        tvName = findViewById(R.id.tv_name);
        tvToolbar = findViewById(R.id.txt_toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        rvPresenca = findViewById(R.id.rv_card_presenca);

        rvPresenca.setHasFixedSize(true);

        mLayoutManager = new GridLayoutManager(this, 1);
        rvPresenca.setLayoutManager(mLayoutManager);

        mAdapter = new CardAdapter(new String[]{"0"}, this, this);
        rvPresenca.setAdapter(mAdapter);

        appBarLayout = findViewById(R.id.app_bar_home);

        appBarLayout.bringToFront();

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_hamburgar);


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

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
