package co.com.sofka.domain.servicioscaballero.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.servicioscaballero.valor.IdBarbero;
import co.com.sofka.domain.servicioscaballero.valor.IdServiciosCaballero;
import co.com.sofka.domain.servicioscaballero.valor.Nombre;

public class ActualizarNombreBarbero extends Command {
    private final IdServiciosCaballero idServiciosCaballero;
    private final IdBarbero idBarbero;
    private final Nombre nombre;

    public ActualizarNombreBarbero(IdServiciosCaballero idServiciosCaballero, IdBarbero idBarbero, Nombre nombre) {
        this.idServiciosCaballero = idServiciosCaballero;
        this.idBarbero = idBarbero;
        this.nombre = nombre;
    }

    public IdServiciosCaballero getIdServiciosCaballero() {
        return idServiciosCaballero;
    }

    public IdBarbero getIdBarbero() {
        return idBarbero;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
