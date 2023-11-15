package org.example;

class EstadoNormal implements Estado {
    @Override
    public void reproducir(Cancion cancion) {
        cancion.aumentarReproducciones();
        if (cancion.getReproducciones() > 1000) {
            cancion.setEstado(new EstadoEnAuge());
        }
    }

    @Override
    public void darLike(Cancion cancion) {
        // No tiene efecto en este estado
    }

    @Override
    public void darDislike(Cancion cancion) {
        // No tiene efecto en este estado
    }

    @Override
    public String mostrarDetalle(Cancion cancion) {
        return Icono.MUSICAL_NOTE.texto() + " - " + cancion.mostrarDetalle();
    }
}
