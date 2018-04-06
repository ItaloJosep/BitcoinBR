package com.italo.bitcoinbr.bitcoinbr.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.preference.Preference;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.italo.bitcoinbr.bitcoinbr.R;
import com.italo.bitcoinbr.bitcoinbr.cache.PreferenceHandler;
import com.italo.bitcoinbr.bitcoinbr.models.ItemTickerList;
import com.italo.bitcoinbr.bitcoinbr.models.Value;
import com.italo.bitcoinbr.bitcoinbr.service.BaseCallback;
import com.italo.bitcoinbr.bitcoinbr.service.ServerHandler;
import com.italo.bitcoinbr.bitcoinbr.uteis.GenerateList;
import com.italo.bitcoinbr.bitcoinbr.uteis.Uteis;

import java.util.Date;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Call;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by italojosep on 25/03/18.
 */

public class FragmentHome extends Fragment {

    @Bind(R.id.value_btc)
    TextView valueBtc;
    @Bind(R.id.value_high)
    TextView valueHigh;
    @Bind(R.id.value_low)
    TextView valueLow;
    @Bind(R.id.vol_btc)
    TextView volBtc;
    @Bind(R.id.card_view)
    CardView cardView;
    @Bind(R.id.text_date)
    TextView date;
    @Bind(R.id.card_view_buy)
    CardView cardViewBuy;
    @Bind(R.id.card_view_sell)
    CardView cardViewSell;
    @Bind(R.id.value_best_sell)
    TextView valueBestSell;
    @Bind(R.id.vol_best_sell)
    TextView volBestSell;
    @Bind(R.id.value_best_buy)
    TextView valueBestBuy;
    @Bind(R.id.vol_best_buy)
    TextView volBestBuy;
    @Bind(R.id.name_exchange_buy)
    TextView exchangeBuy;
    @Bind(R.id.name_exchange_sell)
    TextView exchangeSell;
    @Bind(R.id.swiperefresh)
    SwipeRefreshLayout swipeRefreshLayout;

    private ProgressBar progressBar;
    public static FragmentHome newInstance() {
        FragmentHome fragment = new FragmentHome();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);

        progressBar = (ProgressBar) view.findViewById(R.id.progressbar);

        swipeRefreshLayout.setColorSchemeResources(R.color.background);
        swipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        getTicker();
                    }
                }
        );

        getTicker();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        if(PreferenceHandler.getTicker()!=null){
            setText(PreferenceHandler.getTicker());
        }

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
                   PreferenceHandler.saveTicker(response.body());
                   PreferenceHandler.saveDate(Html.fromHtml(String.format(getContext().getString(R.string.label_date_value), Uteis.gereData(), Uteis.getHour())));
                   setText(response.body());
                   setBestSell(response.body());
                   setBestBuy(response.body());
               }else{
                   Uteis.showSnackbar(getContext(),getString(R.string.erro_conection));
                   if(PreferenceHandler.getTicker()!=null)
                       setText(PreferenceHandler.getTicker());
               }
            }
            @Override
            public void onFailure(Throwable t) {
                stop();
                Uteis.showSnackbar(getContext(),getString(R.string.erro_conection));
                if(PreferenceHandler.getTicker()!=null)
                setText(PreferenceHandler.getTicker());
            }
        });
    }

    public void setText(Value value){
        valueBtc.setText(Uteis.FormatMoney(value.getTicker24().getTotal().getLast()));
        valueHigh.setText(Uteis.FormatMoney(value.getTicker24().getTotal().getHigh()));
        valueLow.setText(Uteis.FormatMoney(value.getTicker24().getTotal().getLow()));
        volBtc.setText(Uteis.FormatVol(value.getTicker24().getTotal().getVol()));
        date.setText(PreferenceHandler.getDate());
    }

    public void setBestSell(Value value){
        List<ItemTickerList> itemTicker = GenerateList.GenerateListTicker24(value);

        double high =-1;
        ItemTickerList itemHigh =null;

        for (ItemTickerList item: itemTicker) {
            if(high == -1){
                high = Double.parseDouble(item.getLast());
                itemHigh = item;
            }else if(high< Double.parseDouble(item.getLast())){
                high = Double.parseDouble(item.getLast());
                itemHigh = item;
            }
        }
        valueBestSell.setText(Uteis.FormatMoney(itemHigh.getLast()));
        volBestSell.setText(Uteis.FormatVol(itemHigh.getVol()));
        exchangeSell.setText(itemHigh.getExchange());
    }

    public void setBestBuy(Value value){
        List<ItemTickerList> itemTicker = GenerateList.GenerateListTicker24(value);

        double low =-1;
        ItemTickerList itemLow =null;

        for (ItemTickerList item: itemTicker) {
            if(low == -1){
                low = Double.parseDouble(item.getLast());
                itemLow = item;
            }else if(low > Double.parseDouble(item.getLast())){
                low = Double.parseDouble(item.getLast());
                itemLow = item;
            }
        }
        valueBestBuy.setText(Uteis.FormatMoney(itemLow.getLast()));
        volBestBuy.setText(Uteis.FormatVol(itemLow.getVol()));
        exchangeBuy.setText(itemLow.getExchange());
    }

    public void start(){
        cardView.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        cardViewBuy.setVisibility(View.GONE);
        cardViewSell.setVisibility(View.GONE);
        swipeRefreshLayout.setRefreshing(false);
    }

    public void stop(){
        cardView.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
        cardViewBuy.setVisibility(View.VISIBLE);
        cardViewSell.setVisibility(View.VISIBLE);
        swipeRefreshLayout.setRefreshing(false);
    }
}
