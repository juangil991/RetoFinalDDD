package co.com.sofka.domain.servicios.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.servicios.valor.IdServicios;
import co.com.sofka.domain.servicios.valor.IdServiciosCaballero;

public class AdicionarServicioCaballero extends Command {
    private final IdServicios idServicios;
    private final IdServiciosCaballero idServiciosCaballero;

    public AdicionarServicioCaballero(IdServicios idServicios, IdServiciosCaballero idServiciosCaballero) {
        this.idServicios = idServicios;
        this.idServiciosCaballero = idServiciosCaballero;
    }

    public IdServicios getIdServicios() {
        return idServicios;
    }

    public IdServiciosCaballero getIdServiciosCaballero() {
        return idServiciosCaballero;
    }
}
