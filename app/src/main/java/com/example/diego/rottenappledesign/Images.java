package com.example.diego.rottenappledesign;


/*
*
* Activity delle Immagini
* Contiene una GridView con le immagini
* @author RottenApple
* @version 1.0
* */


import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;


public class Images extends AppCompatActivity {

    //definizione  della GridView e del fab
    GridView gridview;
    FloatingActionButton fab;
    private DrawerLayout drawer;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);

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
                                intent=new Intent(Images.this, ButtonActivity.class);
                                break;
                            case R.id.world3d_menu:
                                intent=new Intent(Images.this, TDWorld.class);
                                break;
                            case R.id.card_menu:
                                intent=new Intent(Images.this, CardsActivity.class);
                                break;

                            case R.id.color_menu:
                                intent=new Intent(Images.this, Colors.class);
                                break;

                            case R.id.images_menu:
                                intent=new Intent(Images.this, Images.class);
                                break;

                        }
                        // Decolora l'oggetto selezionato e chiude il drawer dopo la selezione dell'oggetto
                        menuItem.setChecked(false);
                        drawer.closeDrawers();
                        //apre l'activity selezionata
                        Images.this.startActivity(intent);
                        return true;
                    }
                });

        //Fine codice drawer

        //inizializzazione della gridView e impostazione dell'adapter implementato dalla classe ImagesGridAdapter
        gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImagesGridAdapter(this));

        //inizializzazione del fab
        fab = (FloatingActionButton) findViewById(R.id.imageFAB);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //si prepara e poi si mostra la snackbar che segnala il fatt che il FAB mini è solo un prototipo
                Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "MiniFab non attivo", Snackbar.LENGTH_LONG);
                snackbar.show();

            }
        });
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
