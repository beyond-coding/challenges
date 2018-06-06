package com.beyondcoding.exoticbazaar.vault;

import com.beyondcoding.exoticbazaar.cash.CashStrategy;
import com.beyondcoding.exoticbazaar.cash.GreedyStrategy;
import com.beyondcoding.exoticbazaar.money.Money;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Vault {

    private static Vault vault = new Vault();

    private CashStrategy strategy = new GreedyStrategy();

    private Set<VaultKeeper> keepers = Stream.of(
            new Sailor(strategy), new Smith(strategy), new Jeweller(strategy)
    ).collect(Collectors.toSet());

    private Vault() {
    }

    public static Vault get() {
        return vault;
    }

    public List<Money> getMoney(Integer amount, Class<? extends Money> currency) {
        VaultKeeper keeper = findKeeper(currency);
        return keeper.getMoney(amount);
    }

    private VaultKeeper findKeeper(Class<? extends Money> currency) {
        return keepers.stream()
                .filter(keeper -> keeper.isKeeping(currency))
                .findFirst().orElseThrow(() -> new IllegalStateException("No keeper found for currency " + currency.getSimpleName()));
    }

}
