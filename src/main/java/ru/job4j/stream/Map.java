package ru.job4j.stream;

import java.util.Optional;
import java.util.function.Function;

public class Map implements Method {
    private Function<Integer, Integer> function;

    public Map(Function<Integer, Integer> function) {
        this.function = function;
    }

    @Override
    public Optional<Integer> execute(Integer number) {
        return Optional.of(
                function.apply(number));
    }
}
