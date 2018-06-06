package com.beyondcoding.exoticbazaar.cash;

import com.beyondcoding.exoticbazaar.money.Money;
import com.beyondcoding.exoticbazaar.vault.VaultKeeper;

import java.util.List;

public interface CashStrategy {

    List<Money> apply(Cash cash, VaultKeeper vaultKeeper);

}
