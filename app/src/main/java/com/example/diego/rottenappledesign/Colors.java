package com.example.diego.rottenappledesign;


/*
*
* Activity dei colori.Mostra i tre colori principali del tema con i loro valori esadecimali.
* Viene attivata la transizione del FAB button.
*
* @author RottenApple
* @version 1.0
* */



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Colors extends AppCompatActivity {

    //  definizione dei campi utili per la grafica.
    //il parametro i è usato come puntatore al colore che viene mostrato all'utente: si veda negli if statement
    public static int i=0;
    public Button b;
    public Button a;
    public TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //inizializzazione dei bottoni e del testo
        setContentView(R.layout.activity_colors);
        a = (Button) findViewById(R.id.button_color);
        b = (Button) findViewById(R.id.button_color2);
        t= (TextView) findViewById(R.id.colorText2);

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
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //si incrementa i ad 1 e si mostra il colore primario scuro
                if(i==0) {

                    //recupero del colore
                    TypedValue typedValue = new  TypedValue();
                    Colors.this.getTheme().resolveAttribute(R.attr.colorPrimaryDark, typedValue, true);
                    final  int color = typedValue.data;

                    //setta il colore del bottone inferiore
                    b.setBackgroundColor(color);
                    b.setText("COLORE PRIMARIO SCURO");
                    //setta il colore della scritta del bottone superiore
                    a.setTextColor(color);
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
                    b.setBackgroundColor(color);
                    b.setText("COLORE ACCENTO");
                    //setta il colore della scritta del bottone superiore
                    a.setTextColor(color);
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
                    b.setBackgroundColor(color);
                    b.setText("COLORE PRIMARIO");
                    //setta il colore della scritta del bottone superiore
                    a.setTextColor(color);
                    //setta il testo sotto il bottone inferiore
                    t.setText("#9B26AF");
                    i=0;


                }

            }
        });


    }
}
