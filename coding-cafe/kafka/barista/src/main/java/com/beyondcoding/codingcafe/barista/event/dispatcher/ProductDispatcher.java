package com.beyondcoding.codingcafe.barista.event.dispatcher;

import com.beyondcoding.codingcafe.barista.api.dto.Cup;
import com.beyondcoding.codingcafe.barista.event.dto.Product;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Service
@Log
public class ProductDispatcher {

    public void dispatch(Cup order) {
        Product product = parse(order);
        dispatch(product);
    }

    private Product parse(Cup order) {
        return Product.builder()
                .ticket(order.getTicket())
                .name(order.getBeverage().getName())
                .build();
    }

    private void dispatch(Product product) {
        log.info("Dispatching " + product);
    }
}
