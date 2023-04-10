package com.feature.currency;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PrivatBankCurrency {

    public List<CurrencyItem> getRates(Currency currency) throws IOException{
        String url = "https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=5";
        String urlPLZ = "https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=4";
        String response = Jsoup
                .connect(urlPLZ)
                .ignoreContentType(true)
                .get()
                .body()
                .text();
        String response1 = Jsoup
                .connect(url)
                .ignoreContentType(true)
                .get()
                .body()
                .text();
        Type typeToken = TypeToken
                .getParameterized(List.class, CurrencyItem.class)
                .getType();
        Gson gson = new Gson();
        List<CurrencyItem> currencyItems = gson.fromJson(response, typeToken);
        Type listType = new TypeToken<List<CurrencyItem>>() {}.getType();
        List<CurrencyItem> currencyItems2 = gson.fromJson(response1, listType);
        currencyItems.addAll(currencyItems2);
        List<CurrencyItem> filteredCurrencyItems = new ArrayList<>();
        for (CurrencyItem currencyItem : currencyItems) {
            if (currencyItem.getCcy() != null &&(currencyItem.getCcy().equals(Currency.USD) ||
                    currencyItem.getCcy().equals(Currency.EUR) ||
                    currencyItem.getCcy().equals(Currency.PLZ))) {
                filteredCurrencyItems.add(currencyItem);
            }
        }
        return filteredCurrencyItems;
    }
}
