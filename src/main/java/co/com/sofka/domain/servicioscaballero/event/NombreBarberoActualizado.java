package co.com.sofka.domain.servicioscaballero.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.servicioscaballero.valor.IdBarbero;
import co.com.sofka.domain.servicioscaballero.valor.Nombre;

public class NombreBarberoActualizado extends DomainEvent {
    private final IdBarbero idBarbero;
    private final Nombre nombre;
    public NombreBarberoActualizado(IdBarbero idBarbero, Nombre nombre) {
        super("co.com.sofka.domain.servicioscaballero.nombrebarberoactualizado");
        this.idBarbero=idBarbero;
        this.nombre=nombre;
    }

    public IdBarbero getIdBarbero() {
        return idBarbero;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
