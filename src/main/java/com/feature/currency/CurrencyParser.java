package com.feature.currency;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class CurrencyParser {
    public static void main(String[] args) throws IOException {
        String url = "https://api.privatbank.ua/p24api/exchange_rates?json&date=09.04.2023";
        String urlPLZ = "https://api.privatbank.ua/p24api/pubinfo?exchange&coursid = 4";
        String response = Jsoup
                .connect(url)
                .ignoreContentType(true)
                .get()
                .body()
                .text();
        System.out.println(response);

        Type typeToken = TypeToken
                .getParameterized(List.class, CurrencyItem.class)
                .getType();
        Gson gson = new Gson();
        List<CurrencyItem> currencyItems = gson.fromJson(response, typeToken);
        for (CurrencyItem currencyItem:currencyItems) {
            System.out.println(currencyItem);
        }
    }
}
