package com.feature.currency;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CurrencyParser {
    public static void main(String[] args) throws IOException {
        String url = "https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=5";
        String urlPLZ = "https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=4";
        String response = Jsoup
                .connect(urlPLZ)
                .ignoreContentType(true)
                .get()
                .body()
                .text();
        System.out.println(response);
        String response1 = Jsoup
                .connect(url)
                .ignoreContentType(true)
                .get()
                .body()
                .text();
        System.out.println(response1);
        Type typeToken = TypeToken
                .getParameterized(List.class, CurrencyItem.class)
                .getType();
        Gson gson = new Gson();
        List<CurrencyItem> currencyItems = gson.fromJson(response, typeToken);
        String json2 = response1;
        Type listType = new TypeToken<List<CurrencyItem>>() {}.getType();
        Gson gson1 = new Gson();
        List<CurrencyItem> currencyItems2 = gson.fromJson(json2, listType);
        currencyItems.addAll(currencyItems2);
        List<CurrencyItem> filteredCurrencyItems = new ArrayList<>();
        for (CurrencyItem currencyItem : currencyItems) {
            if (currencyItem.getCcy().equals("USD") ||
                    currencyItem.getCcy().equals("EUR") ||
                    currencyItem.getCcy().equals("PLZ")) {
                filteredCurrencyItems.add(currencyItem);
            }
        }
        for (CurrencyItem currencyItem : filteredCurrencyItems) {
            System.out.println(currencyItem);
        }
    }
}
/*public class CurrencyParser {
    public static void main(String[] args) throws IOException {
        String url = "https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=5";
        String urlPLZ = "https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=4";
        String response = Jsoup
                .connect(urlPLZ)
                .ignoreContentType(true)
                .get()
                .body()
                .text();
        System.out.println(response);
        String response1 = Jsoup
                .connect(url)
                .ignoreContentType(true)
                .get()
                .body()
                .text();
        System.out.println(response1);
        Type typeToken = TypeToken
                .getParameterized(List.class, CurrencyItem.class)
                .getType();
        Gson gson = new Gson();
            List<CurrencyItem> currencyItems = gson.fromJson(response, typeToken);
            String json2 = response1;
            Type listType = new TypeToken<List<CurrencyItem>>() {}.getType();
            Gson gson1 = new Gson();
            List<CurrencyItem> currencyItems2 = gson.fromJson(json2, listType);
            currencyItems.addAll(currencyItems2);
        //for (CurrencyItem currencyItem : currencyItems) {
        //    System.out.println(currencyItem);
      //  }
        List<CurrencyItem> filteredCurrencyItems = new ArrayList<>();
        for (CurrencyItem currencyItem : currencyItems) {
            if (currencyItem.getCcy().equals("USD") || currencyItem.getCcy().equals("EUR") || currencyItem.getCcy().equals("PLZ")) {
                filteredCurrencyItems.add(currencyItem);
            }
        }

        for (CurrencyItem currencyItem : filteredCurrencyItems) {
            System.out.println(currencyItem);
        }
    }
}*/