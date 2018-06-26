package dev.playground.barista.endpoint;

import dev.playground.barista.domain.Cup;
import dev.playground.barista.domain.Order;
import dev.playground.barista.logic.Baristas;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersEndpoint {

    private final Baristas baristas;

    public OrdersEndpoint(Baristas baristas) {
        this.baristas = baristas;
    }

    @GetMapping
    List<Cup> findAll() {
        return baristas.getPreparedCups();
    }

    @GetMapping("/{beverageName}/{customerName}")
    Cup place(@PathVariable String beverageName, @PathVariable String customerName) {
        Order order = new Order();
        order.setBeverage(beverageName);
        order.setCustomer(customerName);
        return baristas.prepare(order).get();
    }

    @PostMapping
    Cup place(@RequestBody Order order) {
        return baristas.prepare(order).get();
    }

}
