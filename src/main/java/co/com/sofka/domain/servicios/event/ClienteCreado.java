package co.com.sofka.domain.servicios.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.servicios.valor.Genero;
import co.com.sofka.domain.servicios.valor.IdCliente;
import co.com.sofka.domain.servicios.valor.Nombre;

public class ClienteCreado extends DomainEvent {
   private final IdCliente idCliente;
   private final Nombre nombre;
   private final Genero genero;

    public ClienteCreado(IdCliente idCliente, Nombre nombre, Genero genero) {
        super("co.com.sofka.domain.serviciosdama.clienteagregado");
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.genero = genero;
    }

    public IdCliente getIdCliente() {
        return idCliente;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Genero getGenero() {
        return genero;
    }
}
