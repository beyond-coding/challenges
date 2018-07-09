package com.beyondcoding.codingcafe.cashier.api.event.dispatcher;

import com.beyondcoding.codingcafe.cashier.api.dto.Order;
import com.beyondcoding.codingcafe.cashier.api.event.notifier.Notifier;
import com.beyondcoding.codingcafe.cashier.logic.OrderService;
import com.beyondcoding.codingcafe.cashier.persistence.domain.ProductKind;
import com.beyondcoding.codingcafe.cashier.persistence.domain.Ticket;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class Dispatchers {

    private final Notifier notifier;

    private final OrderService orderService;

    private Map<ProductKind, Dispatcher> dispatchers = new HashMap<>();

    void register(Dispatcher dispatcher) {
        dispatchers.put(dispatcher.getProductKind(), dispatcher);
    }

    public void dispatch(Ticket ticket) {
        notifier.notify(ticket);
        dispatchOrders(ticket);
    }

    private void dispatchOrders(Ticket ticket) {
        List<Order> orders = orderService.from(ticket);
        orders.forEach(order -> dispatchers.get(order.getKind()).dispatch(order));
    }

}
