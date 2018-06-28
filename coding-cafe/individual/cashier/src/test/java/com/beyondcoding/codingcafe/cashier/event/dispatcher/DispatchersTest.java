package com.beyondcoding.codingcafe.cashier.event.dispatcher;

import com.beyondcoding.codingcafe.cashier.event.dto.Order;
import com.beyondcoding.codingcafe.cashier.persistence.domain.ProductKind;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class DispatchersTest {

    @Autowired
    private Dispatchers dispatchers;

    @SpyBean
    private BeverageDispatcher beverageDispatcher;

    @SpyBean
    private FoodstuffDispatcher foodstuffDispatcher;

    @Test
    public void dispatchBeverage() {
        List<Order> orders = createOrders(ProductKind.BEVERAGE);
        dispatchers.dispatch(orders);
//        verify(beverageDispatcher).dispatch(any());
        verify(foodstuffDispatcher, never()).dispatch(any());
    }

    private List<Order> createOrders(ProductKind kind) {
        Order order = Order.builder()
                .kind(kind)
                .build();
        return Arrays.asList(order);
    }

    @Test
    public void dispatchFoodstuff() {
        List<Order> orders = createOrders(ProductKind.FOODSTUFF);
        dispatchers.dispatch(orders);
//        verify(foodstuffDispatcher).dispatch(any(Order.class));
        verify(beverageDispatcher, never()).dispatch(any(Order.class));
    }
}