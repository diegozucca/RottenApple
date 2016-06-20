package com.example.diego.rottenappledesign;

/*
 * Activity contente le cards che descrivono i componenti del progetto
 * @author RottenApple
 * @version 1.0
 */

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class CardFragment extends Fragment {

    //Dichiarazione delle variabili globali
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<CardContent> mDataset;
    private int[] mImages = {
            R.drawable.diego,
            R.drawable.marco,
            R.drawable.simone
    };
    private String [] mPrimary_text ={"Diego Zucca","Marco Spiandore","Simone Boscolo"};
    private String [] mSubtitle ={"Sviluppatore FAB","Sviluppatore Cards",
            "Sviluppatore Tabs"};
    private String [] mBoxText = {"Bello e impossibile","Il bravo ragazzo","L' afffffamato"};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        /*
         *Inizio del codice per le Cards
         */
        // Si crea un ArrayList di oggetti CardContent e si inizializzano con
        // i valori degli array specificati in precedenza
        mDataset=new ArrayList<CardContent>();

        Resources resources = getResources();
        String [] descrizioni = resources.getStringArray(R.array.descrizione_sviluppatori);

        for (int i = 0; i < mPrimary_text.length; i++) {
            CardContent oggetto=new CardContent(mImages[i], mPrimary_text[i], mSubtitle[i],descrizioni[i],mBoxText[i]);
            mDataset.add(oggetto);
        }

        mRecyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_cards, container, false);

        // Uso un Layout Manager per il Recycler View
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // Si usa un Adapter specificato nella classe CardAdapter che ha come parametro l'ArrayList
        // Con l'Adapter si gesticono tutte le azioni delle Cards
        mAdapter = new TabsCardAdapter(mDataset);
        mRecyclerView.setAdapter(mAdapter);

        //restituisco la View mRecyclerView che andrà a inizializzare la nostra UI
        return mRecyclerView;
    }

}