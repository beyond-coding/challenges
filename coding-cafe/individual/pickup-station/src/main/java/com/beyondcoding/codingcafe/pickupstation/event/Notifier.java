package com.beyondcoding.codingcafe.pickupstation.event;

import com.beyondcoding.codingcafe.pickupstation.domain.PurchaseStatus;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Service
@Log
public class Notifier {

    public void notify(PurchaseStatus purchaseStatus) {
        log.info("Notifying customer for " + purchaseStatus);
    }
}
