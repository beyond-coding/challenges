package com.beyondcoding.codingcafe.assistant.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void findAll() {
        List<Product> products = productRepository.findAll();

        assertEquals(3, products.size());
        assertExists(products, "muffin");
        assertExists(products, "cheese-cake");
        assertExists(products, "cookie");
    }

    private void assertExists(List<Product> products, String product) {
        boolean exists = products.stream()
                .anyMatch(e -> e.getName().equals(product));
        assertTrue("Product exists", exists);
    }

    @Test
    public void findOneByName() {
        Optional<Product> muffin = productRepository.findOneByName("muffin");
        assertTrue("Muffin exists", muffin.isPresent());
        assertNotNull(muffin.get().getId());

        Optional<Product> tiramisu = productRepository.findOneByName("tiramisu");
        assertFalse("Tiramisu doesn't exist", tiramisu.isPresent());
    }
}