package com.beyondcoding.exoticbazaar.logic;

import com.beyondcoding.exoticbazaar.domain.Merchant;
import com.beyondcoding.exoticbazaar.domain.Product;
import com.beyondcoding.exoticbazaar.money.Money;

import java.util.List;

public class Purchase implements Trade {

    private Product product;

    private Merchant merchant;

    public Purchase(Product product, Merchant merchant) {
        this.product = product;
        this.merchant = merchant;
    }

    @Override
    public void perform() {
        Tradesman tradesman = Tradesman.get();
        List<Money> change = tradesman.sell(product, merchant.getPayment());
        merchant.add(change);
    }
}
