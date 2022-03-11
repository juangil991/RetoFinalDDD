package co.com.sofka.domain.servicioscaballero.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.servicioscaballero.valor.*;

public class AgregarCorteCaballero extends Command {
    private final IdServiciosCaballero idServiciosCaballero;
    private final IdCorteCaballero idCorteCaballero;
    private final Complejidad complejidad;
    private final EstiloCorte estiloCorte;

    public AgregarCorteCaballero(IdServiciosCaballero idServiciosCaballero, IdCorteCaballero idCorteCaballero, Complejidad complejidad, EstiloCorte estiloCorte) {
        this.idServiciosCaballero = idServiciosCaballero;
        this.idCorteCaballero = idCorteCaballero;
        this.complejidad = complejidad;
        this.estiloCorte = estiloCorte;
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

    public EstiloCorte getEstiloCorte() {
        return estiloCorte;
    }
}
