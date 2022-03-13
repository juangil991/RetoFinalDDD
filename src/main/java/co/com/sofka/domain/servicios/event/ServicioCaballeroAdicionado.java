package co.com.sofka.domain.servicios.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.servicios.valor.IdServiciosCaballero;

public class ServicioCaballeroAdicionado extends DomainEvent {
    private final IdServiciosCaballero idServiciosCaballero;

    public ServicioCaballeroAdicionado(IdServiciosCaballero idServiciosCaballero) {
        super("co.com.sofka.domain.serviciosdama.serviciocaballeroadicionado");
        this.idServiciosCaballero = idServiciosCaballero;
    }

    public IdServiciosCaballero getIdServiciosCaballero() {
        return idServiciosCaballero;
    }
}
