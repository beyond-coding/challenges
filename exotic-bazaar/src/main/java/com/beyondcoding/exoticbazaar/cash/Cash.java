package com.beyondcoding.exoticbazaar.cash;

import com.beyondcoding.exoticbazaar.money.Money;

import java.util.*;
import java.util.stream.Collectors;

public class Cash {

    private Integer remaining;
    private Queue<Money> options;
    private List<Money> money = new ArrayList<>();

    public Cash(Integer remaining, Collection<Money> options) {
        this.remaining = remaining;
        this.options = sort(options);
    }

    private Queue<Money> sort(Collection<Money> options) {
        return options.stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .collect(Collectors.toCollection(() -> new LinkedList<>()));
    }

    public Integer getRemaining() {
        return remaining;
    }

    public Queue<Money> getOptions() {
        return options;
    }

    public List<Money> getMoney() {
        return money;
    }

    public void add(Money money) {
        remaining = remaining - money.getValue();
        this.money.add(money);
    }
}
