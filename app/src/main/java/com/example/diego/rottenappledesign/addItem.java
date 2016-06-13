package com.example.diego.rottenappledesign;


/*
*
* Activity chiamata da button per permettere all'utente di inserire una stringa.
* L'Activity inserisce la stringa nell'extra dell'intent e poi tramite lo stesso richiama ButtonActivity.
*
* @author RottenApple
* @version 1.0
* */

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class AddItem extends AppCompatActivity {

    // definizione dei campi utili per grafica e parametri d passare a ButtonActivity.
    public EditText testo;
    private String str;
    private FloatingActionButton invia;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //inizializzazione dell'edit text,del FAB, del toolbar e della stringa da riempire.
        setContentView(R.layout.activity_add_item);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        testo = (EditText) findViewById(R.id.nuovo_elemento);
        invia = (FloatingActionButton) findViewById(R.id.button_nuovo_elemento);
        str = new String();


        /*
        *
        * onClickListenet() {onClick()} del FAB di invio stringa inserita.
        * Invia il valore inserito dall'utente a ButtonActivity tramite l'intent.
        * Si permette la condivisione dell'elemento tra questa Activity e ButtonActivity, attivando così
        * l'effetto traslazione.
        *
        ***/
        invia.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                //preleva il testo dall'EditText.
                str = testo.getText().toString();

                //intent verso ButtonActivity con dentro l'EXTRA la stringa inserita dall'utente.
                Intent intent = new Intent(AddItem.this, ButtonActivity.class);
                intent.putExtra("nuovo_elemento", str);

                //Shared grafico dell'elemento.
                View sharedView = invia;
                String FABname = getString(R.string.FAB_transition);

                //si passano ad AddItem, tramite il metodo startActivity, le opzioni aggiuntive (sharedView) del Fab, come Bundle.
                ActivityOptions FABOptions = ActivityOptions.makeSceneTransitionAnimation(AddItem.this, sharedView, FABname);
                startActivity(intent,FABOptions.toBundle());


            }
        });


    }


}