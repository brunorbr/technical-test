package com.technicaltest.automation.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CurrencyConversion {
    private BigDecimal originValue;
    private BigDecimal conversionRate;
    private int scale;

    public CurrencyConversion(String origin, String rate, int scale){
        this.originValue =  new BigDecimal(origin);
        this.conversionRate = new BigDecimal(rate);
        this.scale = scale;
    }

    public BigDecimal getConvertedValue(){
        return originValue.multiply(conversionRate).setScale(scale, RoundingMode.CEILING);
    }
}
