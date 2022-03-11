package co.com.sofka.domain.servicioscaballero.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.servicioscaballero.valor.EstiloCorte;

public class EstiloCorteCaballeroActualizado extends DomainEvent {
    EstiloCorte estiloCorte;

    public EstiloCorteCaballeroActualizado(EstiloCorte estiloCorte) {
        super("co.com.sofka.domain.serviciocaballero.estilocortecaballeroactualizado");
        this.estiloCorte = estiloCorte;
    }

    public EstiloCorte getEstiloCorte() {
        return estiloCorte;
    }
}
