package co.com.sofka.domain.serviciosdama.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.serviciosdama.valor.IdEstilista;
import co.com.sofka.domain.serviciosdama.valor.Nombre;


public class NombreEstilistaActualizado extends DomainEvent {
    private final IdEstilista idEstilista;
    private final Nombre nombre;

    public NombreEstilistaActualizado(IdEstilista idEstilista, Nombre nombre) {
        super("co.com.sofka.domain.serviciosdama.nombreestilistaactualizado");
        this.idEstilista = idEstilista;
        this.nombre = nombre;
    }

    public IdEstilista getIdEstilista() {
        return idEstilista;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
