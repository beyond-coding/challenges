package com.beyondcoding.codingcafe.assistant.event;

import com.beyondcoding.codingcafe.assistant.api.dto.Plate;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Service
@Log
public class PlateDispatcher {

    public void dispatch(Plate plate) {
        log.info("Dispatched " + plate);
    }
}
