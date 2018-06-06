package com.beyondcoding.exoticbazaar.logic;

import com.beyondcoding.exoticbazaar.domain.Merchant;
import com.beyondcoding.exoticbazaar.domain.Payment;
import com.beyondcoding.exoticbazaar.domain.Product;
import com.beyondcoding.exoticbazaar.money.Money;
import com.beyondcoding.exoticbazaar.money.metal.Metal;
import com.beyondcoding.exoticbazaar.money.preciousstone.PreciousStone;
import com.beyondcoding.exoticbazaar.money.seashell.Seashell;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BazaarTest {

    private Bazaar bazaar = new Bazaar();

    @Test
    void testMerchantPaysWithSeashells() {
        test(9, 10, 1, Seashell.class);
        test(9, 15, 2, Seashell.class);
        test(9, 20, 3, Seashell.class);
        test(9, 27, 4, Seashell.class);
    }

    @Test
    void testMerchantPaysWithMetals() {
        test(9, 10, 1, Metal.class);
        test(9, 15, 2, Metal.class);
        test(9, 25, 3, Metal.class);
        test(9, 26, 4, Metal.class);
    }

    @Test
    void testMerchantPaysWithPreciousStones() {
        test(9, 10, 1, PreciousStone.class);
        test(9, 18, 2, PreciousStone.class);
        test(9, 38, 3, PreciousStone.class);
        test(9, 46, 4, PreciousStone.class);
    }

    private void test(int price, int paid, int expectedAmountOfUnits, Class<? extends Money> currency) {
        Product product = new Product(price);
        Merchant merchant = new Merchant(new Payment(paid, currency));
        Purchase purchase = new Purchase(product, merchant);

        bazaar.trade(purchase);
        List<Money> change = merchant.getMoney();

        assertEquals(expectedAmountOfUnits, change.size());
        Set<Class<?>> interfaces = Stream.of(change.get(0).getClass().getInterfaces()).collect(Collectors.toSet());
        assertTrue(interfaces.contains(currency));
    }

}