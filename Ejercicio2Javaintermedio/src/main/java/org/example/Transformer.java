package org.example;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Transformer {
    public static List<Object> transformList(List<String> strings, Function<String, String> transformer) {
        return strings.stream()
                .map(transformer)
                .collect(Collectors.toList());
    }
}
