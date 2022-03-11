package co.com.sofka.domain.servicioscaballero.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.servicioscaballero.valor.CorteBarba;

public class BarbaCortada extends DomainEvent {
    private CorteBarba corteBarba;

    public BarbaCortada(CorteBarba corteBarba) {
        super("co.com.sofka.domain.serviciocaballero.barbacortada");
        this.corteBarba = corteBarba;
    }

    public CorteBarba getCorteBarba() {
        return corteBarba;
    }
}
