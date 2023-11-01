package org.example;

import java.util.List;

public class Inscripcion {
    private Alumno alumno;
    private Materia materia;

    public Inscripcion(Alumno alumno, Materia materia) {
        this.alumno = alumno;
        this.materia = materia;
        alumno.getInscripciones().add(this); // Agregar esta inscripción a la lista del alumno.
    }

    public boolean aprobada() {
        List<Materia> correlativas = materia.getCorrelativas();
        for (Materia correlativa : correlativas) {
            boolean encontrada = false;
            for (Inscripcion inscripcion : alumno.getInscripciones()) {
                if (inscripcion.getMateria() == correlativa) {
                    encontrada = true;
                    break;
                }
            }
            if (!encontrada) {
                return false;
            }
        }
        return true;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public Materia getMateria() {
        return materia;
    }
}
