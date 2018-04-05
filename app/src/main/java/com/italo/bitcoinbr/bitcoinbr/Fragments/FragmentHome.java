package com.italo.bitcoinbr.bitcoinbr.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.preference.Preference;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.italo.bitcoinbr.bitcoinbr.R;
import com.italo.bitcoinbr.bitcoinbr.cache.PreferenceHandler;
import com.italo.bitcoinbr.bitcoinbr.models.Value;
import com.italo.bitcoinbr.bitcoinbr.service.BaseCallback;
import com.italo.bitcoinbr.bitcoinbr.service.ServerHandler;
import com.italo.bitcoinbr.bitcoinbr.uteis.Uteis;

import java.util.Date;

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

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        getTicker();
    }

    public void getTicker(){
        start();
        Call<Value> valueCall = ServerHandler.getApiInstance().getValues();
        valueCall.enqueue(new BaseCallback<Value>() {
            @SuppressLint("StringFormatMatches")
            @Override
            public void onResponse(Response<Value> response, Retrofit retrofit) {
               stop();
                PreferenceHandler.saveTicker(response.body());
                PreferenceHandler.saveDate(Html.fromHtml(String.format(getContext().getString(R.string.label_date_value), Uteis.gereData(), Uteis.getHour())));
                setText(response.body());
            }
            @Override
            public void onFailure(Throwable t) {
                stop();
                Uteis.showSnackbar(getContext(),getString(R.string.erro_conection));
                setText(PreferenceHandler.getTicker());
            }
        });
    }

    public void setText(Value value){
        valueBtc.setText(Uteis.FormatMoney(value.getTicker24().getTotal().getLast()));
        valueHigh.setText(Uteis.FormatMoney(value.getTicker24().getTotal().getHigh()));
        valueLow.setText(Uteis.FormatMoney(value.getTicker24().getTotal().getLow()));
        volBtc.setText(value.getTicker24().getTotal().getVol());
        date.setText(PreferenceHandler.getDate());
    }


    @OnClick(R.id.card_view) void clickCard(){
        getTicker();
    }

    public void start(){
        cardView.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
    }

    public void stop(){
        cardView.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }
}
