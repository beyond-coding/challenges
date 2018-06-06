package com.beyondcoding.rockscissorspaper.logic.judge;

import com.beyondcoding.rockscissorspaper.domain.Result;
import com.beyondcoding.rockscissorspaper.domain.shape.Shape;

public class Judge {

    public Result judge(Shape shape1, Shape shape2) {
        return Result.builder()
                .shape1(shape1)
                .shape2(shape2)
                .winner(getWinner(shape1, shape2))
                .build();
    }

    String getWinner(Shape shape1, Shape shape2) {
        if (shape1.defeats(shape2)) {
            return "Player 1 wins.";
        }
        if (shape2.defeats(shape1)) {
            return "Player 2 wins.";
        }
        return "Nobody wins.";
    }

}
