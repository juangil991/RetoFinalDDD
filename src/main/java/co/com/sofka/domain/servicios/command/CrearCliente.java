package co.com.sofka.domain.servicios.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.servicios.valor.Genero;
import co.com.sofka.domain.servicios.valor.IdCliente;
import co.com.sofka.domain.servicios.valor.IdServicios;
import co.com.sofka.domain.servicios.valor.Nombre;

public class CrearCliente extends Command {
    private final IdServicios idServicios;
    private final IdCliente idCliente;
    private final Nombre nombre;
    private final Genero genero;

    public CrearCliente(IdServicios idServicios, IdCliente idCliente, Nombre nombre, Genero genero) {
        this.idServicios = idServicios;
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.genero = genero;
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

    public Genero getGenero() {
        return genero;
    }
}
