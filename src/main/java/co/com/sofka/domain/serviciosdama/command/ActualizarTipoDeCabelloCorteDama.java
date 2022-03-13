package co.com.sofka.domain.serviciosdama.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.servicioscaballero.valor.IdCorteCaballero;
import co.com.sofka.domain.serviciosdama.valor.IdCortesDama;
import co.com.sofka.domain.serviciosdama.valor.IdServicioDama;
import co.com.sofka.domain.serviciosdama.valor.TipoDeCabello;

public class ActualizarTipoDeCabelloCorteDama extends Command {
    private final IdServicioDama idServicioDama;
    private final IdCortesDama idCortesDama;
    private final TipoDeCabello tipoDeCabello;

    public ActualizarTipoDeCabelloCorteDama(IdServicioDama idServicioDama,
                                            IdCortesDama idCortesDama, TipoDeCabello tipoDeCabello) {
        this.idServicioDama = idServicioDama;
        this.idCortesDama = idCortesDama;
        this.tipoDeCabello = tipoDeCabello;
    }

    public IdServicioDama getIdServicioDama() {
        return idServicioDama;
    }

    public IdCortesDama getIdCortesDama() {
        return idCortesDama;
    }

    public TipoDeCabello getTipoDeCabello() {
        return tipoDeCabello;
    }
}
