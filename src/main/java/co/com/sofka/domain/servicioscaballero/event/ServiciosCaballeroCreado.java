package co.com.sofka.domain.servicioscaballero.event;

import co.com.sofka.domain.generic.DomainEvent;

public class ServiciosCaballeroCreado extends DomainEvent {
    public ServiciosCaballeroCreado() {
        super("co.com.sofka.domain.serviciocaballero.serviciocaballerocreado");
    }
}
