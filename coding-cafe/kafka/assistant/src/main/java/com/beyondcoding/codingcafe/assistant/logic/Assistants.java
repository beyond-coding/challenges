package com.beyondcoding.codingcafe.assistant.logic;

import com.beyondcoding.codingcafe.assistant.api.dto.Order;
import com.beyondcoding.codingcafe.assistant.api.dto.Plate;
import com.beyondcoding.codingcafe.assistant.event.PlateDispatcher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Assistants {

    private final Counter counter;

    private final Stocker stocker;

    private final PlateDispatcher dispatcher;

    public Plate process(Order order) {
        Optional<Plate> plate = counter.fetch(order);
        if (!plate.isPresent()) {
            stocker.restock();
            plate = counter.fetch(order);
        }
        dispatcher.dispatch(plate.get());
        return plate.get();
    }
}
