package com.beyondcoding.credit.validator;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrefixValidator implements Validator {

    private Set<Integer> prefixes;

    public PrefixValidator(Integer... prefixes) {
        this.prefixes = Stream.of(prefixes).collect(Collectors.toSet());
    }

    @Override
    public boolean isValid(String number) {
        return prefixes.stream()
                .map(prefix -> prefix.toString())
                .anyMatch(prefix -> number.startsWith(prefix));
    }
}
