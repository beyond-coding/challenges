package com.beyondcoding.credit.creditcard.builder;

import com.beyondcoding.credit.creditcard.CreditCardBuilder;
import com.beyondcoding.credit.validator.Validator;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class AbstractCreditCardBuilder implements CreditCardBuilder {

    private Set<Validator> validators;

    AbstractCreditCardBuilder(Validator... validators) {
        this.validators = Stream.of(validators).collect(Collectors.toSet());
    }

    @Override
    public boolean isValid(String number) {
        return validators.stream()
                .allMatch(validator -> validator.isValid(number));
    }
}
