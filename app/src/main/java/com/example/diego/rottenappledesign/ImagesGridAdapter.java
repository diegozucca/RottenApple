package com.example.diego.rottenappledesign;


/*
*
* Classe adapter delle Immagini
* inizializza la GridView con le immagini servendosi dei due file activity_images.xml grid_item.xml
*
*
* @author RottenApple
* @version 1.0
* */


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;

public class ImagesGridAdapter extends BaseAdapter {


    //definizione dei valori
    //mItems punta ad una lista di ImageItem: classe statica definita infondo al file
    private final List<ImageItem> mItems = new ArrayList<ImageItem>();
    private final LayoutInflater mInflater;

    // costruttore inizializza, prendendo l'inflater dell'Activity, la lista di elementi (immagini) del mItems
    public ImagesGridAdapter(Context context) {
        mInflater = LayoutInflater.from(context);

        mItems.add(new ImageItem(R.drawable.beach));
        mItems.add(new ImageItem(R.drawable.beach1));
        mItems.add(new ImageItem(R.drawable.beach2));
        mItems.add(new ImageItem(R.drawable.beach3));
        mItems.add(new ImageItem(R.drawable.beach4));
        mItems.add(new ImageItem(R.drawable.beach));
        mItems.add(new ImageItem(R.drawable.beach1));
        mItems.add(new ImageItem(R.drawable.beach4));
        mItems.add(new ImageItem(R.drawable.beach3));
        mItems.add(new ImageItem(R.drawable.beach));
        mItems.add(new ImageItem(R.drawable.beach1));
        mItems.add(new ImageItem(R.drawable.beach4));
        mItems.add(new ImageItem(R.drawable.beach2));
        mItems.add(new ImageItem(R.drawable.beach3));
        mItems.add(new ImageItem(R.drawable.beach));
        mItems.add(new ImageItem(R.drawable.beach1));
        mItems.add(new ImageItem(R.drawable.beach4));
        mItems.add(new ImageItem(R.drawable.beach2));
        mItems.add(new ImageItem(R.drawable.beach));
        mItems.add(new ImageItem(R.drawable.beach1));
        mItems.add(new ImageItem(R.drawable.beach3));

    }


    //metodo obbligatorio: restituisce il numero di immagini
    @Override
    public int getCount() {
        return mItems.size();
    }

    //metodo obbligatorio: restituisce il l'Item alla posizione i della lista
    //metodo usato dal getView
    @Override
    public ImageItem getItem(int i) {
        return mItems.get(i);
    }

    //metodo obbligatorio: restituisce l'id dell'item alla posizione i
    @Override
    public long getItemId(int i) {
        return mItems.get(i).drawableId;
    }

    /*
    *
    * @Override del metodo getView
    *
    *
    * */
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        //si inizializza il view che contiene il grid_item
        View v = view;

        //imageView contenente il singolo elemento
        ImageView immagine;


        if (v == null) {//v non ancora inizializzato
            v = mInflater.inflate(R.layout.grid_item, viewGroup, false);
            v.setTag(R.id.imageItem, v.findViewById(R.id.imageItem));
        }

        //inizializzazione dell'immagine al elemento del file grid_item.xml
        immagine = (ImageView) v.getTag(R.id.imageItem);


        //recupera l'item e imposta l'immagine in base all'id
        ImageItem item = getItem(i);
        immagine.setImageResource(item.drawableId);

        return v;
    }


    /*
    *
    * Classe statica che descrive l'elemento della lista
    *
    *
    * @author RottenApple
    * @version 1.0
    * */
    private static class ImageItem {

        public final int drawableId;

        //costruttore inizializza l'id
        ImageItem( int drawableId) {

            this.drawableId = drawableId;
        }
    }
}