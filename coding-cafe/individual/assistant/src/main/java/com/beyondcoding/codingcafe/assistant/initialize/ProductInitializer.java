package com.beyondcoding.codingcafe.assistant.initialize;

import com.beyondcoding.codingcafe.assistant.domain.Product;
import com.beyondcoding.codingcafe.assistant.domain.ProductRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("assistant")
public class ProductInitializer {

    List<String> products;

    @Bean
    ApplicationRunner initializeProducts(ProductRepository productRepository) {
        return args -> {
            productRepository.deleteAll();
            products.stream()
                    .map(Product::new)
                    .forEach(productRepository::save);
        };
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }
}
