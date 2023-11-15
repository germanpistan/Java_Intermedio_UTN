package org.example;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

class EstadoEnTendencia implements Estado {
    @Override
    public void reproducir(Cancion cancion) {
        cancion.aumentarReproducciones();
        if (cancion.getUltimaReproduccion() == null ||
                ChronoUnit.HOURS.between(cancion.getUltimaReproduccion(), LocalDateTime.now()) > 24) {
            cancion.setEstado(new EstadoNormal());
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
        return Icono.FIRE.texto() + " - " + cancion.mostrarDetalle();
    }
}
