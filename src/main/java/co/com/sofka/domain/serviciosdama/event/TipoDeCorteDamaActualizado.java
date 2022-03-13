package co.com.sofka.domain.serviciosdama.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.serviciosdama.CorteDama;

public class TipoDeCorteDamaActualizado extends DomainEvent {
    private final CorteDama corteDama;

    public TipoDeCorteDamaActualizado(CorteDama corteDama) {
        super("co.com.sofka.domain.serviciosdama.tipodecortedamaactualizado");
        this.corteDama = corteDama;
    }

    public CorteDama getCorteDama() {
        return corteDama;
    }
}
