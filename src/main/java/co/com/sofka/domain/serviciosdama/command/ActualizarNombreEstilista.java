package co.com.sofka.domain.serviciosdama.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.serviciosdama.valor.IdEstilista;
import co.com.sofka.domain.serviciosdama.valor.IdServicioDama;
import co.com.sofka.domain.serviciosdama.valor.Nombre;

public class ActualizarNombreEstilista extends Command {
    private final IdServicioDama idServicioDama;
    private final IdEstilista idEstilista;
    private final Nombre nombre;

    public ActualizarNombreEstilista(IdServicioDama idServicioDama, IdEstilista idEstilista, Nombre nombre) {
        this.idServicioDama = idServicioDama;
        this.idEstilista = idEstilista;
        this.nombre = nombre;
    }

    public IdServicioDama getIdServicioDama() {
        return idServicioDama;
    }

    public IdEstilista getIdEstilista() {
        return idEstilista;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
