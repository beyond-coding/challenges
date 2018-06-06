package com.beyondcoding.exoticbazaar.vault;

import com.beyondcoding.exoticbazaar.cash.Cash;
import com.beyondcoding.exoticbazaar.cash.CashStrategy;
import com.beyondcoding.exoticbazaar.money.Money;
import com.beyondcoding.exoticbazaar.money.Moneys;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AbstractVaultKeeper implements VaultKeeper {

    private Class<? extends Money> currency;

    private CashStrategy cashStrategy;

    private Set<Money> options;


    public AbstractVaultKeeper(Class<? extends Money> currency, CashStrategy cashStrategy) {
        this.currency = currency;
        this.cashStrategy = cashStrategy;
        initialiseOptions();
    }

    private void initialiseOptions() {
        options = Moneys.asSet().stream()
                .filter(e -> isKeeping(e.getClass()))
                .collect(Collectors.toSet());
    }

    @Override
    public boolean isKeeping(Class<? extends Money> currency) {
        return this.currency.isAssignableFrom(currency);
    }

    @Override
    public List<Money> getMoney(Integer amount) {
        Cash cash = new Cash(amount, options);
        return cashStrategy.apply(cash, this);
    }

    @Override
    public Money getMoney(Class<? extends Money> currency) {
        if (!isKeeping(currency)) {
            throw new IllegalStateException("Should not create an instance of " + currency.getClass().getSimpleName() + " being a " + getClass().getSimpleName());
        }
        try {
            return currency.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException("Could not create an instance of " + currency.getClass().getSimpleName());
    }

}
