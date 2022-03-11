package co.com.sofka.domain.servicioscaballero.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.servicioscaballero.valor.Experiencia;
import co.com.sofka.domain.servicioscaballero.valor.IdBarbero;
import co.com.sofka.domain.servicioscaballero.valor.IdServiciosCaballero;

public class ActualizarExperienciaBarbero extends Command {
    private final IdServiciosCaballero idServiciosCaballero;
    private final IdBarbero idBarbero;
    private final Experiencia experiencia;

    public ActualizarExperienciaBarbero(IdServiciosCaballero idServiciosCaballero, IdBarbero idBarbero, Experiencia experiencia) {
        this.idServiciosCaballero = idServiciosCaballero;
        this.idBarbero = idBarbero;
        this.experiencia = experiencia;
    }

    public IdServiciosCaballero getIdServiciosCaballero() {
        return idServiciosCaballero;
    }

    public IdBarbero getIdBarbero() {
        return idBarbero;
    }

    public Experiencia getExperiencia() {
        return experiencia;
    }
}
