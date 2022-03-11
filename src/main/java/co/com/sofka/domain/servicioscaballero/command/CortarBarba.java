package co.com.sofka.domain.servicioscaballero.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.servicioscaballero.valor.CorteBarba;
import co.com.sofka.domain.servicioscaballero.valor.IdBarbero;
import co.com.sofka.domain.servicioscaballero.valor.IdServiciosCaballero;

public class CortarBarba extends Command {
    private final IdServiciosCaballero idServiciosCaballero;
    private final CorteBarba corteBarba;

    public CortarBarba(IdServiciosCaballero idServiciosCaballero, CorteBarba corteBarba) {
        this.idServiciosCaballero = idServiciosCaballero;
        this.corteBarba = corteBarba;
    }

    public IdServiciosCaballero getIdServiciosCaballero() {
        return idServiciosCaballero;
    }

    public CorteBarba getCorteBarba() {
        return corteBarba;
    }
}
