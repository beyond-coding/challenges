package dev.playground.barista.domain;

public class Cup {

    private String customer;

    private String barista;

    private Beverage beverage;

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getBarista() {
        return barista;
    }

    public void setBarista(String barista) {
        this.barista = barista;
    }

    public Beverage getBeverage() {
        return beverage;
    }

    public void setBeverage(Beverage beverage) {
        this.beverage = beverage;
    }
}

