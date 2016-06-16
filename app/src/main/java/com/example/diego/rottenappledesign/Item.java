package com.example.diego.rottenappledesign;

/*
*
* Classe di ausilio per la creazione della lista principale.
* Istanziata rappresenta un elemento della lista
*
* @author RottenApple
* @version 1.0
* */

import java.util.ArrayList;

public class Item {


    //definizione dei campi nome = contenuto dell'item e
    // newItem = booleano che indica se si tratta di un elemento nuovo per lo scroll o di un elemento "nativo" della lista
    // se l'elemento è nativo il valore è TRUE
    private String mNome;
    private boolean mNativeItem;

    //costruttore della classe item
    public Item(String name, boolean nw) {
        mNome = name;
        mNativeItem = nw;
    }

    /*
    *  createList(String[] material)
    * reicevendo un array di stringhe crea una lista di item
    * mette i primi 4 come non nuovi (nw=true)
    * i restanti servono per lo scroll
    *
    * */

    public static ArrayList<Item> createList(String[] material) {

        //lista di item (componenti della lista)
        ArrayList<Item> items = new ArrayList<Item>();

        //i primi 4 nativeItem= true ==> non nuovi per lo scroll
        int i;
        for (i = 0; i < 4; i++) {
            items.add(new Item(material[i], true));
        }


        i = 5;
        //i restanti elementi sono posti come elementi nativeItem=false ==> nuovi per lo scroll
        while (i < material.length && material[i] != null) {
            items.add(new Item(material[i], false));
            i++;
        }

        //restituisce la lista di item
        return items;
    }

    //restutuisce il nome dell'item della lista
    public String getName() {
        return mNome;
    }

    //restituisce se l'item fa parte dei nuovi inseriti senza bottone o dei primi
    public boolean isNotNew() {
        return mNativeItem;
    }
}