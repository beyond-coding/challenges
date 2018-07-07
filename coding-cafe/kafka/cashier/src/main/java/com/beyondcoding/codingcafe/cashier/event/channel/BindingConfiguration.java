package com.beyondcoding.codingcafe.cashier.event.channel;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding({Binding.class})
public class BindingConfiguration {
}
