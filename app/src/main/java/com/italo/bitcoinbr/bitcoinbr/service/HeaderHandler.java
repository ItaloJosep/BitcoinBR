package com.italo.bitcoinbr.bitcoinbr.service;

/**
 * Created by italo.josep on 05/04/2018.
 */

public  class HeaderHandler {

    private static ApiHeaders apiHeaders;


    public static ApiHeaders getApiHeaderInstance() {
        if (apiHeaders == null) apiHeaders = new ApiHeaders();
        apiHeaders.setSessionId("");
        return apiHeaders;
    }
}
