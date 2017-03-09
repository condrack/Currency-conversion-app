package com.currencyconverter.currencyconverter;

import java.io.IOException;
import java.util.Map;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class Json_get {
    private static OkHttpClient client = new OkHttpClient();

    public static String getJSON(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        okhttp3.Response response = client.newCall(request).execute();
        return response.body().string();

    }

//    public String[] getUserData(String base) {
//        String json = null;
//        try {
//            json = getJSON("http://api.fixer.io/latest?base=" + base);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        Gson gson = new Gson();
//        MyPojo myPojo = gson.fromJson(json, MyPojo.class);
//
//        // return myPojo.rates hashmap
//        return new String[]{myPojo.getBase(), "date: " + myPojo.getDate()
//                , "rates: " + myPojo.getRates()};
//    }

    public String[] getUserData(String base, String secondary) {
        String json = null;
        String secondaryValue;

        try {
            json = getJSON("http://api.fixer.io/latest?base=" + base);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        MyPojo myPojo = gson.fromJson(json, MyPojo.class);

        if (secondary == "AUD") {
            secondaryValue = myPojo.getAUD();
        } else if (secondary == "BGN") {
            secondaryValue = myPojo.getBGN();
        } else if (secondary == "BRL") {
            secondaryValue = myPojo.getBRL();
        } else if (secondary == "CAD") {
            secondaryValue = myPojo.getCAD();
        } else if (secondary == "CHF") {
            secondaryValue = myPojo.getCHF();
        } else if (secondary == "CNY") {
            secondaryValue = myPojo.getCNY();
        } else if (secondary == "CZK") {
            secondaryValue = myPojo.getCZK();
        } else if (secondary == "DKK") {
            secondaryValue = myPojo.getDKK();
        } else if (secondary == "GBP") {
            secondaryValue = myPojo.getGBP();
        } else if (secondary == "HKD") {
            secondaryValue = myPojo.getHKD();
        } else if (secondary == "HRK") {
            secondaryValue = myPojo.getHRK();
        } else if (secondary == "HUF") {
            secondaryValue = myPojo.getHUF();
        } else if (secondary == "IDR") {
            secondaryValue = myPojo.getIDR();
        } else if (secondary == "ILS") {
            secondaryValue = myPojo.getILS();
        } else if (secondary == "INR") {
            secondaryValue = myPojo.getINR();
        } else if (secondary == "JPY") {
            secondaryValue = myPojo.getJPY();
        } else if (secondary == "KRW") {
            secondaryValue = myPojo.getKRW();
        } else if (secondary == "MXN") {
            secondaryValue = myPojo.getMXN();
        } else if (secondary == "MYR") {
            secondaryValue = myPojo.getMYR();
        } else if (secondary == "NOK") {
            secondaryValue = myPojo.getNOK();
        } else if (secondary == "NZD") {
            secondaryValue = myPojo.getNZD();
        } else if (secondary == "PHP") {
            secondaryValue = myPojo.getPHP();
        } else if (secondary == "PLN") {
            secondaryValue = myPojo.getPLN();
        } else if (secondary == "RON") {
            secondaryValue = myPojo.getRON();
        } else if (secondary == "RUB") {
            secondaryValue = myPojo.getRUB();
        } else if (secondary == "SEK") {
            secondaryValue = myPojo.getSEK();
        } else if (secondary == "SGD") {
            secondaryValue = myPojo.getSGD();
        } else if (secondary == "THB") {
            secondaryValue = myPojo.getTHB();
        } else if (secondary == "TRY") {
            secondaryValue = myPojo.getTRY();
        } else if (secondary == "USD") {
            secondaryValue = myPojo.getUSD();
        } else if (secondary == "ZAR") {
            secondaryValue = myPojo.getZAR();
        } else if (secondary == "EUR") {
            secondaryValue = myPojo.getEUR();
        } else {
            secondaryValue = null;
        }

        // return myPojo.rates hashmap
        return new String[]{myPojo.getBase(), "date: " + myPojo.getDate()
                , "rates: " + myPojo.getRates()};
    }


}
