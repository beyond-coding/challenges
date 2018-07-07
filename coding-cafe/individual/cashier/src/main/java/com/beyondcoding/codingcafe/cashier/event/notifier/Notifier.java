package com.beyondcoding.codingcafe.cashier.event.notifier;

import com.beyondcoding.codingcafe.cashier.event.dto.Purchase;
import com.beyondcoding.codingcafe.cashier.persistence.domain.Product;
import com.beyondcoding.codingcafe.cashier.persistence.domain.Ticket;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@Log
public class Notifier {

    public void notify(Ticket ticket) {
        Purchase purchase = createPurchase(ticket);
        notify(purchase);
    }

    private Purchase createPurchase(Ticket ticket) {
        return Purchase.builder()
                .ticket(ticket.getId())
                .customer(ticket.getCustomer())
                .products(
                        ticket.getProducts().stream()
                                .map(Product::getName)
                                .collect(Collectors.toList())
                )
                .build();
    }

    private void notify(Purchase purchase) {
        log.info("Notifying " + purchase);
    }
}
