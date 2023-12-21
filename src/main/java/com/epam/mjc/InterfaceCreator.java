package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> x.get(0).charAt(0)>64 && x.get(0).charAt(0)<91;
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            List<Integer> even = new ArrayList<>();
            x.forEach(integer -> {
                if (integer % 2 == 0) {
                    even.add(integer);
                }
            });
            x.addAll(even);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return ()->
            values.stream()
                    .filter(s -> {
                        boolean capLet = s.charAt(0) > 64 && s.charAt(0) < 91;
                        boolean dot = s.endsWith(".");
                        boolean words = (s.split(" ").length) > 3;
                        return capLet && dot && words;
                    }).collect(Collectors.toList());
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return strings -> strings.stream().collect(Collectors.toMap(Function.identity(),String::length));
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return ((list, list2) -> {
            List<Integer> res = new ArrayList<>(list.size()+ list2.size());
            res.addAll(list);
            res.addAll(list2);
            return res;
        });
    }
}
