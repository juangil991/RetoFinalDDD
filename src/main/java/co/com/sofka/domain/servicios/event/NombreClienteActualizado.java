package co.com.sofka.domain.servicios.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.servicios.valor.IdCliente;
import co.com.sofka.domain.servicios.valor.Nombre;

public class NombreClienteActualizado extends DomainEvent {
    private final IdCliente idCliente;
    private final Nombre nombre;

    public NombreClienteActualizado(IdCliente idCliente, Nombre nombre) {
        super("co.com.sofka.domain.serviciosdama.nombreclienteactualizado");
        this.idCliente = idCliente;
        this.nombre = nombre;
    }

    public IdCliente getIdCliente() {
        return idCliente;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
