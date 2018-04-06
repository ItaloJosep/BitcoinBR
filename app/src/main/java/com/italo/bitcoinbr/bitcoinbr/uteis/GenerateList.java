package com.italo.bitcoinbr.bitcoinbr.uteis;

import com.italo.bitcoinbr.bitcoinbr.models.ItemTickerList;
import com.italo.bitcoinbr.bitcoinbr.models.Value;
import com.italo.bitcoinbr.bitcoinbr.models.ValueTicker;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by italo.josep on 05/04/2018.
 */

public class GenerateList {
    
    public static List<ItemTickerList> GenerateListTicker24(Value value){
        List<ItemTickerList> listTicker = new ArrayList<>();
//      LOC;
        ItemTickerList LOC = new ItemTickerList();
        LOC.setExchange(Constants.LOC);
        LOC.setHigh(value.getTicker24().getExchanges().getLOC().getHigh());
        LOC.setLast(value.getTicker24().getExchanges().getLOC().getLast());
        LOC.setLow(value.getTicker24().getExchanges().getLOC().getLow());
        LOC.setMoney(value.getTicker24().getExchanges().getLOC().getMoney());
        LOC.setTrades(value.getTicker24().getExchanges().getLOC().getTrades());
        LOC.setVol(value.getTicker24().getExchanges().getLOC().getVol());
        LOC.setVwap(value.getTicker24().getExchanges().getLOC().getVwap());
        listTicker.add(LOC);
        
//      B2U;
        ItemTickerList B2U = new ItemTickerList();
        B2U.setExchange(Constants.B2U);
        B2U.setHigh(value.getTicker24().getExchanges().getB2U().getHigh());
        B2U.setLast(value.getTicker24().getExchanges().getB2U().getLast());
        B2U.setLow(value.getTicker24().getExchanges().getB2U().getLow());
        B2U.setMoney(value.getTicker24().getExchanges().getB2U().getMoney());
        B2U.setTrades(value.getTicker24().getExchanges().getB2U().getTrades());
        B2U.setVol(value.getTicker24().getExchanges().getB2U().getVol());
        B2U.setVwap(value.getTicker24().getExchanges().getB2U().getVwap());
        listTicker.add(B2U);
        
//      NEG;
        ItemTickerList NEG = new ItemTickerList();
        NEG.setExchange(Constants.NEG);
        NEG.setHigh(value.getTicker24().getExchanges().getNEG().getHigh());
        NEG.setLast(value.getTicker24().getExchanges().getNEG().getLast());
        NEG.setLow(value.getTicker24().getExchanges().getNEG().getLow());
        NEG.setMoney(value.getTicker24().getExchanges().getNEG().getMoney());
        NEG.setTrades(value.getTicker24().getExchanges().getNEG().getTrades());
        NEG.setVol(value.getTicker24().getExchanges().getNEG().getVol());
        NEG.setVwap(value.getTicker24().getExchanges().getNEG().getVwap());
        listTicker.add(NEG);
        
//      FOX;
        ItemTickerList FOX = new ItemTickerList();
        FOX.setExchange(Constants.FOX);
        FOX.setHigh(value.getTicker24().getExchanges().getFOX().getHigh());
        FOX.setLast(value.getTicker24().getExchanges().getFOX().getLast());
        FOX.setLow(value.getTicker24().getExchanges().getFOX().getLow());
        FOX.setMoney(value.getTicker24().getExchanges().getFOX().getMoney());
        FOX.setTrades(value.getTicker24().getExchanges().getFOX().getTrades());
        FOX.setVol(value.getTicker24().getExchanges().getFOX().getVol());
        FOX.setVwap(value.getTicker24().getExchanges().getFOX().getVwap());
        listTicker.add(FOX);
        
//      BZX;
        ItemTickerList BZX = new ItemTickerList();
        BZX.setExchange(Constants.BZX);
        BZX.setHigh(value.getTicker24().getExchanges().getBZX().getHigh());
        BZX.setLast(value.getTicker24().getExchanges().getBZX().getLast());
        BZX.setLow(value.getTicker24().getExchanges().getBZX().getLow());
        BZX.setMoney(value.getTicker24().getExchanges().getBZX().getMoney());
        BZX.setTrades(value.getTicker24().getExchanges().getBZX().getTrades());
        BZX.setVol(value.getTicker24().getExchanges().getBZX().getVol());
        BZX.setVwap(value.getTicker24().getExchanges().getBZX().getVwap());
        listTicker.add(BZX);
        
//      BTD;
        ItemTickerList BTD = new ItemTickerList();
        BTD.setExchange(Constants.BTD);
        BTD.setHigh(value.getTicker24().getExchanges().getBTD().getHigh());
        BTD.setLast(value.getTicker24().getExchanges().getBTD().getLast());
        BTD.setLow(value.getTicker24().getExchanges().getBTD().getLow());
        BTD.setMoney(value.getTicker24().getExchanges().getBTD().getMoney());
        BTD.setTrades(value.getTicker24().getExchanges().getBTD().getTrades());
        BTD.setVol(value.getTicker24().getExchanges().getBTD().getVol());
        BTD.setVwap(value.getTicker24().getExchanges().getBTD().getVwap());
        listTicker.add(BTD);
        
//      MBT;
        ItemTickerList MBT = new ItemTickerList();
        MBT.setExchange(Constants.MBT);
        MBT.setHigh(value.getTicker24().getExchanges().getMBT().getHigh());
        MBT.setLast(value.getTicker24().getExchanges().getMBT().getLast());
        MBT.setLow(value.getTicker24().getExchanges().getMBT().getLow());
        MBT.setMoney(value.getTicker24().getExchanges().getMBT().getMoney());
        MBT.setTrades(value.getTicker24().getExchanges().getMBT().getTrades());
        MBT.setVol(value.getTicker24().getExchanges().getMBT().getVol());
        MBT.setVwap(value.getTicker24().getExchanges().getMBT().getVwap());
        listTicker.add(MBT);
        
//      FLW;
        ItemTickerList FLW = new ItemTickerList();
        FLW.setExchange(Constants.FLW);
        FLW.setHigh(value.getTicker24().getExchanges().getFLW().getHigh());
        FLW.setLast(value.getTicker24().getExchanges().getFLW().getLast());
        FLW.setLow(value.getTicker24().getExchanges().getFLW().getLow());
        FLW.setMoney(value.getTicker24().getExchanges().getFLW().getMoney());
        FLW.setTrades(value.getTicker24().getExchanges().getFLW().getTrades());
        FLW.setVol(value.getTicker24().getExchanges().getFLW().getVol());
        FLW.setVwap(value.getTicker24().getExchanges().getFLW().getVwap());
        listTicker.add(FLW);

        return listTicker;
        
    }

    public static void GenerateListTicker12(Value value){

    }

    public static void GenerateListTicker1(Value value){

    }
}
