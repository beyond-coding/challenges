package com.beyondcoding.codingcafe.barista.logic;

import com.beyondcoding.codingcafe.barista.api.dto.Beverage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class BeveragesTest {

    @Autowired
    private Beverages beverages;

    @Test
    public void testFindAll() {
        List<Beverage> all = beverages.findAll();
        assertEquals(3, all.size());

        assertContains("capuccino", all);
        assertContains("macchiato", all);
        assertContains("chocolate", all);
    }

    private void assertContains(String beverage, List<Beverage> all) {
        boolean exists = all.stream()
                .map(Beverage::getName)
                .anyMatch(e -> e.equals(beverage));
        assertTrue(beverage + " exists", exists);
    }
}