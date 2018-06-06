package com.beyondcoding.exoticbazaar.logic;

import com.beyondcoding.exoticbazaar.domain.Payment;
import com.beyondcoding.exoticbazaar.domain.Product;

public class Cashier {

    public Integer calculateChange(Product product, Payment payment) {
        return payment.getAmount() - product.getPrice();
    }

}
