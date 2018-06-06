package com.beyondcoding.credit.creditcard.builder;

import com.beyondcoding.credit.creditcard.CreditCard;
import com.beyondcoding.credit.validator.LengthValidator;
import com.beyondcoding.credit.validator.PrefixValidator;

public class VisaBuilder extends AbstractCreditCardBuilder {

    VisaBuilder() {
        super(new LengthValidator(13, 16), new PrefixValidator(4));
    }

    @Override
    public CreditCard build(String number) {
        return new Visa(number);
    }
}
