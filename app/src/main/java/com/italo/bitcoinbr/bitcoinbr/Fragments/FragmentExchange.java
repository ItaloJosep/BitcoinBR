package com.italo.bitcoinbr.bitcoinbr.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.italo.bitcoinbr.bitcoinbr.R;
import com.italo.bitcoinbr.bitcoinbr.adapter.adapterExchange;
import com.italo.bitcoinbr.bitcoinbr.cache.PreferenceHandler;
import com.italo.bitcoinbr.bitcoinbr.models.ItemTickerList;
import com.italo.bitcoinbr.bitcoinbr.models.Value;
import com.italo.bitcoinbr.bitcoinbr.service.BaseCallback;
import com.italo.bitcoinbr.bitcoinbr.service.ServerHandler;
import com.italo.bitcoinbr.bitcoinbr.uteis.GenerateList;
import com.italo.bitcoinbr.bitcoinbr.uteis.Uteis;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Call;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by italojosep on 25/03/18.
 */

public class FragmentExchange extends Fragment {

    @Bind(R.id.list_exchange)
    RecyclerView listExchange;
    @Bind(R.id.empty_exchange)
    RelativeLayout emptyExchange;
    @Bind(R.id.swiperefresh)
    SwipeRefreshLayout swipeRefreshLayout;

    private adapterExchange  adapter;
    private ProgressBar progressBar;
    private LinearLayoutManager linearLayoutManager;

    public static FragmentExchange newInstance(){
        FragmentExchange fragmentExchange = new FragmentExchange();
        return fragmentExchange;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exchange,container, false);
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

        adapter = new adapterExchange(getActivity(), new ArrayList<ItemTickerList>());
        listExchange.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(this.getActivity());
        listExchange.setLayoutManager(linearLayoutManager);
        listExchange.setAdapter(adapter);

        progressBar = (ProgressBar) view.findViewById(R.id.progressbar);

        getTicker();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    public void getTicker(){
        start();
        Call<Value> valueCall = ServerHandler.getApiInstance().getValues();
        valueCall.enqueue(new BaseCallback<Value>() {
            @SuppressLint("StringFormatMatches")
            @Override
            public void onResponse(Response<Value> response, Retrofit retrofit) {
                stop();
                if(response.body()!=null) {
                    adapter.setListExchange(GenerateList.GenerateListTicker24(response.body()));
                    emptyExchange.setVisibility(View.GONE);
                }else {
                    emptyExchange.setVisibility(View.VISIBLE);
                }

            }
            @Override
            public void onFailure(Throwable t) {
                stop();
                emptyExchange.setVisibility(View.VISIBLE);

            }
        });
    }

    public void start(){
        progressBar.setVisibility(View.VISIBLE);
        listExchange.setVisibility(View.GONE);
        swipeRefreshLayout.setRefreshing(false);

    }

    public void stop(){
        progressBar.setVisibility(View.GONE);
        listExchange.setVisibility(View.VISIBLE);
        swipeRefreshLayout.setRefreshing(false);
    }
}
