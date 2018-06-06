package com.beyondcoding.rockscissorspaper.logic.player;

import com.beyondcoding.rockscissorspaper.domain.shape.Shape;
import com.beyondcoding.rockscissorspaper.domain.shape.Shapes;
import com.beyondcoding.rockscissorspaper.view.Host;

import java.util.Optional;
import java.util.Scanner;

public class HumanPlayer implements Player {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public Shape play() {
        Optional<Shape> shape = Optional.empty();
        while (!shape.isPresent()) {
            shape = readShape();
        }
        return shape.get();
    }

    private Optional<Shape> readShape() {
        Host.get().displayShapeRequest();
        String shape = scanner.next();
        return Shapes.from(shape);
    }

    @Override
    public boolean wantsToPlayAgain() {
        Host.get().displayPlayAgainRequest();
        String choice = scanner.next();
        return "y".equalsIgnoreCase(choice);
    }
}
