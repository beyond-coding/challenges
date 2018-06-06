package com.beyondcoding.rockscissorspaper.logic.player;

import com.beyondcoding.rockscissorspaper.domain.shape.Shape;
import com.beyondcoding.rockscissorspaper.domain.shape.Shapes;

import java.util.Collections;
import java.util.List;

public class ComputerPlayer implements Player {

    @Override
    public Shape play() {
        List<Shape> shapes = Shapes.asList();
        Collections.shuffle(shapes);
        return shapes.get(0);
    }

    @Override
    public boolean wantsToPlayAgain() {
        return true;
    }
}
