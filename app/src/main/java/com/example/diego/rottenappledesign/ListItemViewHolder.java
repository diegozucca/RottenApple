package com.example.diego.rottenappledesign;

/*
 * Classe che andrà a memorizzare le Views di ogni riga
 * @author RottenApple
 * @version 1.0
 */

import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ListItemViewHolder extends RecyclerView.ViewHolder {

    //Elementi che costituiscono la riga
    ImageView imageIcon;
    TextView title;
    TextView description;
    ImageButton infoButton;
    TextView information;

    //Costruttore del layout della riga, vengono istanziate tutte le View della riga
    public ListItemViewHolder(View view){
        super(view);
        imageIcon = (ImageView) view.findViewById(R.id.ic_image_item_list);
        title = (TextView) view.findViewById(R.id.text_title_item_list);
        description = (TextView) view.findViewById(R.id.text_description_item_list);
        infoButton = (ImageButton) view.findViewById(R.id.button_ic_info_item_list);
        information = (TextView) view.findViewById(R.id.text_information_item_list);

        //ClickListener dell bottone-icona; lancia un Dialog dove visualizza altre info riguardanti
        //l'elemento della lista selezionato
        infoButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                    builder.setTitle(title.getText());
                    builder.setMessage(information.getText());
                    builder.show();
            }
        });
    }
}
