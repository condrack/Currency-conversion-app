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

    public String[] getUserData(String base) {
        String json = null;
        try {
            json = getJSON("http://api.fixer.io/latest?base=" + base);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        MyPojo myPojo = gson.fromJson(json, MyPojo.class);

        // return myPojo.rates hashmap
        return new String[]{myPojo.getBase(), "date: " + myPojo.getDate()
                , "rates: " + myPojo.getRates()};
    }
    //public static Map<String, Double> getCurrencyValues()


}
