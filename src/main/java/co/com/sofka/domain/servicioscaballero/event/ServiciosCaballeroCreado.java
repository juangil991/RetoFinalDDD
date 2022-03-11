package co.com.sofka.domain.servicioscaballero.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.servicioscaballero.valor.FechaDeServicio;

public class ServiciosCaballeroCreado extends DomainEvent {
    private final FechaDeServicio fechaDeServicio;
    public ServiciosCaballeroCreado(FechaDeServicio fechaDeServicio) {
        super("co.com.sofka.domain.serviciocaballero.serviciocaballerocreado");
        this.fechaDeServicio= fechaDeServicio;
    }

    public FechaDeServicio getFechaDeServicio() {
        return fechaDeServicio;
    }
}
