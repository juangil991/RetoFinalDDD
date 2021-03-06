package co.com.sofka.domain.servicios.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.servicios.valor.IdServicios;
import co.com.sofka.domain.servicios.valor.IdServiciosDama;

public class AdicionarServicioDama extends Command {
    private final IdServicios idServicios;
    private final IdServiciosDama idServiciosDama;

    public AdicionarServicioDama(IdServicios idServicios, IdServiciosDama idServiciosDama) {
        this.idServicios = idServicios;
        this.idServiciosDama = idServiciosDama;
    }

    public IdServicios getIdServicios() {
        return idServicios;
    }

    public IdServiciosDama getIdServiciosDama() {
        return idServiciosDama;
    }
}
