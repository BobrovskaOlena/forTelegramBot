package com.feature.printCurrency;


import com.feature.currency.Currency;
import com.feature.currency.CurrencyService;
import com.feature.currency.PrivatBankCurrencyService;

import java.io.IOException;

public class PrintCurrencyService {
    CurrencyService currencyService = new PrivatBankCurrencyService();
    public double salesRates(Currency currency) {
        double salesRate;
        try {
            salesRate = currencyService.getSalesRate(currency);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return salesRate;
    }
    public double purchaseRates (Currency currency) {
        double purchaseRate;
        try {
            purchaseRate = currencyService.getPurchaseRate(currency);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return purchaseRate;
    }
    public String convert(double salesRate, double purchaseRate, Currency currency){
        String templateOfMessage = "Purchase rate UAH => ${currency} = ${purchaseRate}\nSales rate ${currency} => UAH = ${salesRate}";
        float roundedRate = Math.round(salesRate*100d)/100.f;
        float roundedRate2 = Math.round(purchaseRate*100d)/100.f;
        return templateOfMessage
                .replace("${currency}", currency.name())
                .replace("${salesRate}",roundedRate +"")
                .replace("${purchaseRate}", roundedRate2 +"");
    }
}
