package co.com.sofka.domain.serviciosdama.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.serviciosdama.valor.IdCortesDama;
import co.com.sofka.domain.serviciosdama.valor.IdServicioDama;
import co.com.sofka.domain.serviciosdama.valor.TipoDeCabello;
import co.com.sofka.domain.serviciosdama.valor.TipoDeCorte;

public class AgregarCorteDama extends Command {
    private final IdServicioDama idServicioDama;
    private final IdCortesDama idCortesDama;
    private final TipoDeCabello tipoDeCabello;
    private final TipoDeCorte tipoDeCorte;

    public AgregarCorteDama(IdServicioDama idServicioDama,IdCortesDama idCortesDama, TipoDeCabello tipoDeCabello, TipoDeCorte tipoDeCorte) {
        this.idServicioDama = idServicioDama;
        this.idCortesDama= idCortesDama;
        this.tipoDeCabello = tipoDeCabello;
        this.tipoDeCorte = tipoDeCorte;
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

    public TipoDeCorte getTipoDeCorte() {
        return tipoDeCorte;
    }
}
