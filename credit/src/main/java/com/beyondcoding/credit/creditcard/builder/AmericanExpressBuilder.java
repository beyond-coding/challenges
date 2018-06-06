package com.beyondcoding.credit.creditcard.builder;

import com.beyondcoding.credit.creditcard.CreditCard;
import com.beyondcoding.credit.validator.LengthValidator;
import com.beyondcoding.credit.validator.PrefixValidator;

public class AmericanExpressBuilder extends AbstractCreditCardBuilder {

    AmericanExpressBuilder() {
        super(new LengthValidator(15), new PrefixValidator(34, 37));
    }

    @Override
    public CreditCard build(String number) {
        return new AmericanExpress(number);
    }

}
