package com.italo.bitcoinbr.bitcoinbr.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by italo.josep on 05/04/2018.
 */

public class Ticker {

    public Ticker() {}

    @JsonProperty("total") private ValueTicker total;
    @JsonProperty("exchanges") private Exchanges exchanges;


    public ValueTicker getTotal() {
        return total;
    }

    public void setTotal(ValueTicker total) {
        this.total = total;
    }

    public Exchanges getExchanges() {
        return exchanges;
    }

    public void setExchanges(Exchanges exchanges) {
        this.exchanges = exchanges;
    }
}
