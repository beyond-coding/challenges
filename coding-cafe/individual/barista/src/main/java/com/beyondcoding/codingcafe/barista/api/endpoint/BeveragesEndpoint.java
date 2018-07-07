package com.beyondcoding.codingcafe.barista.api.endpoint;

import com.beyondcoding.codingcafe.barista.api.dto.Beverage;
import com.beyondcoding.codingcafe.barista.logic.Beverages;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/beverages")
@RequiredArgsConstructor
public class BeveragesEndpoint {

    private final Beverages beverages;

    @GetMapping
    List<Beverage> findAll() {
        return beverages.findAll();
    }
}
