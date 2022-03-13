package co.com.sofka.domain.serviciosdama.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.serviciosdama.valor.TipoDeCabello;

public class TipoDeCabelloCorteDamaActualizado extends DomainEvent {
    private final TipoDeCabello tipoDeCabello;

    public TipoDeCabelloCorteDamaActualizado(TipoDeCabello tipoDeCabello) {
        super("co.com.sofka.domain.serviciosdama.tipodecabellocortedamaactualizado");
        this.tipoDeCabello = tipoDeCabello;
    }

    public TipoDeCabello getTipoDeCabello() {
        return tipoDeCabello;
    }
}
