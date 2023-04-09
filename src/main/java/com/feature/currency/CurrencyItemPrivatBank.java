package com.feature.currency;

public class CurrencyItemPrivatBank {
    private CurrencyItemPrivatBank CCY baseCurrency;
    private CurrencyItemPrivatBank CCY currency;
    private float saleRateNB;
    private float purchaseRateNB;
    private float saleRate;
    private float purchaseRate;
    public enum CCY{
        EUR,
        USD,
        PLZ,
        UAH
    }
}

