package co.com.sofka.domain.servicioscaballero.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.servicioscaballero.valor.Experiencia;
import co.com.sofka.domain.servicioscaballero.valor.IdBarbero;
import co.com.sofka.domain.servicioscaballero.valor.Nombre;

public class BarberoAgregado extends DomainEvent {
    private final IdBarbero idBarbero;
    private final Nombre nombre;
    private final Experiencia experiencia;

    public BarberoAgregado(IdBarbero idBarbero, Nombre nombre, Experiencia experiencia) {
        super("co.com.sofka.domain.serviciocaballero.serviciocaballerocreado");
        this.idBarbero=idBarbero;
        this.nombre=nombre;
        this.experiencia=experiencia;
    }

    public IdBarbero getIdBarbero() {
        return idBarbero;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Experiencia getExperiencia() {
        return experiencia;
    }
}
