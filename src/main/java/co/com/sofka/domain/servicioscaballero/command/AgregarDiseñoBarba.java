package co.com.sofka.domain.servicioscaballero.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.servicioscaballero.valor.IdBarbero;
import co.com.sofka.domain.servicioscaballero.valor.IdDiseñoBarba;
import co.com.sofka.domain.servicioscaballero.valor.IdServiciosCaballero;
import co.com.sofka.domain.servicioscaballero.valor.TipoDeDiseño;

public class AgregarDiseñoBarba extends Command {
    private final IdServiciosCaballero idServiciosCaballero;
    private final IdDiseñoBarba idDiseñoBarba;
    private final TipoDeDiseño tipoDeDiseño;

    public AgregarDiseñoBarba(IdServiciosCaballero idServiciosCaballero, IdDiseñoBarba idDiseñoBarba, TipoDeDiseño tipoDeDiseño) {
        this.idServiciosCaballero = idServiciosCaballero;
        this.idDiseñoBarba = idDiseñoBarba;
        this.tipoDeDiseño = tipoDeDiseño;
    }

    public IdServiciosCaballero getIdServiciosCaballero() {
        return idServiciosCaballero;
    }

    public IdDiseñoBarba getIdDiseñoBarba() {
        return idDiseñoBarba;
    }

    public TipoDeDiseño getTipoDeDiseño() {
        return tipoDeDiseño;
    }
}
