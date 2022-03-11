package co.com.sofka.domain.servicioscaballero;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.servicioscaballero.valor.IdDiseñoBarba;
import co.com.sofka.domain.servicioscaballero.valor.TipoDeDiseño;

public class DiseñoBarba extends Entity<IdDiseñoBarba> {
    private TipoDeDiseño tipoDeDiseño;

    public DiseñoBarba(IdDiseñoBarba idDiseñoBarba, TipoDeDiseño tipoDeDiseño) {
        super(idDiseñoBarba);
        this.tipoDeDiseño = tipoDeDiseño;
    }
    public void ActualizarTipoDeDiseño(TipoDeDiseño tipoDeDiseño){
        this.tipoDeDiseño=tipoDeDiseño;
    }

    public TipoDeDiseño getTipoDeDiseño() {
        return tipoDeDiseño;
    }
}
