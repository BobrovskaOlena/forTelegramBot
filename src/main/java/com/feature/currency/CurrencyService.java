package com.feature.currency;

import java.io.IOException;
import java.math.BigDecimal;

public interface CurrencyService {
    BigDecimal getPurchaseRate(Currency currency) throws IOException;

    BigDecimal getSalesRate(Currency currency) throws IOException;
}
