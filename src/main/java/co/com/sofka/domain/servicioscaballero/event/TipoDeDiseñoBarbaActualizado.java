package co.com.sofka.domain.servicioscaballero.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.servicioscaballero.valor.TipoDeDiseño;

public class TipoDeDiseñoBarbaActualizado extends DomainEvent {
    private final TipoDeDiseño tipoDeDiseño;

    public TipoDeDiseñoBarbaActualizado(TipoDeDiseño tipoDeDiseño) {
        super("co.com.sofka.domain.serviciocaballero.tipodediseñobarbaactualizado");
        this.tipoDeDiseño = tipoDeDiseño;
    }

    public TipoDeDiseño getTipoDeDiseño() {
        return tipoDeDiseño;
    }
}
