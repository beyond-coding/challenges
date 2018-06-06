package com.beyondcoding.exoticbazaar.domain;

import com.beyondcoding.exoticbazaar.money.Money;

import java.util.ArrayList;
import java.util.List;

public class Merchant {

    private Payment payment;

    private List<Money> money = new ArrayList<>();

    public Merchant(Payment payment) {
        this.payment = payment;
    }

    public Payment getPayment() {
        return payment;
    }

    public List<Money> getMoney() {
        return money;
    }

    public void add(List<Money> money) {
        this.money.addAll(money);
    }
}
