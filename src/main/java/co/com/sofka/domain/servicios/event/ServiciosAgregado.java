package co.com.sofka.domain.servicios.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.servicios.valor.FechaDeServicio;


public class ServiciosAgregado extends DomainEvent {
    private final FechaDeServicio fechaDeServicio;

    public ServiciosAgregado(FechaDeServicio fechaDeServicio) {
        super("co.com.sofka.domain.servicios.servicioscreado");
        this.fechaDeServicio = fechaDeServicio;
    }

    public FechaDeServicio getFechaDeServicio() {
        return fechaDeServicio;
    }
}
