package co.com.sofka.domain.serviciosdama.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.serviciosdama.valor.Esmalte;

public class EsmalteManicuristaAgregado extends DomainEvent {
    private final Esmalte esmalte;

    public EsmalteManicuristaAgregado(Esmalte esmalte) {
        super("co.com.sofka.domain.serviciosdama.esmalteagregado");
        this.esmalte = esmalte;
    }

    public Esmalte getEsmalte() {
        return esmalte;
    }
}
