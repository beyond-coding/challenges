package com.beyondcoding.exoticbazaar.logic;

import com.beyondcoding.exoticbazaar.domain.Payment;
import com.beyondcoding.exoticbazaar.domain.Product;
import com.beyondcoding.exoticbazaar.money.Money;
import com.beyondcoding.exoticbazaar.vault.Vault;

import java.util.List;

public class Tradesman {

    private static final Tradesman tradesman = new Tradesman();

    private Cashier cashier = new Cashier();

    private Tradesman() {
    }

    public static Tradesman get() {
        return tradesman;
    }

    public List<Money> sell(Product product, Payment payment) {
        Integer change = cashier.calculateChange(product, payment);
        Vault vault = Vault.get();
        return vault.getMoney(change, payment.getCurrency());
    }

}
