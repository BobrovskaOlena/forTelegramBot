package com.feature.currency;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CurrencyItem {
    private Currency ccy;
    private Currency base_ccy;
    private BigDecimal buy;
    private BigDecimal sale;
}
