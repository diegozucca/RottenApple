package com.example.diego.rottenappledesign;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by marco on 11/05/2016.
 */
public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder>{
    private List<CardContent> list;
    // gives a reference to the views for every data item
    public static class ViewHolder extends RecyclerView.ViewHolder {
        //si assegnano tutti i componenti utili
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
            //misuriamo l'altezza della card per poi espanderla o comprimerla
            Context context = v.getContext();
            WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            DisplayMetrics dimension = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(dimension);
            final int height = dimension.heightPixels;
            //salviamo l'altezza minima della card
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
            expand_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    toggleHeight(height);
                }
            });
        }

        private void toggleHeight(int height) {
            if (card_view.getHeight() == minheight[0])
                //expand
                expand(height - 210);
            else
                //collapse
                collapse();
        }

        public void collapse() {
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
            expand_text.setVisibility(View.GONE);
            expand_text.setHeight(0);
            expand_text.setPadding(0,0,0,0);
            expand_text.setTextSize(0);
            expand_button.setText("EXPANDE");
        }

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
            expand_text.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                    "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam," +
                    " quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute " +
                    "irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur." +
                    " Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim " +
                    "id est laborum.");
            expand_text.setPadding(16,16,16,24);
            expand_button.setText("COLLAPSE");
        }

    }
    //Costruttore dell'adapter, prende come parametro la lista di oggetti
    public CardAdapter(List<CardContent> datalist) {
        list=datalist;
    }
    //Create new views, invoked by the layout manager
    @Override
    public CardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewtype){
        //Si crea una nuova View, si istanzia e si ritorna
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_content,parent, false);
        ViewHolder vh=new ViewHolder(view);
        return vh;
    }
    //onBindViewHolder setta il contenuto della card in base alla posizione nella lista degli oggetti
    @Override
    public void onBindViewHolder(final ViewHolder vh, int position){
        //get the element from dataset and replace the contents
        vh.picture.setImageResource(list.get(position).getPhotoId());
        vh.title.setText(list.get(position).getTitle());
        vh.subtitle.setText(list.get(position).getSubtitle());
    }
    //Ritorna la grandezza della lista
    @Override
    public int getItemCount(){
        return list.size();
    }
}

