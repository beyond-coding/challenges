package com.beyondcoding.exoticbazaar.vault;

import com.beyondcoding.exoticbazaar.money.Money;

import java.util.List;

public interface VaultKeeper {

    boolean isKeeping(Class<? extends Money> currency);

    List<Money> getMoney(Integer amount);

    Money getMoney(Class<? extends Money> currency);

}
