package com.example.diego.rottenappledesign;


/*
*
* Classe di ausilio per la creazione della lista principale.
* Contiene i metodi per il Bind degli elementi del RecyclerView
* Traite questa classe si creano e modificano gli elementi della lista
*
* @author RottenApple
* @version 1.0
* */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

public class ItemsAdapter extends
        RecyclerView.Adapter<ItemsAdapter.ViewHolder> {

    // definizione dei  campi utili per debug e per la creazione della lista
    //mItems contiene la lista degli Ietm inizializzati dal costruttore
    //context, button e textView contengono elementi correlati all'activity
    private static final String LOG = ButtonActivity.class.getSimpleName();
    private List<Item> mItems;
    private Context context;
    public Button button;
    public TextView textView;

    //costruttore: riceve una Lista di Item
    public ItemsAdapter(List<Item> items) {
        mItems = items;
    }



    /*
    *
    * @override del metodo onCreateViewHolder della classe Adapter del RecyclerView
    * riceve in ingesso il padre (nella gerarchia grafica) del view creato (dopo la quale creazione, tale metodo è chiamato)
    * e il tipo del view e restituisce un ViewHolder interno al padre passato.
    * Il view holder è l'elemento della recyclerView, descritto nel file Item.xml
    *
    * */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //recupera il contesto: l'Activity dove ci si trova
        Context context = parent.getContext();

        //inflater nell'activity
        LayoutInflater inflater = LayoutInflater.from(context);

        //crea il conView da passare al costruttore della classe ViewHolder
        //viene creato un view basato sulla grafica di item.xml
        //tale view è messa dentro il padre nella gerarchia grafica
        View conView = inflater.inflate(R.layout.item, parent, false);

        //crea il viewHolder e lo restituisce
        ViewHolder vh = new ViewHolder(conView);
        return vh;
    }


    /*
    *
    * @override del metodo onBindViewHolder della classe adapter del Recyclerview
    * riceve in ingresso un viewHolder (definito nella classe statica in fondo al file)
    * e la posizione nella lista dell'item da elaborare
    * collega gli elementi della lista di Item alla grafica: da vita agli elementi del RecyclerView.
    * tale metodo è chiamato ogni volta che si deve creare un elemento "grafico"
    * ad esempio con lo scroll dopo che alcuni elementi della lista non sono più visibili
    * lo si può vedere anche con il log "ELEMENTO in ONBIND"
    *
    *
    * */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        //debug per problema con scroll
        Log.d(LOG,"ELEMENTO in ONBIND");

        //preleva l'elemento alla posizione position della lista
        Item c = mItems.get(position);

        //textVew, grazie al costruttore della classe ViewHolder (in fondo al file), punta al testo dell'Item.xml relativo all'elemento di cui si è fatto il bind
        textView = holder.nameTextView;

        //button, grazie al costruttore della classe ViewHolder (in fondo al file),  punta al bottone dell'Item.xml relativo all'elemento di cui si è fatto il bind
        button = holder.messageButton;

        //elaborazione dell'Item
        if (c.getName() != null) {


            if (c.isNotNew()) {
                //l'elemento in questione fa parte di quelli NATIVI
                //si attiva il bottone dell'item
                button.setEnabled(true);

                //debug per problema con scroll
                Log.d(LOG, c.getName() + " NATIVE if onBind");

                //nome che distingue i vari casi
                String name = c.getName();
                switch (name) {

                    case "3DWorld": {
                        //debug per problema con scroll
                        Log.d(LOG, "3DWorld ==" + c.getName() +" ?" );

                        //imposta testo di bottone (il comando) e di descrizione
                        textView.setText("Mostra 3DWorld");
                        button.setText("3DWorld");

                        //onClick di redirezione verso l'Activity relativa al nome del comando
                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                context = view.getContext();
                                Intent intent = new Intent(context, TDWorld.class);
                                context.startActivity(intent);

                            }
                        });
                        break;
                    }

                    case "Cards": {
                        //debug per problema con scroll
                        Log.d(LOG, "Cards ==" + c.getName() +" ?" );

                        //imposta testo di bottone (il comando) e di descrizione
                        textView.setText("Mostra Cards");
                        button.setText("Cards");

                        //onClick di redirezione verso l'Activity relativa al nome del comando
                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                context = view.getContext();
                                Intent intent = new Intent(context, CardsActivity.class);
                                context.startActivity(intent);

                            }
                        });
                        break;

                    }

                    case "Colors": {
                        //debug per problema con scroll
                        Log.d(LOG, "Colors ==" + c.getName() +" ?" );

                        //imposta testo di bottone (il comando) e di descrizione
                        textView.setText("Mostra Colors");
                        button.setText("Colors");

                        //onClick di redirezione verso l'Activity relativa al nome del comando
                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                context = view.getContext();
                                Intent intent = new Intent(context, Colors.class);
                                context.startActivity(intent);



                            }
                        });
                        break;
                    }

                    case "Images": {
                        //debug per problema con scroll
                        Log.d(LOG, "Images ==" + c.getName() +" ?" );

                        //imposta testo di bottone (il comando) e di descrizione
                        textView.setText("Mostra Images");
                        button.setText("Images");

                        //onClick di redirezione verso l'Activity relativa al nome del comando
                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                context = view.getContext();
                                Intent intent = new Intent(context, Images.class);
                                context.startActivity(intent);


                            }
                        });
                        break;
                    }

                }//swithc

            }//if (c.isNotNew())
              else {
                //l'elemento in questione non è NATIVO ma aggiunto per lo SCROLL

                //si imposta il testo
                textView.setText(c.getName());

                //il bottone del comando non serve
                //lo si rende invisibile e poi si elimina
                button.setVisibility(View.INVISIBLE);
                ViewGroup layout = (ViewGroup) button.getParent();
                if(null!=layout) layout.removeView(button);

                //textOnly single line items paddingLeft= 16
                textView.setPadding(16,0,0,0);
                //conversione da DP a PIXELS spessore di 48 DP in pixels:
                // 48 dp è l'altezza del text onli single item prevista dal material
                DisplayMetrics displayMetrics = textView.getContext().getResources().getDisplayMetrics();
                int px = Math.round(48 * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
                textView.setHeight(px);

                //debug per problema con scroll
                Log.d(LOG, c.getName() + " else onBind");
            }

        }

    }

    /*
    * @Override del metodo getItemCount
    * Implementazione obbligatoria per la classe
    *
    * */
    @Override
    public int getItemCount() {
        return mItems.size();
    }


    /*
    *
    * Classe statica ViewHolder
    * contiene gli elementi BOTTONE e TESTO del file Item.xml
    * permette l'uso di questi due elementi all'interno della classe
    *
    * @author RottenApple
    * @version 1.0
    */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nameTextView;
        public Button messageButton;

        //costruttore che collega gli elementi di Item.xml
        public ViewHolder(View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.text_item);
            messageButton = (Button) itemView.findViewById(R.id.button_item);
        }


    }
}