package co.com.sofka.domain.servicioscaballero.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.servicioscaballero.valor.IdDiseñoBarba;
import co.com.sofka.domain.servicioscaballero.valor.TipoDeDiseño;

public class DiseñoBarbaAgregado extends DomainEvent {
    private final IdDiseñoBarba idDiseñoBarba;
    private final TipoDeDiseño tipoDeDiseño;

    public DiseñoBarbaAgregado(IdDiseñoBarba idDiseñoBarba, TipoDeDiseño tipoDeDiseño) {
        super("co.com.sofka.domain.serviciocaballero.diseñobarbaagregado");
        this.idDiseñoBarba = idDiseñoBarba;
        this.tipoDeDiseño = tipoDeDiseño;
    }

    public IdDiseñoBarba getIdDiseñoBarba() {
        return idDiseñoBarba;
    }

    public TipoDeDiseño getTipoDeDiseño() {
        return tipoDeDiseño;
    }
}
