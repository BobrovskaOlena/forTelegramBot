package com.feature.currency;

import java.io.IOException;

public class TelegramBotApp {
    public static void main(String[] args) throws IOException {
        CurrencyService currencyService = new PrivatBankCurrencyService();
        double rateUsd = currencyService.getRate(Currency.USD);
        double ratePlz = currencyService.getRate(Currency.PLZ);
        double rateEur = currencyService.getRate(Currency.EUR);
        System.out.println("rate of USD = " + rateUsd);
        System.out.println("rate of PLZ = " + ratePlz);
        System.out.println("rate of EUR = " + rateEur);

    }
}
