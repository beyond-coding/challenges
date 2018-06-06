package com.beyondcoding.rockscissorspaper.logic.judge;


import com.beyondcoding.rockscissorspaper.domain.shape.Shape;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JudgeTest {

    private Judge judge = new Judge();

    private Shape shape1;

    private Shape shape2;

    @BeforeEach
    void beforeEach() {
        shape1 = Mockito.mock(Shape.class);
        shape2 = Mockito.mock(Shape.class);
    }

    @Test
    void testPlayer1Wins() {
        Mockito.when(shape1.defeats(shape2)).thenReturn(true);

        String winner = judge.getWinner(shape1, shape2);

        assertEquals("Player 1 wins.", winner);
    }

    @Test
    void testPlayer2Wins() {
        Mockito.when(shape2.defeats(shape1)).thenReturn(true);

        String winner = judge.getWinner(shape1, shape2);

        assertEquals("Player 2 wins.", winner);
    }

    @Test
    void testNobodyWins() {
        String winner = judge.getWinner(shape1, shape2);
        assertEquals("Nobody wins.", winner);
    }
}