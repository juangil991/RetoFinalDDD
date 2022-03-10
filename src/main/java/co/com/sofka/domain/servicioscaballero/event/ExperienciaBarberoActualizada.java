package co.com.sofka.domain.servicioscaballero.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.servicioscaballero.valor.Experiencia;
import co.com.sofka.domain.servicioscaballero.valor.IdBarbero;

public class ExperienciaBarberoActualizada extends DomainEvent {
    private final IdBarbero idBarbero;
    private final Experiencia experiencia;

    public ExperienciaBarberoActualizada(IdBarbero idBarbero, Experiencia experiencia) {
        super("co.com.sofka.domain.servicioscaballero.experienciabarberoactualizada");
        this.idBarbero = idBarbero;
        this.experiencia = experiencia;
    }

    public IdBarbero getIdBarbero() {
        return idBarbero;
    }

    public Experiencia getExperiencia() {
        return experiencia;
    }
}
