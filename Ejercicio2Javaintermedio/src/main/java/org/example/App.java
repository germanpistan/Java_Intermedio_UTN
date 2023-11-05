package org.example;

import java.util.List;
import java.util.function.Function;

import static org.example.Transformer.transformList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
    List<String> inputList = List.of("lista", "de minusculas", "para transformar", "a mayusculas", "usando lambdas", "y interfaces funcionales");

    Function<String, String> toUpperCaseTransformer = String::toUpperCase;
    List<Object> transformedList = transformList(inputList, toUpperCaseTransformer);

        System.out.println("Lista Original: " + inputList);
        System.out.println("Lista Transformada: " + transformedList);
}}

