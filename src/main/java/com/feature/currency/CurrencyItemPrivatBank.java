package com.feature.currency;

public class CurrencyItemPrivatBank {
    private String date;
    private String bank;

    private  CCY baseCurrency;
    private  CCY currency;
    private float saleRateNB;
    private float purchaseRateNB;
    private float saleRate;
    private float purchaseRate;

    public CCY getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(CCY baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public CCY getCurrency() {
        return currency;
    }

    public void setCurrency(CCY currency) {
        this.currency = currency;
    }

    public float getSaleRateNB() {
        return saleRateNB;
    }

    public void setSaleRateNB(float saleRateNB) {
        this.saleRateNB = saleRateNB;
    }

    public float getPurchaseRateNB() {
        return purchaseRateNB;
    }

    public void setPurchaseRateNB(float purchaseRateNB) {
        this.purchaseRateNB = purchaseRateNB;
    }

    public float getSaleRate() {
        return saleRate;
    }

    public void setSaleRate(float saleRate) {
        this.saleRate = saleRate;
    }

    public float getPurchaseRate() {
        return purchaseRate;
    }

    public void setPurchaseRate(float purchaseRate) {
        this.purchaseRate = purchaseRate;
    }

    @Override
    public String toString() {
        return "CurrencyItemPrivatBank{" +
                "baseCurrency=" + baseCurrency +
                ", currency=" + currency +
                ", saleRateNB=" + saleRateNB +
                ", purchaseRateNB=" + purchaseRateNB +
                ", saleRate=" + saleRate +
                ", purchaseRate=" + purchaseRate +
                '}';
    }

    public enum CCY{
        EUR,
        USD,
        PLZ,
        UAH
    }
}

