package dev.playground.barista.endpoint;

import dev.playground.barista.domain.Cup;
import dev.playground.barista.domain.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrdersEndpointTest {

    @LocalServerPort
    private long port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void placeWithPathVariables() {
        String ordersUrl = "http://localhost:" + port + "/orders";

        Cup cup = restTemplate.getForObject(ordersUrl + "/espresso/Timmy", Cup.class);

        assertEquals("Timmy", cup.getCustomer());
        assertEquals("Sarah", cup.getBarista());
        assertEquals("espresso", cup.getBeverage().getName());
    }

    @Test
    public void placeWithRequestBody() {
        String ordersUrl = "http://localhost:" + port + "/orders";
        Order order = new Order();
        order.setCustomer("Timmy");
        order.setBeverage("Espresso");

        Cup cup = restTemplate.postForObject(ordersUrl, order, Cup.class);

        assertEquals("Timmy", cup.getCustomer());
        assertEquals("Sarah", cup.getBarista());
        assertEquals("espresso", cup.getBeverage().getName());
    }
}