package com.italo.bitcoinbr.bitcoinbr.cache;

import android.app.Activity;
import android.content.SharedPreferences;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.italo.bitcoinbr.bitcoinbr.R;
import com.italo.bitcoinbr.bitcoinbr.models.Value;
import com.italo.bitcoinbr.bitcoinbr.service.ServerHandler;
import com.italo.bitcoinbr.bitcoinbr.uteis.Constants;
import com.italo.bitcoinbr.bitcoinbr.uteis.Uteis;

import java.io.IOException;

/**
 * Created by italo.josep on 05/04/2018.
 */

public class PreferenceHandler {

    public static SharedPreferences mSharedPreferences;


    public static void init (Activity main ){
        mSharedPreferences = main.getSharedPreferences(Constants.BITCOINBRPREF,0);
    }

    public static void saveTicker(Value value){
        try {
            String tickerJson;
            tickerJson = ServerHandler.getJsonConverter().writeValueAsString(value);
            SharedPreferences.Editor e = mSharedPreferences.edit();
            e.putString(Constants.TICKERBTC, tickerJson);
            e.apply();
            e.commit();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public static Value getTicker(){
        try {
            return ServerHandler.getJsonConverter().readValue(mSharedPreferences.getString(Constants.TICKERBTC,""), Value.class);
        } catch (IOException e) {
            Log.d("Error",e.getMessage().toString());
            return null;
        }
    }

    public static void saveDate(Spanned date){
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(String.valueOf(Constants.DATETICKER), String.valueOf(date));
        editor.apply();
        editor.commit();
    }

    public static String getDate(){
        return mSharedPreferences.getString(Constants.DATETICKER," ");
    }


}
