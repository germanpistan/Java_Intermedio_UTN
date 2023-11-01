package org.example;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private String name;
    private int number;

    private List<Inscripcion> inscripciones;

    public Alumno(String name, int number) {
        this.name = name;
        this.number = number;
        this.inscripciones = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getNumber(){
        return number;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }


}
