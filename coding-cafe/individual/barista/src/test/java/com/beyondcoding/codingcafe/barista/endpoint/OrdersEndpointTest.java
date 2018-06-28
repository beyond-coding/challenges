package com.beyondcoding.codingcafe.barista.endpoint;

import com.beyondcoding.codingcafe.barista.domain.Cup;
import com.beyondcoding.codingcafe.barista.domain.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrdersEndpointTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void placeWithPathVariables() {
        Cup cup = restTemplate.getForObject("/orders/espresso/Timmy", Cup.class);

        assertEquals("Timmy", cup.getCustomer());
        assertEquals("Sarah", cup.getBarista());
        assertEquals("espresso", cup.getBeverage().getName());
    }

    @Test
    public void placeWithRequestBody() {
        Order order = new Order();
        order.setCustomer("Timmy");
        order.setProduct("Espresso");

        Cup cup = restTemplate.postForObject("/orders", order, Cup.class);

        assertEquals("Timmy", cup.getCustomer());
        assertEquals("Sarah", cup.getBarista());
        assertEquals("espresso", cup.getBeverage().getName());
    }
}