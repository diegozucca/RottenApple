package com.example.diego.rottenappledesign;


/*
*
* Activity dei colori.Mostra i tre colori principali del tema con i loro valori esadecimali.
* Viene attivata la transizione del FAB button.
*
* @author RottenApple
* @version 1.0
* */



import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Colors extends AppCompatActivity {

    //  definizione  dei campi utili per la grafica.
    //il parametro i è usato come puntatore al colore che viene mostrato all'utente: si veda negli if statement
    public static int i=0;
    public Button mB;
    public Button mA;
    public TextView t;
    private DrawerLayout mDrawer;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        //inizializzazione dei bottoni e del testo
        setContentView(R.layout.activity_colors);
        mA = (Button) findViewById(R.id.button_color);
        mB = (Button) findViewById(R.id.button_color2);
        t= (TextView) findViewById(R.id.colorText2);

        //Inizio codice per il navigation drawer
        final NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer);
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
                                intent=new Intent(Colors.this, ButtonActivity.class);
                                break;
                            case R.id.world3d_menu:
                                intent=new Intent(Colors.this, TDWorld.class);
                                break;
                            case R.id.card_menu:
                                intent=new Intent(Colors.this, CardsActivity.class);
                                break;

                            case R.id.color_menu:
                                intent=new Intent(Colors.this, Colors.class);
                                break;

                            case R.id.images_menu:
                                intent=new Intent(Colors.this, Images.class);
                                break;

                        }
                        // Decolora l'oggetto selezionato e chiude il drawer dopo la selezione dell'oggetto
                        menuItem.setChecked(false);
                        mDrawer.closeDrawers();
                        //apre l'activity selezionata
                        Colors.this.startActivity(intent);
                        return true;
                    }
                });

        //Fine codice drawer


        /*
        *
        * onClickListenet() {onClick()} del bottone di cambio colore:bottone superiore.
        * quando viene cliccato il bottone superiore,cambia il colore del bottone inferiore,
        * la scritta posta sotto di esso e quella contenuta nel bottone superiore.
        * Viene incrementato il puntatore all'elemento successivo con andamento circolare:
        *  i E {0,1,2} => arrivato i a 2 viene riposto a zero
        *
        * */
        i=0;
        mA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //si incrementa i ad 1 e si mostra il colore primario scuro
                if(i==0) {

                    //recupero del colore
                    TypedValue typedValue = new  TypedValue();
                    Colors.this.getTheme().resolveAttribute(R.attr.colorPrimaryDark, typedValue, true);
                    final  int color = typedValue.data;

                    //setta il colore del bottone inferiore
                    mB.setBackgroundColor(color);
                    mB.setText("COLORE PRIMARIO SCURO");
                    //setta il colore della scritta del bottone superiore
                    mA.setTextColor(color);
                    //setta il testo sotto il bottone inferiore
                    t.setText("#691A99");
                    i++;
                }

                //si incrementa i a 2 e si mostra il colore d'accento
                else if(i==1) {

                    //recupero del colore
                    TypedValue typedValue = new  TypedValue();
                    Colors.this.getTheme().resolveAttribute(R.attr.colorAccent, typedValue, true);
                    final  int color = typedValue.data;
                    //setta il colore del bottone inferiore
                    mB.setBackgroundColor(color);
                    mB.setText("COLORE ACCENTO");
                    //setta il colore della scritta del bottone superiore
                    mA.setTextColor(color);
                    //setta il testo sotto il bottone inferiore
                    t.setText("#68EFAD");
                    i++;
                }


                //si riporta i a 0 e si mostra il colore principale
                else if(i==2) {

                    //recupero del colore
                    TypedValue typedValue = new  TypedValue();
                    Colors.this.getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true);
                    final  int color = typedValue.data;
                    //setta il colore del bottone inferiore
                    mB.setBackgroundColor(color);
                    mB.setText("COLORE PRIMARIO");
                    //setta il colore della scritta del bottone superiore
                    mA.setTextColor(color);
                    //setta il testo sotto il bottone inferiore
                    t.setText("#9B26AF");
                    i=0;


                }

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
            mDrawer.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }
}
