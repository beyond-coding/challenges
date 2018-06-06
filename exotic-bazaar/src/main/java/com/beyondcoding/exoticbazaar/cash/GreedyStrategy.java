package com.beyondcoding.exoticbazaar.cash;

import com.beyondcoding.exoticbazaar.money.Money;
import com.beyondcoding.exoticbazaar.vault.VaultKeeper;

import java.util.List;
import java.util.Queue;

public class GreedyStrategy implements CashStrategy {

    @Override
    public List<Money> apply(Cash cash, VaultKeeper vaultKeeper) {
        while (canBite(cash)) {
            bite(cash, vaultKeeper);
        }
        return cash.getMoney();
    }

    private boolean canBite(Cash cash) {
        return cash.getRemaining() > 0 && !cash.getOptions().isEmpty();
    }

    private void bite(Cash cash, VaultKeeper vaultKeeper) {
        Queue<Money> options = cash.getOptions();
        Integer remaining = cash.getRemaining();
        Money option = options.peek();
        if (option.getValue() > remaining) {
            options.poll();
            return;
        }
        Money money = vaultKeeper.getMoney(option.getClass());
        cash.add(money);
    }

}
