package com.beyondcoding.exoticbazaar.domain;

import com.beyondcoding.exoticbazaar.money.Money;

public class Payment {

    private Integer amount;

    private Class<? extends Money> currency;

    public Payment(Integer amount, Class<? extends Money> currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Integer getAmount() {
        return amount;
    }

    public Class<? extends Money> getCurrency() {
        return currency;
    }
}
