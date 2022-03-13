package co.com.sofka.domain.servicios.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.servicios.valor.Genero;
import co.com.sofka.domain.servicios.valor.IdCliente;

public class GeneroClienteActualizado extends DomainEvent {
    private final IdCliente idCliente;
    private final Genero genero;

    public GeneroClienteActualizado( IdCliente idCliente, Genero genero) {
        super("co.com.sofka.domain.serviciosdama.alisadoestilistaagregado");
        this.idCliente = idCliente;
        this.genero = genero;
    }

    public IdCliente getIdCliente() {
        return idCliente;
    }

    public Genero getGenero() {
        return genero;
    }
}
