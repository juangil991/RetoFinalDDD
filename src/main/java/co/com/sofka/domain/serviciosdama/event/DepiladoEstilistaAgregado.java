package co.com.sofka.domain.serviciosdama.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.serviciosdama.valor.Depilacion;

public class DepiladoEstilistaAgregado extends DomainEvent {
    private final Depilacion depilacion;

    public DepiladoEstilistaAgregado(Depilacion depilacion) {
        super("co.com.sofka.domain.serviciosdama.depilacionestilistaagregada");
        this.depilacion = depilacion;
    }

    public Depilacion getDepilacion() {
        return depilacion;
    }
}
