package dev.playground.barista.logic;

import dev.playground.barista.domain.Beverage;
import dev.playground.barista.domain.Cup;
import dev.playground.barista.domain.Order;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class Baristas {

    private final Beverages beverages;

    @Value("#{'${barista.names}'.split(',')}")
    private List<String> baristas;

    private List<Cup> preparedCups = new ArrayList<>();

    public Baristas(Beverages beverages) {
        this.beverages = beverages;
    }

    public Optional<Cup> prepare(Order order) {
        Optional<Beverage> beverage = beverages.prepare(order.getBeverage());
        if (!beverage.isPresent()) {
            return Optional.empty();
        }
        Cup cup = prepareCup(order, beverage);
        preparedCups.add(cup);
        return Optional.of(cup);
    }

    private Cup prepareCup(Order order, Optional<Beverage> beverage) {
        Cup cup = new Cup();
        cup.setCustomer(order.getCustomer());
        cup.setBarista(getNextBarista());
        cup.setBeverage(beverage.get());
        return cup;
    }

    private String getNextBarista() {
        List<String> names = new ArrayList<>(baristas);
        Collections.shuffle(names);
        return names.get(0);
    }

    public List<Cup> getPreparedCups() {
        return new ArrayList<>(preparedCups);
    }
}
