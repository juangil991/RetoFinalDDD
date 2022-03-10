package co.com.sofka.domain.servicioscaballero;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.servicioscaballero.valor.Complejidad;
import co.com.sofka.domain.servicioscaballero.valor.EstiloCorte;
import co.com.sofka.domain.servicioscaballero.valor.IdCorteCaballero;

import java.util.Objects;

public class CorteCaballero extends Entity<IdCorteCaballero> {
    private Complejidad complejidad;
    private EstiloCorte estiloCorte;

    public CorteCaballero(IdCorteCaballero idCorteCaballero, Complejidad complejidad, EstiloCorte estiloCorte) {
        super(idCorteCaballero);
        this.complejidad = complejidad;
        this.estiloCorte = estiloCorte;
    }

    public void ActualizarComplejidad(Complejidad complejidad){
        this.complejidad= Objects.requireNonNull(complejidad);
    }

    public void ActualizarEstiloCorte(EstiloCorte estiloCorte){
        this.estiloCorte=Objects.requireNonNull(estiloCorte);
    }

    public Complejidad Complejidad() {
        return complejidad;
    }

    public EstiloCorte EstiloCorte() {
        return estiloCorte;
    }
}
