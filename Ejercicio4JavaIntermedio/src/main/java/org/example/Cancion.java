package org.example;

import java.time.LocalDateTime;

public class Cancion {


    private String titulo;
    private String artista;
    private String album;
    private int annoAlbum;
    private int reproducciones;
    private int likes;
    private int dislikes;
    private LocalDateTime ultimaReproduccion;
    private Estado estado;

    public Cancion(String titulo, String artista, String album, int annoAlbum) {
        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.annoAlbum = annoAlbum;
        this.estado = new EstadoNormal();
    }

    public void reproducir() {
        estado.reproducir(this);
    }

    public void darLike() {
        estado.darLike(this);
    }

    public void darDislike() {
        estado.darDislike(this);
    }

    public String mostrarDetalle() {
        return estado.mostrarDetalle(this);
    }

    public void aumentarReproducciones() {
        this.reproducciones++;
    }

    public void aumentarLikes() {
        this.likes++;
    }

    public void aumentarDislikes() {
        this.dislikes++;
    }

    public int getReproducciones() {
        return reproducciones;
    }

    public int getLikes() {
        return likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public LocalDateTime getUltimaReproduccion() {
        return ultimaReproduccion;
    }

    public void setUltimaReproduccion(LocalDateTime ultimaReproduccion) {
        this.ultimaReproduccion = ultimaReproduccion;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
