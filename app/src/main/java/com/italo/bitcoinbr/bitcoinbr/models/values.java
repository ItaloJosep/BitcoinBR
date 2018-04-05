package com.italo.bitcoinbr.bitcoinbr.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by italo.josep on 05/04/2018.
 */

public class values {

    public values(){}

    @JsonProperty("ticker_24h") private Ticker ticker24;
    @JsonProperty("ticker_12h") private Ticker ticker12;
    @JsonProperty("ticker_1h") private Ticker ticker1;


    public Ticker getTicker24() {
        return ticker24;
    }

    public void setTicker24(Ticker ticker24) {
        this.ticker24 = ticker24;
    }

    public Ticker getTicker12() {
        return ticker12;
    }

    public void setTicker12(Ticker ticker12) {
        this.ticker12 = ticker12;
    }

    public Ticker getTicker1() {
        return ticker1;
    }

    public void setTicker1(Ticker ticker1) {
        this.ticker1 = ticker1;
    }
}
