package com.beyondcoding.codingcafe.barista.logic;

import com.beyondcoding.codingcafe.barista.domain.Beverage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class Beverages {

    private final BeveragesParser beveragesParser;

    private Set<Beverage> beverages;

    @Value("${beverage.preparation.duration}")
    private Long preparationDuration;

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

        waitPreparationDuration();
        return beverage;
    }

    private void waitPreparationDuration() {
        try {
            Thread.sleep(preparationDuration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
