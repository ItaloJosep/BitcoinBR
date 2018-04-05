package com.italo.bitcoinbr.bitcoinbr.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.italo.bitcoinbr.bitcoinbr.Fragments.FragmentAlert;
import com.italo.bitcoinbr.bitcoinbr.Fragments.FragmentExchange;
import com.italo.bitcoinbr.bitcoinbr.Fragments.FragmentHome;
import com.italo.bitcoinbr.bitcoinbr.R;
import com.italo.bitcoinbr.bitcoinbr.cache.PreferenceHandler;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.frame_layout)
    FrameLayout frameLayout;
    @Bind(R.id.navigation)
    BottomNavigationView navigation;

    private FragmentHome homeFragment;
    private FragmentExchange exchangeFragment;
    private FragmentAlert alertFragment;

    private final int SELECTION_HOME = 0;
    private final int SELECTION_EXCHANGE = 1;
    private final int SELECTION_ALERT = 2;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    inicializaFragment(SELECTION_HOME);
                    return true;
                case R.id.navigation_dashboard:
                    inicializaFragment(SELECTION_EXCHANGE);
                    return true;
                case R.id.navigation_notifications:
                    inicializaFragment(SELECTION_ALERT);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        inicializaFragment(SELECTION_HOME);
        PreferenceHandler.init(this);
    }

    public void inicializaFragment(int selection){
        Fragment selectedFragment = null;
        selectedFragment = escolheFragmento(selection);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, selectedFragment);
        transaction.commit();
    }

    public Fragment escolheFragmento(int selection){
            if(SELECTION_HOME == selection){
                if(homeFragment == null)
                    homeFragment = FragmentHome.newInstance();
                return homeFragment;
            }else if(SELECTION_EXCHANGE == selection) {
                if (exchangeFragment == null)
                    exchangeFragment = FragmentExchange.newInstance();
                return exchangeFragment;
            }else if(SELECTION_ALERT == selection) {
                if (alertFragment == null)
                    alertFragment = FragmentAlert.newInstance();
                return alertFragment;
            }
        return null;
    }

}
