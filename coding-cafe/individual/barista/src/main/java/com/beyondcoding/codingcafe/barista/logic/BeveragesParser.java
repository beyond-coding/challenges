package com.beyondcoding.codingcafe.barista.logic;

import com.beyondcoding.codingcafe.barista.domain.Beverage;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class BeveragesParser {

    private final ResourceLoader resourceLoader;

    public BeveragesParser(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }


    public Set<Beverage> asSet() {
        try {
            Resource resource = resourceLoader.getResource("classpath:beverages.csv");
            Path path = Paths.get(resource.getURI());
            return Files.lines(path)
                    .skip(1)
                    .map(line -> line.split(";"))
                    .map(columns -> toBeverage(columns))
                    .collect(Collectors.toSet());
        } catch (IOException e) {
            e.printStackTrace();
            return new HashSet<>();
        }
    }

    private Beverage toBeverage(String[] columns) {
        Beverage beverage = new Beverage();
        beverage.setName(columns[0]);
        return beverage;
    }
}
