package com.beyondcoding.credit.validator;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LengthValidator implements Validator {

    private Set<Integer> lengths;

    public LengthValidator(Integer... lengths) {
        this.lengths = Stream.of(lengths).collect(Collectors.toSet());
    }

    @Override
    public boolean isValid(String number) {
        int length = number.length();
        return lengths.contains(length);
    }
}
