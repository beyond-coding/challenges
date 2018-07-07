package com.beyondcoding.codingcafe.assistant.event.dispatcher;

import com.beyondcoding.codingcafe.assistant.api.dto.Plate;
import com.beyondcoding.codingcafe.assistant.event.dto.Product;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Service
@Log
public class ProductDispatcher {

    public void dispatch(Plate order) {
        Product product = parse(order);
        dispatch(product);
    }

    private Product parse(Plate order) {
        return Product.builder()
                .ticket(order.getTicket())
                .name(order.getFoodstuff().getName())
                .build();
    }

    private void dispatch(Product product) {
        log.info("Dispatching " + product);
    }
}
