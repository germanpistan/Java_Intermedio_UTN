package org.example;

class EstadoEnAuge implements Estado {
    @Override
    public void reproducir(Cancion cancion) {
        cancion.aumentarReproducciones();
        if (cancion.getReproducciones() > 50000 && cancion.getLikes() > 20000) {
            cancion.setEstado(new EstadoEnTendencia());
        } else if (cancion.getDislikes() >= 5000) {
            cancion.setEstado(new EstadoNormal());
        }
    }

    @Override
    public void darLike(Cancion cancion) {
        cancion.aumentarLikes();
    }

    @Override
    public void darDislike(Cancion cancion) {
        cancion.aumentarDislikes();
        if (cancion.getDislikes() >= 5000) {
            cancion.setEstado(new EstadoNormal());
        }
    }

    @Override
    public String mostrarDetalle(Cancion cancion) {
        return Icono.ROCKET.texto() + " - " + cancion.mostrarDetalle();
    }
}
