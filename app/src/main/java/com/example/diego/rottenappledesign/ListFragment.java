package com.example.diego.rottenappledesign;

/*
 * Activity contente una lista
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

public class ListFragment extends Fragment {

    //Dichiarazione dei dati che andranno a popolare la lista
    private List<ListData> mItemsList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Richiamo dell'elemnento RecyclerView che andrà a gestire la lista
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_list, container, false);

        //Creazione di un LayoutManager, che andrà a gestire in maniera autonoma il layout del
        //RecyclerView
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(llm);

        //Riempio la lista
        mItemsList = fill_List();

        //Creo l'adapter da passare al REcyclerView e gli passo la lista appena creata
        ListAdapter adapter = new ListAdapter(mItemsList);
        recyclerView.setAdapter(adapter);

        //Restituisco la View recyclerView che andrà a inizializzare la nostra UI
        return recyclerView;
    }

    //Metodo ausiliaro per il popolamento della lista
    protected List<ListData> fill_List(){

        List<ListData> tmp = new ArrayList<ListData>();

        Resources res = getResources();
        String[] itemList = res.getStringArray(R.array.list);

        for(int i=0; i<25;i++){
            tmp.add(new ListData(R.drawable.ic_account_circle,itemList[0]+" "+(i+1),itemList[1], itemList[2]));
        }

        return tmp;
    }

}
