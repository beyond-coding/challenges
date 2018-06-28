package com.beyondcoding.codingcafe.assistant.endpoint;

import com.beyondcoding.codingcafe.assistant.domain.Product;
import com.beyondcoding.codingcafe.assistant.domain.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsEndpoint {

    private final ProductRepository productRepository;

    public ProductsEndpoint(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    List<Product> findAll() {
        return productRepository.findAll();
    }

    @GetMapping("/{name}")
    Product byName(@PathVariable String name) {
        return productRepository.findOneByName(name).get();
    }

    @PostMapping
    Product order()
}
