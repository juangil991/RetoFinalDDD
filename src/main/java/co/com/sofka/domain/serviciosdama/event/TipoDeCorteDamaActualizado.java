package co.com.sofka.domain.serviciosdama.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.serviciosdama.CorteDama;
import co.com.sofka.domain.serviciosdama.valor.TipoDeCorte;

public class TipoDeCorteDamaActualizado extends DomainEvent {
    private final TipoDeCorte tipoDeCorte;

    public TipoDeCorteDamaActualizado(TipoDeCorte tipoDeCorte) {
        super("co.com.sofka.domain.serviciosdama.tipodecortedamaactualizado");
        this.tipoDeCorte =tipoDeCorte ;
    }

    public TipoDeCorte getTipoDeCorte() {
        return tipoDeCorte;
    }
}
