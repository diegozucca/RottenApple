package com.example.diego.rottenappledesign;

/*
 * Activity contente i FragmentTabs
 * @author RottenApple
 * @version 1.0
 */

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class TabsActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);
        //Aggiungo la Toolbar alla schermata princiaple
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Imposto il ViewPager per ogni Tab; questa sarà ciò che farà muovere i tabs
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        //Collego i TabLayout al ViewPager
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        //Imposto il Tab Image come tab iniziale
        viewPager.setCurrentItem(1);
    }

    //Aggiungo i Fragment ai Tab
    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getSupportFragmentManager());
        adapter.addFragment(new ListFragment(), "List");
        adapter.addFragment(new ImageFragment(), "Image");
        adapter.addFragment(new CardFragment(), "Card");
        viewPager.setAdapter(adapter);
    }

    //Creo l'Adapter per i Fragment/Tabs da aggiungere alla ViewPager
    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager manager) {
            super(manager);
        }

        //Restituisce il Fragment della posizione data
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        //Restituisce il numero totali di Fragment memorizzati
        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        //Restituisce il nome del Fragment
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
