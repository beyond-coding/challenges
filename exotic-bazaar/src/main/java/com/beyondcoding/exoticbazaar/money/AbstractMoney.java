package com.beyondcoding.exoticbazaar.money;

public abstract class AbstractMoney implements Money {

    private Integer value;

    public AbstractMoney(Integer value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " (" + getValue() + ")";
    }
}
