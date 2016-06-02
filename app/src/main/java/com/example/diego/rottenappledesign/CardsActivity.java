package com.example.diego.rottenappledesign;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class CardsActivity extends AppCompatActivity {
    private DrawerLayout drawer;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    //private String[] myDataset= {"Prima Card","Seconda Card","Terza Card","Quarta Card","Quinta Card"};
    private List<CardContent> mDataset;
    private int[] images={
            R.drawable.beach,R.drawable.beach1,R.drawable.beach2,R.drawable.beach3,R.drawable.beach4,
    };
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);

        //Inizio codice per il navigation drawer
        final NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        drawer = (DrawerLayout) findViewById(R.id.drawer);
        // Aggiunta dell'icona del navigation drawer nella Toolbar
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setHomeAsUpIndicator(R.drawable.drawer_icon);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        // Impostazione del comportamento quando un oggetto del drawer viene premuto
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // Colora il background dell'oggetto del menu selezionato
                        menuItem.setChecked(true);
                        // Switch per aprire l'activity riguardante l'oggetto selezionato
                        switch (menuItem.getItemId()){
                            case R.id.button_menu:
                                intent=new Intent(CardsActivity.this, ButtonActivity.class);
                                break;
                            case R.id.world3d_menu:
                                intent=new Intent(CardsActivity.this, TDWorld.class);
                                break;
                            case R.id.card_menu:
                                intent=new Intent(CardsActivity.this, CardsActivity.class);
                                break;

                            case R.id.color_menu:
                                intent=new Intent(CardsActivity.this, Colors.class);
                                break;

                            case R.id.images_menu:
                                intent=new Intent(CardsActivity.this, Images.class);
                                break;

                        }
                        // Decolora l'oggetto selezionato e chiude il drawer dopo la selezione dell'oggetto
                        menuItem.setChecked(false);
                        drawer.closeDrawers();
                        //apre l'activity selezionata
                        CardsActivity.this.startActivity(intent);
                        return true;
                    }
                });

        //Fine codice drawer
        //start test
        mDataset=new ArrayList<CardContent>();
        String [] primary_text={"Titolo Prima Card","Titolo Seconda Card","Titolo Terza Card",
                "Titolo Quarta Card","Titolo Quinta Card"};
        String [] subtitle={"Sottotitolo Prima Card","Sottotitolo Seconda Card","Sottotitolo Terza Card",
                "Sottotitolo Quarta Card","Sottotitolo Quinta Card"};
        for (int i = 0; i < primary_text.length; i++) {
            CardContent oggetto=new CardContent(images[i],primary_text[i],subtitle[i]);
            mDataset.add(oggetto);
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new CardAdapter(mDataset);
        mRecyclerView.setAdapter(mAdapter);
    }
    //Metodo che permette l'apertura del navigation drawer toccando
    //l'icona corrispondente nella toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        } else if (id == android.R.id.home) {
            drawer.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }
}