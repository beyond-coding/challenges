package com.beyondcoding.exoticbazaar.vault;

import com.beyondcoding.exoticbazaar.cash.CashStrategy;
import com.beyondcoding.exoticbazaar.money.metal.Metal;

public class Smith extends AbstractVaultKeeper {

    public Smith(CashStrategy cashStrategy) {
        super(Metal.class, cashStrategy);
    }
}
