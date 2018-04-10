package com.italo.bitcoinbr.bitcoinbr.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import retrofit.JacksonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by italo.josep on 05/04/2018.
 */

public class ServerHandler {

    public static ServiceBitcoin nstaApiInstance = null;
    public static ServiceCoin nstaApiInstanceCoins = null;
    private static ObjectMapper mapper;

    public static ServiceBitcoin getApiInstance() {
        if (nstaApiInstance == null) {
            OkHttpClient client = new OkHttpClient();
            client.networkInterceptors().add(HeaderHandler.getApiHeaderInstance());
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            client.interceptors().add(interceptor);

            Retrofit retrofit = new Retrofit.Builder()
//                    .baseUrl(BuildConfig.DEBUG ? Constants.URL_STAGING : Constants.URL_PRODUCTION).client(client)
                    .baseUrl("https://api.bitvalor.com/v1/").client(client)
                    .addConverterFactory(JacksonConverterFactory.create(getJsonConverter()))
                    .build();
            nstaApiInstance = retrofit.create(ServiceBitcoin.class);
        }
        return nstaApiInstance;
    }

    public static ServiceCoin getApiInstanceCoins() {
        if (nstaApiInstanceCoins == null) {
            OkHttpClient client = new OkHttpClient();
            client.networkInterceptors().add(HeaderHandler.getApiHeaderInstance());
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            client.interceptors().add(interceptor);

            Retrofit retrofit = new Retrofit.Builder()
//                    .baseUrl(BuildConfig.DEBUG ? Constants.URL_STAGING : Constants.URL_PRODUCTION).client(client)
                    .baseUrl("https://api.coinmarketcap.com/v1/").client(client)
                    .addConverterFactory(JacksonConverterFactory.create(getJsonConverter()))
                    .build();
            nstaApiInstanceCoins = retrofit.create(ServiceCoin.class);
        }
        return nstaApiInstanceCoins;
    }



    public static ObjectMapper getJsonConverter() {
        if (mapper == null) {
            mapper = new ObjectMapper()
                    .registerModule(new JodaModule())
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                    .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        }
        return mapper;
    }
}
