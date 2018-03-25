package com.italo.bitcoinbr.bitcoinbr.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.italo.bitcoinbr.bitcoinbr.R;

import butterknife.ButterKnife;

/**
 * Created by italojosep on 25/03/18.
 */

public class FragmentAlert extends Fragment {

    public static FragmentAlert newInstance(){
        FragmentAlert fragmentAlert = new FragmentAlert();
        return fragmentAlert;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alet, container, false);
        ButterKnife.bind(this, view);

        return view;
    }
}
