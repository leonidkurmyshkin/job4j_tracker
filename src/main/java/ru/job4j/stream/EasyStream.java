package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private List<Integer> source;
    private List<Method> intermediateMethods;

    private EasyStream(List<Integer> source) {
        this.source = source;
        intermediateMethods = new ArrayList<>();
    }

    public static EasyStream of(List<Integer> source) {
        return new EasyStream(source);
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        intermediateMethods.add(
                new Map(fun));
        return this;
    }

    public EasyStream filter(Predicate<Integer> fun) {
        intermediateMethods.add(
                new Filter(fun));
        return this;
    }

    public List<Integer> collect() {
        List<Integer> rslList = new ArrayList<>();
        next: for (var rsl : source) {
            for (var method : intermediateMethods) {
                var optRsl = method.execute(rsl);
                if (optRsl.isEmpty()) {
                    continue next;
                }
                rsl = optRsl.get();
            }
            rslList.add(rsl);
        }
        return rslList;
    }
}