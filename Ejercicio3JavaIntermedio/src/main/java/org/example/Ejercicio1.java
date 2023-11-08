package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio1 {
    public static List<String> convertirAMayusculas(List<String> lista) {
        return lista.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> strings = List.of("Hola", "Mundo", "en", "Java");
        List<String> resultado = convertirAMayusculas(strings);
        System.out.println(resultado);
    }
}
