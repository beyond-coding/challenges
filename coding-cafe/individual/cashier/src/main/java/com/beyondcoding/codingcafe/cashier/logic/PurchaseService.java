package com.beyondcoding.codingcafe.cashier.logic;

import com.beyondcoding.codingcafe.cashier.api.dto.Purchase;
import com.beyondcoding.codingcafe.cashier.event.dto.Order;
import com.beyondcoding.codingcafe.cashier.event.dispatcher.Dispatchers;
import com.beyondcoding.codingcafe.cashier.persistence.domain.Ticket;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseService {

    private final TicketService ticketService;

    private final OrderService orderService;

    private final Dispatchers dispatchers;

    public List<Ticket> findTickets() {
        return ticketService.findAll();
    }

    public Ticket process(Purchase purchase) {
        Ticket ticket = ticketService.process(purchase);
        List<Order> orders = orderService.from(ticket);
        dispatchers.dispatch(orders);
        return ticket;
    }
}
