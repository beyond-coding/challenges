package com.beyondcoding.credit.validator;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ChecksumValidatorTest {

    private ChecksumValidator checksumValidator = new ChecksumValidator();

    @Test
    void isValid() {
        Stream.of(
                "378282246310005", "371449635398431", "5555555555554444",
                "5105105105105100", "4111111111111111", "4012888888881881"
        ).forEach(number -> assertTrue(checksumValidator.isValid(number)));
    }

    @Test
    void isInvalid() {
        assertFalse(checksumValidator.isValid("37828224631000"));
    }
}