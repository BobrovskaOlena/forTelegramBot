package com.feature.printCurrency;

import com.feature.currency.Currency;

public class PrintCurrencyService {
    public String convert(double rate, Currency currency){
        String templateOfMessage = "Purchase rate UAH => ${currency} = ${rate}";
        float roundedRate = Math.round(rate*100d)/100.f;
        return templateOfMessage
                .replace("${currency}", currency.name())
                .replace("${rate}", roundedRate +"");
    }
}
