package co.com.sofka.domain.servicioscaballero.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.servicioscaballero.valor.Complejidad;
import co.com.sofka.domain.servicioscaballero.valor.EstiloCorte;
import co.com.sofka.domain.servicioscaballero.valor.IdCorteCaballero;

public class CorteCaballeroAgregado extends DomainEvent {
    private final IdCorteCaballero idCorteCaballero;
    private final Complejidad complejidad;
    private final EstiloCorte estiloCorte;

    public CorteCaballeroAgregado(IdCorteCaballero idCorteCaballero, Complejidad complejidad, EstiloCorte estiloCorte) {
        super("co.com.sofka.domain.serviciocaballero.serviciocaballerocreado");
        this.idCorteCaballero = idCorteCaballero;
        this.complejidad = complejidad;
        this.estiloCorte = estiloCorte;
    }

    public IdCorteCaballero getIdCorteCaballero() {
        return idCorteCaballero;
    }

    public Complejidad getComplejidad() {
        return complejidad;
    }

    public EstiloCorte getEstiloCorte() {
        return estiloCorte;
    }
}
