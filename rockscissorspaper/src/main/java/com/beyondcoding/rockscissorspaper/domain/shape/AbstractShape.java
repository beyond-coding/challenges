package com.beyondcoding.rockscissorspaper.domain.shape;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class AbstractShape implements Shape {

    private Set<Class<? extends Shape>> defeats;

    AbstractShape(Class<? extends Shape>... defeats) {
        this.defeats = Stream.of(defeats).collect(Collectors.toSet());
    }

    @Override
    public boolean defeats(Shape shape) {
        return defeats.contains(shape.getClass());
    }
}
