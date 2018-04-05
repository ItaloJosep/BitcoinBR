package com.italo.bitcoinbr.bitcoinbr.models;

/**
 * Created by italo.josep on 05/04/2018.
 */

public class Exchanges {

    public Exchanges(){}

    private Ticker LOC;
    private Ticker B2U;
    private Ticker NEG;
    private Ticker FOX;
    private Ticker BZX;
    private Ticker BTD;
    private Ticker MBT;
    private Ticker FLW;
    private Ticker ARN;

    public Ticker getLOC() {
        return LOC;
    }

    public void setLOC(Ticker LOC) {
        this.LOC = LOC;
    }

    public Ticker getB2U() {
        return B2U;
    }

    public void setB2U(Ticker b2U) {
        B2U = b2U;
    }

    public Ticker getNEG() {
        return NEG;
    }

    public void setNEG(Ticker NEG) {
        this.NEG = NEG;
    }

    public Ticker getFOX() {
        return FOX;
    }

    public void setFOX(Ticker FOX) {
        this.FOX = FOX;
    }

    public Ticker getBZX() {
        return BZX;
    }

    public void setBZX(Ticker BZX) {
        this.BZX = BZX;
    }

    public Ticker getBTD() {
        return BTD;
    }

    public void setBTD(Ticker BTD) {
        this.BTD = BTD;
    }

    public Ticker getMBT() {
        return MBT;
    }

    public void setMBT(Ticker MBT) {
        this.MBT = MBT;
    }

    public Ticker getFLW() {
        return FLW;
    }

    public void setFLW(Ticker FLW) {
        this.FLW = FLW;
    }

    public Ticker getARN() {
        return ARN;
    }

    public void setARN(Ticker ARN) {
        this.ARN = ARN;
    }
}
