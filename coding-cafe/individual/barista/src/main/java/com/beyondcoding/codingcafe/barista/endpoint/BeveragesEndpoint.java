package com.beyondcoding.codingcafe.barista.endpoint;

import com.beyondcoding.codingcafe.barista.domain.Beverage;
import com.beyondcoding.codingcafe.barista.logic.Beverages;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/beverages")
public class BeveragesEndpoint {

    private Beverages beverages;

    public BeveragesEndpoint(Beverages beverages) {
        this.beverages = beverages;
    }

    @GetMapping
    List<Beverage> findAll() {
        return beverages.findAll();
    }
}
