package com.example.diego.rottenappledesign;



/*
*
* Classe che descrive il comportamento del FAB di ButtonActivity
* Con lo scroll esegue l'hide e lo show del bottone
*
* @author RottenApple
* @version 1.0
* */


import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class ScrollRotten extends FloatingActionButton.Behavior  {

    //log del debug per lo scroll ==> errore non riconducibile a tale classe
    private static final String LOG = ButtonActivity.class.getSimpleName();


    //costruttore: chiama il costruttore della classe padre
    public ScrollRotten(Context context, AttributeSet attrs) {
        super();
    }


    /*
    * @Override del metodo onStartNestedScroll
    * restituisce un booleano che indica se lo scroll ricevuto come parametro i di ingresso Scoll
    * è uguale al valore dello scroll generale. Per verificare la correttezza di tale valore
    * fa eseguire lo stesso controllo al metodo padre e verifica il risultato
    *
    *
    * */
    @Override
    public boolean onStartNestedScroll(CoordinatorLayout c, FloatingActionButton FAB, View figlioDiretto, View target, int i) {

        //debug per lo scroll ==> errore non riconducibile a tale classe
        Log.d(LOG,"Scroll ==> onStartNestedScroll");

        return i == ViewCompat.SCROLL_AXIS_VERTICAL || super.onStartNestedScroll(c, FAB, figlioDiretto, target,i);



    }

    /*
    * @Override del metodo onBestedScroll
    * riceve come parametri il Coordinator Layout dove il FAB è contenuto, il FAB
    * e le dimensioni in int sullo scroll CONSUMED (verso il baso)
    * e quelle, sempre in int, sullo scroll Unconsumed (verso l'alto)
    *  tale metodo è chiamato ogni volta che si ha uno scroll
    * */
    @Override
    public void onNestedScroll(CoordinatorLayout c, FloatingActionButton FAB, View target, int dxGiu, int dyGiu, int dxSu, int dySu) {
        super.onNestedScroll(c, FAB, target, dxGiu, dyGiu, dxSu, dySu);

        //scroll verso il basso con FAB visibile
        if ((dyGiu > 0 ) && (FAB.getVisibility() == View.VISIBLE)) {
            FAB.hide();

        } else
           //scroll verso l'alto con il fab non visibile
           if ((dyGiu < 0) && (FAB.getVisibility() != View.VISIBLE)) {
            FAB.show();
        }

        //debug per lo scroll ==> errore non riconducibile a tale classe
        Log.d(LOG,"Scroll==> oNestedScroll");
    }

}