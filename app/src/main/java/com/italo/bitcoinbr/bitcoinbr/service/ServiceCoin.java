package com.italo.bitcoinbr.bitcoinbr.service;

import com.italo.bitcoinbr.bitcoinbr.models.Coins;


import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by italo.josep on 10/04/2018.
 */

public interface ServiceCoin {

    @GET("ticker/")
    Call<List<Coins>> getCoins(
            @Query("limit") String limit,
            @Query("convert") String convert);

}
