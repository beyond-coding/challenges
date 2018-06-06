package com.beyondcoding.credit.creditcard.builder;

import com.beyondcoding.credit.creditcard.CreditCard;
import com.beyondcoding.credit.validator.LengthValidator;
import com.beyondcoding.credit.validator.PrefixValidator;

public class MasterCardBuilder extends AbstractCreditCardBuilder {

    MasterCardBuilder() {
        super(new LengthValidator(16), new PrefixValidator(51, 52, 53, 54, 55));
    }

    @Override
    public CreditCard build(String number) {
        return new MasterCard(number);
    }

}
