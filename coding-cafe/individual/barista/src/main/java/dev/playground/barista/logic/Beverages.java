package dev.playground.barista.logic;

import dev.playground.barista.domain.Beverage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class Beverages {

    private final BeveragesParser beveragesParser;

    private Set<Beverage> beverages;

    public Beverages(BeveragesParser beveragesParser) {
        this.beveragesParser = beveragesParser;
    }

    @PostConstruct
    private void initialise() {
        beverages = beveragesParser.asSet();
    }

    public List<Beverage> findAll() {
        return beverages.stream()
                .collect(Collectors.toList());
    }

    public Optional<Beverage> prepare(String beverageName) {
        Optional<Beverage> beverage = beverages.stream()
                .filter(e -> e.getName().equalsIgnoreCase(beverageName))
                .findFirst();

        if (!beverage.isPresent()) {
            return Optional.empty();
        }

        waitPreparationTime(2);
        return beverage;
    }

    private void waitPreparationTime(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
