package com.beyondcoding.credit.creditcard.builder;

import com.beyondcoding.credit.creditcard.*;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardsTest {

    @Test
    void testAmericanExpress() {
        assertType(AmericanExpress.class, "378282246310005");
        assertType(AmericanExpress.class, "371449635398431");
    }

    private void assertType(Class<? extends CreditCard> clazz, String number) {
        Optional<CreditCard> creditCard = CreditCards.from(number);
        assertTrue(creditCard.isPresent());
        assertEquals(clazz, creditCard.get().getClass());
    }

    @Test
    void testMasterCard() {
        assertType(MasterCard.class, "5555555555554444");
        assertType(MasterCard.class, "5105105105105100");
    }

    @Test
    void testVisa() {
        assertType(Visa.class, "4111111111111111");
        assertType(Visa.class, "4012888888881881");
    }

    @Test
    void testInvalid() {
        Optional<CreditCard> creditCard = CreditCards.from("333333333333");
        assertFalse(creditCard.isPresent());
    }
}