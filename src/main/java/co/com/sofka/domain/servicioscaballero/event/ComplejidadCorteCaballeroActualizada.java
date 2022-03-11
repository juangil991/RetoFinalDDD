package co.com.sofka.domain.servicioscaballero.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.servicioscaballero.valor.Complejidad;
import co.com.sofka.domain.servicioscaballero.valor.IdCorteCaballero;

public class ComplejidadCorteCaballeroActualizada extends DomainEvent {
    private final IdCorteCaballero idCorteCaballero;
    private final Complejidad complejidad;

    public ComplejidadCorteCaballeroActualizada(IdCorteCaballero idCorteCaballero, Complejidad complejidad) {
        super("co.com.sofka.domain.serviciocaballero.complejidadcortecaballeroactualizada");
        this.idCorteCaballero=idCorteCaballero;
        this.complejidad = complejidad;
    }

    public Complejidad getComplejidad() {
        return complejidad;
    }
}
