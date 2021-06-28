package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private List<Integer> source;

    private EasyStream() {
    }

    public static EasyStream of(List<Integer> source) {
        return new Builder()
                .buildSource(source)
                .build();
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> rslList = new ArrayList<>();
        source.forEach(number -> rslList.add(
                fun.apply(number)));
        return new Builder()
                .buildSource(rslList)
                .build();
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> rslList = new ArrayList<>();
        source.forEach(number -> {
                if (fun.test(number)) {
                    rslList.add(number);
                }
        });
        return new Builder()
                .buildSource(rslList)
                .build();
    }

    public List<Integer> collect() {
        return source;
    }

    static class Builder {
        private List<Integer> source;

        Builder buildSource(List<Integer> source) {
            this.source = source;
            return this;
        }

        EasyStream build() {
            var easyStream = new EasyStream();
            easyStream.source = source;
            return easyStream;
        }
    }
}