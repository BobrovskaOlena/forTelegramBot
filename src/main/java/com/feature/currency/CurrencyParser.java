package com.feature.currency;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Jsoup;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
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
            if (currencyItem.getCcy() != null &&(currencyItem.getCcy().equals(CurrencyItem.CCY.USD) ||
                    currencyItem.getCcy().equals(CurrencyItem.CCY.EUR) ||
                    currencyItem.getCcy().equals(CurrencyItem.CCY.PLZ))) {
                filteredCurrencyItems.add(currencyItem);
            }
        }
        for (CurrencyItem currencyItem : filteredCurrencyItems) {
            System.out.println(currencyItem);
        }


        Float uahUsd = filteredCurrencyItems
                .stream()
                .filter(it->it.getCcy().equals(CurrencyItem.CCY.USD))
                .filter(it -> it.getBase_ccy().equals(CurrencyItem.CCY.UAH))
                .map(CurrencyItem::getBuy)
                .findFirst()
                .orElse(null);
        if (uahUsd == null) {
            System.out.println("Value not found.");
        } else {
            System.out.println("UAH/USD purchase rate: "+uahUsd);
        }
        Float usdUah = filteredCurrencyItems
                .stream()
                .filter(it->it.getCcy().equals(CurrencyItem.CCY.USD))
                .filter(it -> it.getBase_ccy().equals(CurrencyItem.CCY.UAH))
                .map(CurrencyItem::getSale)
                .findFirst()
                .orElse(null);
        if (uahUsd == null) {
            System.out.println("Value not found.");
        } else {
            System.out.println("USD/UAH sales rate: "+usdUah);
        }


        Float uahEur = filteredCurrencyItems
                .stream()
                .filter(it->it.getCcy().equals(CurrencyItem.CCY.EUR))
                .filter(it -> it.getBase_ccy().equals(CurrencyItem.CCY.UAH))
                .map(CurrencyItem::getBuy)
                .findFirst()
                .orElse(null);
        if (uahUsd == null) {
            System.out.println("Value not found.");
        } else {
            System.out.println("UAH/EUR purchase rate: "+uahEur);
        }
        Float eurUah = filteredCurrencyItems
                .stream()
                .filter(it->it.getCcy().equals(CurrencyItem.CCY.EUR))
                .filter(it -> it.getBase_ccy().equals(CurrencyItem.CCY.UAH))
                .map(CurrencyItem::getSale)
                .findFirst()
                .orElse(null);
        if (uahUsd == null) {
            System.out.println("Value not found.");
        } else {
            System.out.println("EUR/UAH sales rate: "+eurUah);
        }


        Float uahPlz = filteredCurrencyItems
                .stream()
                .filter(it->it.getCcy().equals(CurrencyItem.CCY.PLZ))
                .filter(it -> it.getBase_ccy().equals(CurrencyItem.CCY.UAH))
                .map(CurrencyItem::getBuy)
                .findFirst()
                .orElse(null);
        if (uahUsd == null) {
            System.out.println("Value not found.");
        } else {
            System.out.println("UAH/PLZ purchase rate: "+uahPlz);
        }
        Float plzUah = filteredCurrencyItems
                .stream()
                .filter(it->it.getCcy().equals(CurrencyItem.CCY.PLZ))
                .filter(it -> it.getBase_ccy().equals(CurrencyItem.CCY.UAH))
                .map(CurrencyItem::getSale)
                .findFirst()
                .orElse(null);
        if (uahUsd == null) {
            System.out.println("Value not found.");
        } else {
            System.out.println("PLZ/UAH sales rate: "+plzUah);
        }
    }
}