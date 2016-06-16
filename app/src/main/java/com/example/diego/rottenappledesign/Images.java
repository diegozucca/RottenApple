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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);

        //inizializzazione  della gridView e  impostazione dell'adapter implementato dalla classe ImagesGridAdapter
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

}
