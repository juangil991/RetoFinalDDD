package co.com.sofka.domain.serviciosdama.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.serviciosdama.valor.IdCortesDama;
import co.com.sofka.domain.serviciosdama.valor.TipoDeCabello;
import co.com.sofka.domain.serviciosdama.valor.TipoDeCorte;

public class CorteDamaAgregado extends DomainEvent {
    private final IdCortesDama idCortesDama;
    private final TipoDeCorte tipoDeCorte;
    private final TipoDeCabello tipoDeCabello;

    public CorteDamaAgregado(IdCortesDama idCortesDama, TipoDeCorte tipoDeCorte, TipoDeCabello tipoDeCabello) {
        super("co.com.sofka.domain.serviciosdama.cortedamaagregado");
        this.idCortesDama = idCortesDama;
        this.tipoDeCorte = tipoDeCorte;
        this.tipoDeCabello = tipoDeCabello;
    }

    public IdCortesDama getIdCortesDama() {
        return idCortesDama;
    }

    public TipoDeCorte getTipoDeCorte() {
        return tipoDeCorte;
    }

    public TipoDeCabello getTipoDeCabello() {
        return tipoDeCabello;
    }
}
