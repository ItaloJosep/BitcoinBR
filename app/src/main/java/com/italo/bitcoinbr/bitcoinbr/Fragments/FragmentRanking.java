package com.italo.bitcoinbr.bitcoinbr.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.italo.bitcoinbr.bitcoinbr.R;
import com.italo.bitcoinbr.bitcoinbr.adapter.adapterCoin;
import com.italo.bitcoinbr.bitcoinbr.adapter.adapterExchange;
import com.italo.bitcoinbr.bitcoinbr.models.Coins;
import com.italo.bitcoinbr.bitcoinbr.models.ItemTickerList;
import com.italo.bitcoinbr.bitcoinbr.models.Value;
import com.italo.bitcoinbr.bitcoinbr.service.BaseCallback;
import com.italo.bitcoinbr.bitcoinbr.service.ServerHandler;
import com.italo.bitcoinbr.bitcoinbr.uteis.GenerateList;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Call;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by italo.josep on 10/04/2018.
 */

public class FragmentRanking extends Fragment {

    @Bind(R.id.list_coins)
    RecyclerView listCoins;
    @Bind(R.id.swiperefresh)
    SwipeRefreshLayout swipeRefreshLayout;

    private LinearLayoutManager linearLayoutManager;
    private ProgressBar progressBar;
    private adapterCoin adapter;

    public  static  FragmentRanking newInstance() {
        Bundle args = new Bundle();
        FragmentRanking fragment = new FragmentRanking();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ranking,container,false);
        ButterKnife.bind(this,view);

        swipeRefreshLayout.setColorSchemeResources(R.color.background);
        swipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        getTicker();
                    }
                }
        );

        adapter = new adapterCoin(new ArrayList<Coins>(), getContext()) {
            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {

            }
        };

        listCoins.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(this.getActivity());
        listCoins.setLayoutManager(linearLayoutManager);
        listCoins.setAdapter(adapter);

        progressBar = (ProgressBar) view.findViewById(R.id.progressbar);
        return view;
    }

    public void getTicker(){

        Call<List<Coins>> valueCall = ServerHandler.getApiInstanceCoins().getCoins("100","BRL");
        valueCall.enqueue(new BaseCallback<List<Coins>>() {
            @SuppressLint("StringFormatMatches")
            @Override
            public void onResponse(Response<List<Coins>> response, Retrofit retrofit) {

                if(response.body()!=null) {
                    adapter.setListCoin(response.body());
                }

            }
            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(getContext(), "ERRO", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
