package co.com.sofka.domain.servicioscaballero.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.servicioscaballero.valor.Complejidad;
import co.com.sofka.domain.servicioscaballero.valor.IdCorteCaballero;
import co.com.sofka.domain.servicioscaballero.valor.IdServiciosCaballero;

public class ActualizarComplejidadCorteCaballero extends Command{
    private final IdServiciosCaballero idServiciosCaballero;
    private final IdCorteCaballero idCorteCaballero;
    private final Complejidad complejidad;

    public ActualizarComplejidadCorteCaballero(IdServiciosCaballero idServiciosCaballero, IdCorteCaballero idCorteCaballero, Complejidad complejidad) {
        this.idServiciosCaballero = idServiciosCaballero;
        this.idCorteCaballero = idCorteCaballero;
        this.complejidad = complejidad;
    }

    public IdServiciosCaballero getIdServiciosCaballero() {
        return idServiciosCaballero;
    }

    public IdCorteCaballero getIdCorteCaballero() {
        return idCorteCaballero;
    }

    public Complejidad getComplejidad() {
        return complejidad;
    }
}
