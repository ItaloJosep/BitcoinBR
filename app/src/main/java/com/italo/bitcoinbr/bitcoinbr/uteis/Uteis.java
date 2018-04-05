package com.italo.bitcoinbr.bitcoinbr.uteis;

import android.annotation.SuppressLint;
import android.icu.text.DecimalFormat;
import android.icu.text.NumberFormat;

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
}
