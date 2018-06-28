package com.beyondcoding.codingcafe.cashier.event.dispatcher;

import com.beyondcoding.codingcafe.cashier.event.dto.Order;
import com.beyondcoding.codingcafe.cashier.persistence.domain.ProductKind;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class Dispatchers {

    private Map<ProductKind, Dispatcher> dispatchers = new HashMap<>();

    void register(Dispatcher dispatcher) {
        dispatchers.put(dispatcher.getProductKind(), dispatcher);
    }

    public void dispatch(List<Order> orders) {
        orders.forEach(order -> dispatchers.get(order.getKind()).dispatch(order));
    }

}
