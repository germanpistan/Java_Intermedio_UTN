package org.example;

interface Estado {
    void reproducir(Cancion cancion);

    void darLike(Cancion cancion);

    void darDislike(Cancion cancion);

    String mostrarDetalle(Cancion cancion);
}
