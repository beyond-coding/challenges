package com.beyondcoding.rockscissorspaper.domain.shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Shapes {

    private static List<Shape> shapes = Stream.of(
            new Rock(), new Scissors(), new Paper(), new Lizard(), new Spock()
    ).collect(Collectors.toList());

    private Shapes() {
    }

    public static List<Shape> asList() {
        return new ArrayList<>(shapes);
    }

    public static Optional<Shape> from(String shape) {
        return shapes.stream()
                .filter(e -> e.getClass().getSimpleName().equalsIgnoreCase(shape))
                .findAny();
    }

    public static String asString() {
        return shapes.stream()
                .map(e -> e.getClass().getSimpleName())
                .collect(Collectors.joining(", "));
    }

}
