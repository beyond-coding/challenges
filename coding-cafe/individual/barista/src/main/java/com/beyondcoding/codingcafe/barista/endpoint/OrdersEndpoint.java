package com.beyondcoding.codingcafe.barista.endpoint;

import com.beyondcoding.codingcafe.barista.domain.Cup;
import com.beyondcoding.codingcafe.barista.domain.Order;
import com.beyondcoding.codingcafe.barista.logic.Baristas;
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
        order.setProduct(beverageName);
        order.setCustomer(customerName);
        return baristas.prepare(order).get();
    }

    @PostMapping
    Cup place(@RequestBody Order order) {
        return baristas.prepare(order).get();
    }

}
