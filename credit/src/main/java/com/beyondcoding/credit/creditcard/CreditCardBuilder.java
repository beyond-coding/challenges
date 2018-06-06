package com.beyondcoding.credit.creditcard;

public interface CreditCardBuilder {

    boolean isValid(String number);

    CreditCard build(String number);

}
