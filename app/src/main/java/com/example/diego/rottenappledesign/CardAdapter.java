package com.example.diego.rottenappledesign;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
/*
* Classe Adapter per le Cards che le costruisce e gestisce il comportamento di esse.
* @author RottenApple
* @version 1.0
*/
public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder>{
    private List<CardContent> mList;
    // Si da una reference alle View per ogni oggetto
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Si assegnano tutti i componenti utili
        public ImageView picture;
        public TextView title;
        public TextView subtitle;
        public Button expand_button;
        public TextView expand_text;
        public CardView card_view;
        final int[] minheight = new int[1];

        public ViewHolder(View v) {
            super(v);
            picture = (ImageView) v.findViewById(R.id.image);
            title = (TextView) v.findViewById(R.id.title);
            subtitle = (TextView) v.findViewById(R.id.subtitle);
            expand_button = (Button) v.findViewById(R.id.expand_button);
            expand_text=(TextView)v.findViewById(R.id.expand_text);
            card_view = (CardView) v.findViewById(R.id.card_view);

            // Misura l'altezza della card per poi espanderla o comprimerla
            Context context = v.getContext();
            WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            DisplayMetrics dimension = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(dimension);
            final int height = dimension.heightPixels;
            // Salva l'altezza minima della card
            card_view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                @Override
                public boolean onPreDraw() {
                    card_view.getViewTreeObserver().removeOnPreDrawListener(this);
                    minheight[0] = card_view.getHeight();
                    ViewGroup.LayoutParams layoutparams = card_view.getLayoutParams();
                    layoutparams.height = minheight[0];
                    card_view.setLayoutParams(layoutparams);
                    return true;
                }
            });
            // Quando viene premuto il bottone dell'espansione si gestisce l'evento con il metodo toggleHeight
            expand_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    toggleHeight(height);
                }
            });
        }

        // Se la card selezionata ha l'altezza minima si espande altrimenti si collassa
        private void toggleHeight(int height) {
            if (card_view.getHeight() == minheight[0])
                expand(height - 210);
            else
                collapse();
        }

        // Metodo che collassa le card già espanse
        public void collapse() {
            // Istanzio un ValueAnimator per animare la transizione dell'altezza della card
            ValueAnimator animator = ValueAnimator.ofInt(card_view.getMeasuredHeightAndState(), minheight[0]);
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnim) {
                    int val = (Integer) valueAnim.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = card_view.getLayoutParams();
                    layoutParams.height = val;
                    card_view.setLayoutParams(layoutParams);
                }
            });
            animator.start();
            // Modifica il testo visualizzato quando la card è espansa
            expand_text.setVisibility(View.GONE);
            expand_text.setHeight(0);
            expand_text.setPadding(0,0,0,0);
            expand_text.setTextSize(0);
            // Modifica il testo del bottone
            expand_button.setText("EXPANDE");
        }

        // Metodo che espande le Card
        public void expand(int height) {
            ValueAnimator animator = ValueAnimator.ofInt(card_view.getMeasuredHeightAndState(), height);
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnim) {
                    int val = (Integer) valueAnim.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = card_view.getLayoutParams();
                    layoutParams.height = val;
                    card_view.setLayoutParams(layoutParams);
                }
            });
            animator.start();
            expand_text.setVisibility(View.VISIBLE);
            expand_text.setHeight(height-minheight[0]);
            expand_text.setTextSize(14);
            expand_text.setText(R.string.testo_espanso);
            expand_text.setPadding(16,16,16,24);
            expand_button.setText("COLLAPSE");
        }

    }
    //Costruttore dell'adapter, prende come parametro la lista di oggetti
    public CardAdapter(List<CardContent> datalist) {
        mList =datalist;
    }

    // Metodo che crea nuove View, è invocato dal Layout Manager
    @Override
    public CardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewtype){
        // Si crea una nuova View, si istanzia e si ritorna
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_content,parent, false);
        ViewHolder vh=new ViewHolder(view);
        return vh;
    }

    // Metodo che setta il contenuto della card in base alla posizione nella lista degli oggetti
    @Override
    public void onBindViewHolder(final ViewHolder vh, int position){
        // Prende l'elemento dal dataset e mette il contenuto nei campi della card
        vh.picture.setImageResource(mList.get(position).getPhotoId());
        vh.title.setText(mList.get(position).getTitle());
        vh.subtitle.setText(mList.get(position).getSubtitle());
    }

    //Ritorna la grandezza della lista
    @Override
    public int getItemCount(){
        return mList.size();
    }
}

