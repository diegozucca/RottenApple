package com.example.diego.rottenappledesign;

/*
 * Classe Adapter per la lista che verrà inserita nel REcyclerView
 * @author RottenApple
 * @version 1.0
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListItemViewHolder> {

    //Dati della lista che verrà visualizzata
    private List<ListData> list;

    public ListAdapter(List<ListData> list){
        this.list = list;
    }

    //Crea la grafica della riga facendo riferimento al layout di fragment_list_row
    public ListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewtype) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_list_row, parent, false);
        ListItemViewHolder vh = new ListItemViewHolder(view);
        return vh;
    }

    //Popola la riga creata col metodo precedente
    public void onBindViewHolder(ListItemViewHolder holder, int position) {
        holder.imageIcon.setImageResource(list.get(position).getmImageID());
        holder.title.setText(list.get(position).getTitle());
        holder.description.setText(list.get(position).getmDescription());
        holder.information.setText(list.get(position).getInformation());
    }

    //Restituisce la grandezza della lista
    public int getItemCount() {
        return list.size();
    }
}
