package com.beyondcoding.exoticbazaar.vault;

import com.beyondcoding.exoticbazaar.cash.CashStrategy;
import com.beyondcoding.exoticbazaar.money.seashell.Seashell;

public class Sailor extends AbstractVaultKeeper {

    public Sailor(CashStrategy cashStrategy) {
        super(Seashell.class, cashStrategy);
    }
}
