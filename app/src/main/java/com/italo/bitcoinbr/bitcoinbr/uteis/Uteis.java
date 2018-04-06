package com.italo.bitcoinbr.bitcoinbr.uteis;

import android.annotation.SuppressLint;
import android.content.Context;
import android.icu.text.DecimalFormat;
import android.icu.text.NumberFormat;

import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;
import com.nispok.snackbar.enums.SnackbarType;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by italo.josep on 05/04/2018.
 */

public class Uteis {

    @SuppressLint("NewApi")
    public static String FormatMoney(String money){
        double moneyDouble = Double.parseDouble(money);
        String currency = "R$ ";
//        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        money = currency.concat(decimalFormat.format(moneyDouble));
        return money;
    }

    public static void showSnackbar(Context context, String message){
        SnackbarManager.show(
                Snackbar.with(context)
                        .type(SnackbarType.MULTI_LINE)
                        .text(message));
    }

    @SuppressLint("NewApi")
    public static String FormatVol(String vol){
        double volDouble = Double.parseDouble(vol);
//        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        DecimalFormat decimalFormat = new DecimalFormat("#.#####");
        vol = decimalFormat.format(volDouble);
        return vol;
    }

    public static String gereData(){
        Calendar cal = Calendar.getInstance();
        Date currentDate = cal.getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDateString = dateFormat.format(currentDate);
        return formattedDateString;
    }

    public static String getHour(){
        Calendar cal = Calendar.getInstance();
        Date currentDate = cal.getTime();
        DateFormat hourFormat = new SimpleDateFormat("HH:mm");
        String hour = hourFormat.format(currentDate);
        return hour;
    }
}
