package ru.job4j.stream;

import java.util.Optional;
import java.util.function.Predicate;

public class Filter implements Method {
    private Predicate<Integer> predicate;

    public Filter(Predicate<Integer> predicate) {
        this.predicate = predicate;
    }

    @Override
    public Optional<Integer> execute(Integer number) {
        return predicate.test(number)
                ? Optional.of(number)
                : Optional.empty();
    }
}
