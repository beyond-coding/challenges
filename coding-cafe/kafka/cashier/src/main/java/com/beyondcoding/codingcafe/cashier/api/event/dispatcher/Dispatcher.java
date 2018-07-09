package com.beyondcoding.codingcafe.cashier.api.event.dispatcher;

import com.beyondcoding.codingcafe.cashier.api.dto.Order;
import com.beyondcoding.codingcafe.cashier.persistence.domain.ProductKind;
import lombok.RequiredArgsConstructor;

import javax.annotation.PostConstruct;

@RequiredArgsConstructor
public abstract class Dispatcher {

    private final ProductKind productKind;

    private final Dispatchers dispatchers;

    @PostConstruct
    private void init() {
        dispatchers.register(this);
    }

    public abstract void dispatch(Order order);

    ProductKind getProductKind() {
        return productKind;
    }
}
