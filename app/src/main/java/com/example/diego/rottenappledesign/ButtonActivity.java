package com.example.diego.rottenappledesign;


/*
*
* Activity di partenza. Viene creata dinamicamente la lista di elementi per le componenti material.
* Viene attivata la transizione del FAB button.
*
* @author RottenApple
* @version 1.0
* */


import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import java.util.ArrayList;


public class ButtonActivity extends AppCompatActivity {

    // definizione dei campi utili per grafica e debug.
    // L'ArrayList di item serve per inizializzare gli elementi del RecyclerView.
    // L'Array material è usato come contenitore di "nomi" dei componenti degli Item.
    // Il bundle serve per prelevare gli EXTRA degli Intent.

    private static final String LOG = ButtonActivity.class.getSimpleName();
    private static String[] material = new String[11];
    ArrayList<Item> items;
    private RecyclerView list;
    private String str,str2;
    private Bundle bundle;
    private FloatingActionButton fab;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //inizializzazione di toolBar RecyclerView e FAB
        setContentView(R.layout.activity_button);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        list = (RecyclerView) findViewById(R.id.list);
        fab= (FloatingActionButton) findViewById(R.id.fab);

        // riempimento dell'array contenitore dei nomi
        material[0]= "3DWorld";
        material[1]= "Cards";
        material[2]= "Colors";
        material[3]= "Images";

        //Esecuzione log: debug per errore scomparsa elementi dall'UI.
        Log.d(LOG, "LOG MATERIAL" + material[0] + " " + material[1] + " " + material[2] + " " + material[3] + " " + material[4]);


        // Nel caso sia stato riempito l'EXTRA dell'Intent da AddItem allora si preleva il valore e si aggiungono
        // altre stringhe alla lista. Tali scritte permettono di allungare la lista in maniera tale da
        // permettere lo scroll e vedere gli effetti del FAB.
        bundle = getIntent().getExtras();
        if(bundle!=null ) {

            str = bundle.getString("nuovo_elemento");

            if (str != null && (str.compareTo(" ") != 0)) {
                material[4] = " ";
                material[5] = "Prova lo scroll:";
                material[6] = "il bottone";
                material[7] = "FAB";
                material[8] = "scompare.";
                material[9] = "Hai scritto:";
                material[10] = str;
            }

        }

        //si inizializza l'Item.
        items = Item.createList(material);
        ItemsAdapter adptr = new ItemsAdapter(items);

        //adptr settato come adapter della RecyclerView e list attivato.
        list.setAdapter(adptr);
        list.setLayoutManager(new LinearLayoutManager(this));

        /*
        *
        * onClickListenet() {onClick()} del FAB principale.
        * Si esegue Intent verso l'Activity AddItem.
        * Si permette la condivisione grafica del FAB e quindi la sua transazione.
        *
        * */
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Intent verso AddItem.
                Intent intent = new Intent(ButtonActivity.this, AddItem.class);

                //Shared grafico dell'elemento.
                View sharedView = fab;
                String FABname = getString(R.string.FAB_transition);

                //si passano ad AddItem, tramite il metodo startActivity, le opzioni aggiuntive (sharedView) del Fab, come Bundle.
                ActivityOptions FABOptions = ActivityOptions.makeSceneTransitionAnimation(ButtonActivity.this, sharedView, FABname);
                startActivity(intent,FABOptions.toBundle());
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu m) {
        //Aggiunge items all'action bar.
        getMenuInflater().inflate(R.menu.menu_button, m);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem itm) {

        //si preleva l'id dell'elemento cliccato.
        int id = itm.getItemId();
        if (id == R.id.action_settings) {
            //si tratta dell'id dell'unico elemento del menu "action setting".
            //si riempie allora l'array della lista mettendo a zero i nuovi elementi.
            //risulta così graficamente l'eliminazione di essi.
            material[0]= "3DWorld";
            material[1]= "Cards";
            material[2]= "Colors";
            material[3]= "Images";
            //nuovi elementi a zero
            for(int i=4; i<11; i++) material[i]=null;

            //inizializza l'Item.
            items = Item.createList(material);
            ItemsAdapter adapter = new ItemsAdapter(items);

            //adapter settato come adapter della RecyclerView e list attivato.
            list.setAdapter(adapter);
            list.setLayoutManager(new LinearLayoutManager(this));

        }
        return super.onOptionsItemSelected(itm);
    }


}