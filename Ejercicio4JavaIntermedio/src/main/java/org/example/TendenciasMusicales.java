package org.example;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TendenciasMusicales {

    public static void main(String[] args) {
        // Casos de prueba
        testCaso1();
        testCaso2();
        testCaso3();
        testCaso4();
        testCaso5();
    }

    static void testCaso1() {
        Cancion theScientist = new Cancion("The Scientist", "Coldplay", "A Rush of Blood to the Head", 2002);
        System.out.println(theScientist.mostrarDetalle());
    }

    static void testCaso2() {
        Cancion theScientist = new Cancion("The Scientist", "Coldplay", "A Rush of Blood to the Head", 2002);
        theScientist.aumentarReproducciones(1500);
        System.out.println(theScientist.mostrarDetalle());
    }

    static void testCaso3() {
        Cancion theScientist = new Cancion("The Scientist", "Coldplay", "A Rush of Blood to the Head", 2002);
        theScientist.aumentarReproducciones(1500);
        theScientist.aumentarDislikes(5000);
        System.out.println(theScientist.mostrarDetalle());
    }

    static void testCaso4() {
        Cancion theScientist = new Cancion("The Scientist", "Coldplay", "A Rush of Blood to the Head", 2002);
        theScientist.aumentarReproducciones(100000);
        theScientist.aumentarLikes(25000);
        System.out.println(theScientist.mostrarDetalle());
    }

    static void testCaso5() {
        Cancion theScientist = new Cancion("The Scientist", "Coldplay", "A Rush of Blood to the Head", 2002);
        theScientist.aumentarReproducciones(100000);
        theScientist.aumentarLikes(25000);
        theScientist.setUltimaReproduccion(LocalDateTime.now().minusHours(25));
        System.out.println(theScientist.mostrarDetalle());
    }
}

class Cancion {
    private String titulo;
    private String artista;
    private String album;
    private int annoAlbum;
    private int reproducciones;
    private int likes;
    private int dislikes;
    private LocalDateTime ultimaReproduccion;

    public Cancion(String titulo, String artista, String album, int annoAlbum) {
        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.annoAlbum = annoAlbum;
    }

    public void aumentarReproducciones(int cantidad) {
        this.reproducciones += cantidad;
        actualizarPopularidad();
    }

    public void aumentarLikes(int cantidad) {
        this.likes += cantidad;
        actualizarPopularidad();
    }

    public void aumentarDislikes(int cantidad) {
        this.dislikes += cantidad;
        if (this.dislikes >= 5000) {
            // Volver a popularidad normal
            this.ultimaReproduccion = null;
        }
        actualizarPopularidad();
    }

    public void setUltimaReproduccion(LocalDateTime ultimaReproduccion) {
        this.ultimaReproduccion = ultimaReproduccion;
        actualizarPopularidad();
    }

    private void actualizarPopularidad() {
        if (reproducciones <= 1000) {
            // Popularidad normal
            mostrarDetalle(Icono.MUSICAL_NOTE, formatoNormal());
        } else if (reproducciones <= 50000 && likes >= 20000) {
            // Popularidad en auge
            mostrarDetalle(Icono.ROCKET, formatoAuge());
        } else if (reproducciones > 50000 && likes >= 20000) {
            // Popularidad en tendencia
            mostrarDetalle(Icono.FIRE, formatoTendencia());
        } else {
            // Volver a popularidad normal si no cumple ninguna condición
            this.ultimaReproduccion = null;
            mostrarDetalle(Icono.MUSICAL_NOTE, formatoNormal());
        }
    }

    public String mostrarDetalle(Icono icono, String leyenda) {
        return String.format("%s - %s", icono.texto(), leyenda);
    }

    private String formatoNormal() {
        return String.format("%s - %s - %s", artista, album, titulo);
    }

    private String formatoAuge() {
        return String.format("%s - %s (%s - %d)", artista, titulo, album, annoAlbum);
    }

    private String formatoTendencia() {
        return String.format("%s - %s (%s - %d)", titulo, artista, album, annoAlbum);
    }

    public String mostrarDetalle() {
        return null;
    }
}

class Icono {
    public static Icono MUSICAL_NOTE = new Icono("MUSICAL NOTE", new int[]{0xD83C, 0xDFB5});
    public static Icono ROCKET = new Icono("ROCKET", new int[]{0xD83D, 0xDE80});
    public static Icono FIRE = new Icono("FIRE", new int[]{0xD83D, 0xDD25});

    private String nombre;
    private int[] internalEncoding;

    public Icono(String nombre, int[] internalEncoding) {
        this.nombre = nombre;
        this.internalEncoding = internalEncoding;
    }

    public String texto() {
        return new String(internalEncoding, 0, internalEncoding.length);
    }
}
