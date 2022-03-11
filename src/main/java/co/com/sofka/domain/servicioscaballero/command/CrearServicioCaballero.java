package co.com.sofka.domain.servicioscaballero.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.servicioscaballero.valor.FechaDeServicio;
import co.com.sofka.domain.servicioscaballero.valor.IdBarbero;
import co.com.sofka.domain.servicioscaballero.valor.IdServiciosCaballero;

public class CrearServicioCaballero extends Command {
    private final IdServiciosCaballero idServiciosCaballero;
    private final FechaDeServicio fechaDeServicio;

    public CrearServicioCaballero(IdServiciosCaballero idServiciosCaballero, FechaDeServicio fechaDeServicio) {
        this.idServiciosCaballero = idServiciosCaballero;
        this.fechaDeServicio = fechaDeServicio;
    }

    public IdServiciosCaballero getIdServiciosCaballero() {
        return idServiciosCaballero;
    }

    public FechaDeServicio getFechaDeServicio() {
        return fechaDeServicio;
    }
}
