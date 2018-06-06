package com.beyondcoding.exoticbazaar.vault;

import com.beyondcoding.exoticbazaar.cash.CashStrategy;
import com.beyondcoding.exoticbazaar.money.preciousstone.PreciousStone;

public class Jeweller extends AbstractVaultKeeper {

    public Jeweller(CashStrategy cashStrategy) {
        super(PreciousStone.class, cashStrategy);
    }
}
