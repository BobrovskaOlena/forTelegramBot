package com.feature.currency;

import java.io.IOException;
import java.util.List;

public interface CurrencyService {
    double getPurchaseRate(Currency currency) throws IOException;

    double getSalesRate(Currency currency) throws IOException;
}
