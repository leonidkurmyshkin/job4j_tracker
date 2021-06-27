package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private EasyStream firstStream;
    private EasyStream nextStream;
    private Method method;
    private List<Integer> source;
    private Function<Integer, Integer> mapFunction;
    private Predicate<Integer> filterPredicate;

    enum Method {
        OF, MAP, FILTER, COLLECT
    }

    private EasyStream() {
    }

    public static EasyStream of(List<Integer> source) {
        var firstStream = new Builder()
                .buildSource(source)
                .build();
        firstStream.firstStream = firstStream;
        return firstStream;
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        nextStream = new Builder()
                .buildMap(fun)
                .buildFirstStream(firstStream)
                .build();
        return nextStream;
    }

    public EasyStream filter(Predicate<Integer> fun) {
        nextStream = new Builder()
                .buildFilter(fun)
                .buildFirstStream(firstStream)
                .build();
        return nextStream;
    }

    public List<Integer> collect() {
        nextStream =  new Builder()
                .buildCollect()
                .buildFirstStream(firstStream)
                .build();
        return firstStream.processStream();
    }

    private List<Integer> processStream() {
        List<Integer> rslList = new ArrayList<>();
        for (var rsl : source) {
            boolean isNotSkip = true;
            for (var chainStream = firstStream;
                    chainStream != null && isNotSkip;
                    chainStream = chainStream.nextStream
            ) {
                switch (chainStream.method) {
                    case MAP:
                        rsl = chainStream.mapFunction
                                .apply(rsl);
                        break;
                    case FILTER:
                        if (chainStream.filterPredicate
                                .negate()
                                .test(rsl)) {
                            isNotSkip = false;
                        }
                        break;
                    case COLLECT:
                        rslList.add(rsl);
                        break;
                    default:
                }
            }
        }
        return rslList;
    }

    static class Builder {
        private EasyStream firstStream;
        private Method method;
        private List<Integer> source;
        private Function<Integer, Integer> mapFunction;
        private Predicate<Integer> filterPredicate;

        Builder buildFirstStream(EasyStream firstStream) {
            this.firstStream = firstStream;
            return this;
        }

        Builder buildSource(List<Integer> source) {
            method = Method.OF;
            this.source = source;
            return this;
        }

        Builder buildMap(Function<Integer, Integer> fun) {
            method = Method.MAP;
            mapFunction = fun;
            return this;
        }

        Builder buildFilter(Predicate<Integer> fun) {
            method = Method.FILTER;
            filterPredicate = fun;
            return this;
        }

        Builder buildCollect() {
            method = Method.COLLECT;
            return this;
        }

        EasyStream build() {
            var easyStream = new EasyStream();
            easyStream.firstStream = firstStream;
            easyStream.method = method;
            easyStream.source = source;
            easyStream.mapFunction = mapFunction;
            easyStream.filterPredicate = filterPredicate;
            return easyStream;
        }
    }
}