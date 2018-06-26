package dev.playground.barista.logic;

import dev.playground.barista.domain.Cup;
import dev.playground.barista.domain.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaristasTest {

    @Autowired
    private Baristas baristas;

    @Test
    public void testEspressoIsPrepared() {
        Order order = new Order();
        order.setCustomer("Timmy");
        order.setBeverage("espresso");

        Optional<Cup> cup = baristas.prepare(order);

        assertTrue(cup.isPresent());
        assertEquals("espresso", cup.get().getBeverage().getName());
        assertEquals("Sarah", cup.get().getBarista());
    }
}