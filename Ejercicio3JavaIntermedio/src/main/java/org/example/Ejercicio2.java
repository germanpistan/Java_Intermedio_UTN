package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio2 {
    public static String concatenarPalabrasMasLargasQue(List<String> lista, int n) {
        return lista.stream()
                .filter(s -> s.length() > n)
                .collect(Collectors.joining(", "));
    }

    public static void main(String[] args) {
        List<String> strings = List.of("Hola", "Soy german", "intentando", "hacer lambdas");
        int n = 3;
        String resultado = concatenarPalabrasMasLargasQue(strings, n);
        System.out.println(resultado);
    }
}
