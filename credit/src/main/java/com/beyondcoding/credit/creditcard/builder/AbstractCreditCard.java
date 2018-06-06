package com.beyondcoding.credit.creditcard.builder;

import com.beyondcoding.credit.creditcard.CreditCard;

public abstract class AbstractCreditCard implements CreditCard {

    private String number;

    AbstractCreditCard(String number) {
        this.number = number;
    }

    @Override
    public String getNumber() {
        return number;
    }

}
