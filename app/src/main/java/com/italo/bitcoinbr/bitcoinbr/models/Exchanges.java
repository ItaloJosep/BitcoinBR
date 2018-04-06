package com.italo.bitcoinbr.bitcoinbr.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by italo.josep on 05/04/2018.
 */

public class Exchanges {

    public Exchanges(){}

    @JsonProperty("LOC") private ValueTicker LOC;
    @JsonProperty("B2U") private ValueTicker B2U;
    @JsonProperty("NEG") private ValueTicker NEG;
    @JsonProperty("FOX") private ValueTicker FOX;
    @JsonProperty("BZX") private ValueTicker BZX;
    @JsonProperty("BTD") private ValueTicker BTD;
    @JsonProperty("MBT") private ValueTicker MBT;
    @JsonProperty("FLW") private ValueTicker FLW;


    public ValueTicker getLOC() {
        return LOC;
    }

    public void setLOC(ValueTicker LOC) {
        this.LOC = LOC;
    }

    public ValueTicker getB2U() {
        return B2U;
    }

    public void setB2U(ValueTicker b2U) {
        B2U = b2U;
    }

    public ValueTicker getNEG() {
        return NEG;
    }

    public void setNEG(ValueTicker NEG) {
        this.NEG = NEG;
    }

    public ValueTicker getFOX() {
        return FOX;
    }

    public void setFOX(ValueTicker FOX) {
        this.FOX = FOX;
    }

    public ValueTicker getBZX() {
        return BZX;
    }

    public void setBZX(ValueTicker BZX) {
        this.BZX = BZX;
    }

    public ValueTicker getBTD() {
        return BTD;
    }

    public void setBTD(ValueTicker BTD) {
        this.BTD = BTD;
    }

    public ValueTicker getMBT() {
        return MBT;
    }

    public void setMBT(ValueTicker MBT) {
        this.MBT = MBT;
    }

    public ValueTicker getFLW() {
        return FLW;
    }

    public void setFLW(ValueTicker FLW) {
        this.FLW = FLW;
    }

}
