package com.beyondcoding.credit.creditcard.builder;

import com.beyondcoding.credit.creditcard.CreditCardBuilder;
import org.reflections.Reflections;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Builders {

    private static Builders instance = new Builders();

    private Set<CreditCardBuilder> builders = load();

    private Builders() {
    }

    public static Set<CreditCardBuilder> asSet() {
        return new HashSet<>(instance.getBuilders());
    }

    private Set<CreditCardBuilder> load() {
        String packageName = getClass().getPackage().getName();
        Reflections reflections = new Reflections(packageName);
        Set<Class<? extends AbstractCreditCardBuilder>> builders = reflections.getSubTypesOf(AbstractCreditCardBuilder.class);
        return builders.stream()
                .map(toInstance())
                .collect(Collectors.toSet());
    }

    private Function<Class<? extends AbstractCreditCardBuilder>, ? extends AbstractCreditCardBuilder> toInstance() {
        return clazz -> {
            try {
                return clazz.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            throw new IllegalStateException("Could not instantiate class: " + clazz.getSimpleName());
        };
    }

    private Set<CreditCardBuilder> getBuilders() {
        return builders;
    }
}
