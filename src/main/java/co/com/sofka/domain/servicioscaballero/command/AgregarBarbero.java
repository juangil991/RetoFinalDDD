package co.com.sofka.domain.servicioscaballero.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.servicioscaballero.valor.Experiencia;
import co.com.sofka.domain.servicioscaballero.valor.IdBarbero;
import co.com.sofka.domain.servicioscaballero.valor.IdServiciosCaballero;
import co.com.sofka.domain.servicioscaballero.valor.Nombre;

public class AgregarBarbero extends Command {
    private final IdServiciosCaballero idServiciosCaballero;
    private final IdBarbero idBarbero;
    private final Nombre nombre;
    private final Experiencia experiencia;

    public AgregarBarbero(IdServiciosCaballero idServiciosCaballero, IdBarbero idBarbero, Nombre nombre, Experiencia experiencia) {
        this.idServiciosCaballero = idServiciosCaballero;
        this.idBarbero = idBarbero;
        this.nombre = nombre;
        this.experiencia = experiencia;
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

    public Experiencia getExperiencia() {
        return experiencia;
    }
}
