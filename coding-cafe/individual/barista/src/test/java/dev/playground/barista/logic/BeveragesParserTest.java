package dev.playground.barista.logic;

import dev.playground.barista.domain.Beverage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.springframework.util.Assert.isTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BeveragesParserTest {

    @Autowired
    private BeveragesParser parser;

    @Test
    public void asSet() {
        Set<Beverage> beverages = parser.asSet();
        assertEquals(1, beverages.size());

        Beverage beverage = beverages.stream().findFirst().get();
        assertEquals("espresso", beverage.getName());
        isTrue(beverage.getIngredients().contains("coffee"), "Coffee is an ingredient");
    }
}