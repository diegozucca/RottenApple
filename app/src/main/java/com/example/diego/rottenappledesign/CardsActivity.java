package com.example.diego.rottenappledesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CardsActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    //private String[] myDataset= {"Prima Card","Seconda Card","Terza Card","Quarta Card","Quinta Card"};
    private List<CardContent> mDataset;
    private int[] images={
            R.drawable.beach,R.drawable.beach1,R.drawable.beach2,R.drawable.beach3,R.drawable.beach4,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);
        //start test
        mDataset=new ArrayList<CardContent>();
        String [] primary_text={"Titolo Prima Card","Titolo Seconda Card","Titolo Terza Card",
                "Titolo Quarta Card","Titolo Quinta Card"};
        String [] subtitle={"Sottotitolo Prima Card","Sottotitolo Seconda Card","Sottotitolo Terza Card",
                "Sottotitolo Quarta Card","Sottotitolo Quinta Card"};
        for (int i = 0; i < primary_text.length; i++) {
            CardContent oggetto=new CardContent(images[i],primary_text[i],subtitle[i]);
            mDataset.add(oggetto);
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new CardAdapter(mDataset);
        mRecyclerView.setAdapter(mAdapter);
    }
}
