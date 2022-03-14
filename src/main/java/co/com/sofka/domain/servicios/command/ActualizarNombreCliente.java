package co.com.sofka.domain.servicios.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.servicios.valor.IdCliente;
import co.com.sofka.domain.servicios.valor.IdServicios;
import co.com.sofka.domain.servicios.valor.Nombre;

public class ActualizarNombreCliente extends Command {
    private final IdServicios idServicios;
    private final IdCliente idCliente;
    private final Nombre nombre;

    public ActualizarNombreCliente(IdServicios idServicios, IdCliente idCliente, Nombre nombre) {
        this.idServicios = idServicios;
        this.idCliente = idCliente;
        this.nombre = nombre;
    }

    public IdServicios getIdServicios() {
        return idServicios;
    }

    public IdCliente getIdCliente() {
        return idCliente;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
