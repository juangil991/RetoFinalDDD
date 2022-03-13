package co.com.sofka.domain.serviciosdama.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.serviciosdama.valor.IdEstilista;
import co.com.sofka.domain.serviciosdama.valor.Nombre;

public class EstilistaAgregado extends DomainEvent {
    private final IdEstilista idEstilista;
    private final Nombre nombre;

    public EstilistaAgregado( IdEstilista idEstilista, Nombre nombre) {
        super("co.com.sofka.domain.serviciosdama.estilistaagregado");
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
