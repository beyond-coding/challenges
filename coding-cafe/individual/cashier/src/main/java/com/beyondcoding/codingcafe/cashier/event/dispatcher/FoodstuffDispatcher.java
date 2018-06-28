package com.beyondcoding.codingcafe.cashier.event.dispatcher;

import com.beyondcoding.codingcafe.cashier.event.dto.Order;
import com.beyondcoding.codingcafe.cashier.persistence.domain.ProductKind;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Service
@Log
public class FoodstuffDispatcher extends Dispatcher {

    public FoodstuffDispatcher(Dispatchers dispatchers) {
        super(ProductKind.FOODSTUFF, dispatchers);
    }

    @Override
    public void dispatch(Order order) {
        log.info("Dispatching " + order);
    }
}
