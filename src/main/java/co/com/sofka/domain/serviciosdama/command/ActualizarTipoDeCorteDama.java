package co.com.sofka.domain.serviciosdama.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.serviciosdama.valor.IdCortesDama;
import co.com.sofka.domain.serviciosdama.valor.IdServicioDama;
import co.com.sofka.domain.serviciosdama.valor.TipoDeCorte;

public class ActualizarTipoDeCorteDama extends Command {
    private final IdServicioDama idServicioDama;
    private final IdCortesDama idCortesDama;
    private final TipoDeCorte tipoDeCorte;

    public ActualizarTipoDeCorteDama(IdServicioDama idServicioDama, IdCortesDama idCortesDama, TipoDeCorte tipoDeCorte) {
        this.idServicioDama = idServicioDama;
        this.idCortesDama = idCortesDama;
        this.tipoDeCorte = tipoDeCorte;
    }

    public IdServicioDama getIdServicioDama() {
        return idServicioDama;
    }

    public IdCortesDama getIdCortesDama() {
        return idCortesDama;
    }

    public TipoDeCorte getTipoDeCorte() {
        return tipoDeCorte;
    }
}
