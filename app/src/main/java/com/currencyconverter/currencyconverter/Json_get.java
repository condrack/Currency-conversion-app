package com.currencyconverter.currencyconverter;

import java.io.IOException;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class Json_get {
    private static OkHttpClient client = new OkHttpClient();



    public static void main(String[] args) {
        System.out.println("Hello");
        for(String str : getUserData("USD")) {
            System.out.println(str);
        }

    }


    public static String getJSON(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        okhttp3.Response response = client.newCall(request).execute();
        return response.body().string();

    }
    public static String[] getUserData(String base) {
        String json = null;
        try {
            json = getJSON("http://api.fixer.io/latest?base="+base);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        MyPojo myPojo = gson.fromJson(json, MyPojo.class);
        return new String[]{"base: " + myPojo.getBase(), "date: " + myPojo.getDate()
                , "rates: " + myPojo.getRates()};
    }


}
