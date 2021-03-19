package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmpDeps = new LinkedHashSet<>();
        for (String dep : deps) {
            StringBuilder depFullName = new StringBuilder();
            String sep = "";
            for (String depName : dep.split("/")) {
                tmpDeps.add(
                        depFullName.append(sep).append(depName)
                                .toString()
                );
                sep = "/";
            }
        }
        return new ArrayList<>(tmpDeps);
    }

    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }
}