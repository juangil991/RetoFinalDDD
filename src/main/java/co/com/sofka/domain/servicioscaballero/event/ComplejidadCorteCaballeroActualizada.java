package co.com.sofka.domain.servicioscaballero.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.servicioscaballero.valor.Complejidad;

public class ComplejidadCorteCaballeroActualizada extends DomainEvent {
    private final Complejidad complejidad;

    public ComplejidadCorteCaballeroActualizada(Complejidad complejidad) {
        super("co.com.sofka.domain.serviciocaballero.complejidadcortecaballeroactualizada");
        this.complejidad = complejidad;
    }

    public Complejidad getComplejidad() {
        return complejidad;
    }
}
