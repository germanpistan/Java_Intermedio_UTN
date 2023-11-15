package org.example;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Icono {
    public static final Icono MUSICAL_NOTE = new Icono("MUSICAL NOTE", new int[]{0xD83C, 0xDFB5});
    public static final Icono ROCKET = new Icono("ROCKET", new int[]{0xD83D, 0xDE80});
    public static final Icono FIRE = new Icono("FIRE", new int[]{0xD83D, 0xDD25});

    private final String nombre;
    private final int[] internalEncoding;

    private Icono(String nombre, int[] internalEncoding) {
        this.nombre = nombre;
        this.internalEncoding = internalEncoding;
    }

    public String texto() {
        return new String(internalEncoding, 0, internalEncoding.length);
    }
}


