package com.example.diego.rottenappledesign;
/*
* Activity che contiene le Cards espandibili
* @author RottenApple
* @version 1.0
*/
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
    private DrawerLayout mDrawer;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<CardContent> mDataset;
    private int[] mImages = {
            R.drawable.beach,
            R.drawable.beach1,
            R.drawable.beach2,
            R.drawable.beach3,
            R.drawable.beach4,
    };
    private String [] mPrimary_text ={"Titolo Prima Card","Titolo Seconda Card","Titolo Terza Card",
            "Titolo Quarta Card","Titolo Quinta Card"};
    private String [] mSubtitle ={"Sottotitolo Prima Card","Sottotitolo Seconda Card",
            "Sottotitolo Terza Card","Sottotitolo Quarta Card","Sottotitolo Quinta Card"};
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);

        /*
         *Inizio del codice per il Navigation Drawer
         */
        //Istanzia il Navigation View e il Drawer tramite l'id nel layout
        final NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer);
        // Aggiunta dell'icona del Navigation Drawer nella Toolbar
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setHomeAsUpIndicator(R.drawable.drawer_icon);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        // Impostazione del comportamento quando un oggetto del Drawer viene premuto
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // Colora il background dell'oggetto del menu selezionato
                        menuItem.setChecked(true);
                        // Switch per sapere qual è l'activity da aprire in base all'oggetto selezionato
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
                        // Decolora l'oggetto selezionato e chiude il Drawer dopo la selezione dell'oggetto
                        menuItem.setChecked(false);
                        mDrawer.closeDrawers();
                        //apre l'activity selezionata
                        CardsActivity.this.startActivity(intent);
                        return true;
                    }
                });
        //Fine codice mDrawer

        /*
         *Inizio del codice per le Cards
         */
        // Si crea un ArrayList di oggetti CardContent e si inizializzano con
        // i valori degli array specificati in precedenza
        mDataset=new ArrayList<CardContent>();
        for (int i = 0; i < mPrimary_text.length; i++) {
            CardContent oggetto=new CardContent(mImages[i], mPrimary_text[i], mSubtitle[i]);
            mDataset.add(oggetto);
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        // Uso un Layout Manager per il Recycler View
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // Si usa un Adapter specificato nella classe CardAdapter che ha come parametro l'ArrayList
        // Con l'Adapter si gesticono tutte le azioni delle Cards
        mAdapter = new CardAdapter(mDataset);
        mRecyclerView.setAdapter(mAdapter);
    }

    //Metodo che permette l'apertura del Navigation Drawer toccando
    //l'icona corrispondente nella toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        } else if (id == android.R.id.home) {
            mDrawer.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }
}
