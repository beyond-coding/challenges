package com.beyondcoding.codingcafe.cashier.event.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Binding {

    @Output("purchases")
    MessageChannel purchases();

    @Output("beverages")
    MessageChannel beverages();

    @Output("foodstuffs")
    MessageChannel foodstuffs();

}
