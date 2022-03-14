package co.com.sofka.domain.servicios.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.servicios.valor.FechaDeServicio;
import co.com.sofka.domain.servicios.valor.IdServicios;

public class CrearServicio extends Command {
    private final IdServicios idServicios;
    private final FechaDeServicio fechaDeServicio;

    public CrearServicio(IdServicios idServicios, FechaDeServicio fechaDeServicio) {
        this.idServicios = idServicios;
        this.fechaDeServicio = fechaDeServicio;
    }

    public IdServicios getIdServicios() {
        return idServicios;
    }

    public FechaDeServicio getFechaDeServicio() {
        return fechaDeServicio;
    }
}
