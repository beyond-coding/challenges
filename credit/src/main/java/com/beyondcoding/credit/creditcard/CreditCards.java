package com.beyondcoding.credit.creditcard;

import com.beyondcoding.credit.creditcard.builder.Builders;
import com.beyondcoding.credit.validator.ChecksumValidator;
import com.beyondcoding.credit.validator.Validator;

import java.util.Optional;
import java.util.Set;

public class CreditCards {

    private static Validator checksum = new ChecksumValidator();

    private static Set<CreditCardBuilder> builders = Builders.asSet();

    private CreditCards() {
    }

    public static Optional<CreditCard> from(String number) {
        if (isInvalid(number)) {
            return Optional.empty();
        }
        return buildCreditCard(number);
    }

    private static boolean isInvalid(String number) {
        return !checksum.isValid(number);
    }

    private static Optional<CreditCard> buildCreditCard(String number) {
        return builders.stream()
                .filter(builder -> builder.isValid(number))
                .map(builder -> builder.build(number))
                .findFirst();
    }


}
