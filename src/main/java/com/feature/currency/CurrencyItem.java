package com.feature.currency;

public class CurrencyItem {
    private CCY ccy;
    private CCY base_ccy;
    private float buy;
    private float sale;

    public CCY getCcy() {
        return ccy;
    }

    public CCY getBase_ccy() {
        return base_ccy;
    }

    public float getBuy() {
        return buy;
    }

    public float getSale() {
        return sale;
    }

    public void setCcy(CCY ccy) {
        this.ccy = ccy;
    }

    public void setBase_ccy(CCY base_ccy) {
        this.base_ccy = base_ccy;
    }

    public void setBuy(float buy) {
        this.buy = buy;
    }

    public void setSale(float sale) {
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "CurrencyItem{" +
                "ccy=" + ccy +
                ", base_ccy=" + base_ccy +
                ", buy=" + buy +
                ", sale=" + sale +
                '}';
    }

    public enum CCY{
        EUR,
        USD,
        PLZ,
        UAH,
        CHF,
        CZK,
        GBP,
        ILS,
        JPY,
        NOK,
        SEK
    }
}
