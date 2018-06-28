package com.beyondcoding.codingcafe.cashier.api.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Purchase {

    private String customer;

    private List<String> products = new ArrayList<>();

}
