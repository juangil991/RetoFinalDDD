package co.com.sofka.domain.serviciosdama.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.serviciosdama.valor.IdManicurista;
import co.com.sofka.domain.serviciosdama.valor.Nombre;

public class NombreDeManicuristaActualizado extends DomainEvent {
    private final IdManicurista idManicurista;
    private final Nombre nombre;

    public NombreDeManicuristaActualizado(IdManicurista idManicurista,Nombre nombre) {
        super("co.com.sofka.domain.serviciosdama.nombredemanicuristaactualizado");
        this.nombre = nombre;
        this.idManicurista=idManicurista;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public IdManicurista getIdManicurista() {
        return idManicurista;
    }
}
