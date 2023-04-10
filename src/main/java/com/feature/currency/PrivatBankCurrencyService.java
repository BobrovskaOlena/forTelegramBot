package com.feature.currency;

import java.io.IOException;

public class PrivatBankCurrencyService implements CurrencyService{
    @Override
    public double getPurchaseRate(Currency currency) throws IOException {
        Float uahCurrency = filteredCurrencyItems
                .stream()
                .filter(it->it.getCcy().equals(currency))
                .filter(it -> it.getBase_ccy().equals(Currency.UAH))
                .map(CurrencyItem::getBuy)
                .findFirst()
                .orElseThrow();
        return 0;
    }

    @Override
    public double getSalesRate(Currency currency) throws IOException {
        Float currencyUah = filteredCurrencyItems
                .stream()
                .filter(it->it.getCcy().equals(currency))
                .filter(it -> it.getBase_ccy().equals(Currency.UAH))
                .map(CurrencyItem::getSale)
                .findFirst()
                .orElseThrow();
        return 0;
    }
}
