package com.italo.bitcoinbr.bitcoinbr.service;

import com.italo.bitcoinbr.bitcoinbr.models.Coins;
import com.italo.bitcoinbr.bitcoinbr.models.Value;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by italo.josep on 05/04/2018.
 */

public interface ServiceBitcoin {

        @GET("ticker.json")
        Call<Value> getValues();

        @GET("ticker.json")
        Call<List<Coins>> getValues1();
}
