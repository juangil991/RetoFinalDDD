package co.com.sofka.domain.servicios.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.servicios.valor.Genero;
import co.com.sofka.domain.servicios.valor.IdCliente;
import co.com.sofka.domain.servicios.valor.IdServicios;

public class ActualizarGeneroCliente extends Command {
    private final IdServicios idServicios;
    private final IdCliente idCliente;
    private final Genero genero;

    public ActualizarGeneroCliente(IdServicios idServicios, IdCliente idCliente, Genero genero) {
        this.idServicios = idServicios;
        this.idCliente = idCliente;
        this.genero = genero;
    }

    public IdServicios getIdServicios() {
        return idServicios;
    }

    public IdCliente getIdCliente() {
        return idCliente;
    }

    public Genero getGenero() {
        return genero;
    }
}
