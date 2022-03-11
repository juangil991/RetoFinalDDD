package co.com.sofka.domain.servicioscaballero.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.servicioscaballero.valor.EstiloCorte;
import co.com.sofka.domain.servicioscaballero.valor.IdBarbero;
import co.com.sofka.domain.servicioscaballero.valor.IdCorteCaballero;
import co.com.sofka.domain.servicioscaballero.valor.IdServiciosCaballero;

public class ActualizarEstiloCorteCaballero extends Command {
    private final IdServiciosCaballero idServiciosCaballero;
    private final IdCorteCaballero idCorteCaballero;
    private final EstiloCorte estiloCorte;

    public ActualizarEstiloCorteCaballero(IdServiciosCaballero idServiciosCaballero, IdCorteCaballero idCorteCaballero, EstiloCorte estiloCorte) {
        this.idServiciosCaballero = idServiciosCaballero;
        this.idCorteCaballero = idCorteCaballero;
        this.estiloCorte = estiloCorte;
    }

    public IdServiciosCaballero getIdServiciosCaballero() {
        return idServiciosCaballero;
    }

    public IdCorteCaballero getIdCorteCaballero() {
        return idCorteCaballero;
    }

    public EstiloCorte getEstiloCorte() {
        return estiloCorte;
    }
}
