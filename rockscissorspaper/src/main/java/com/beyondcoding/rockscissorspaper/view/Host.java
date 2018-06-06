package com.beyondcoding.rockscissorspaper.view;

import com.beyondcoding.rockscissorspaper.domain.Result;
import com.beyondcoding.rockscissorspaper.domain.shape.Shapes;

public class Host {

    private static Host host = new Host();

    private Host() {
    }

    public static Host get() {
        return host;
    }

    public void displayGreeting() {
        System.out.println("Welcome to the " + Shapes.asString() + " game!");
    }

    public void displayGoodbye() {
        System.out.println("Goodbye.");
    }

    public void displayShapeRequest() {
        System.out.print("Choose one (" + Shapes.asString() + "): ");
    }

    public void displayPlayAgainRequest() {
        System.out.print("Do you want to play again? (y,n): ");
    }

    public void display(Result result) {
        String shape1 = result.getShape1().getClass().getSimpleName();
        String shape2 = result.getShape2().getClass().getSimpleName();
        System.out.print(shape1 + " vs " + shape2 + ": ");
        System.out.println(result.getWinner());
    }
}
