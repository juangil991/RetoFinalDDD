package co.com.sofka.domain.serviciosdama.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.serviciosdama.valor.IdManicurista;
import co.com.sofka.domain.serviciosdama.valor.IdServicioDama;
import co.com.sofka.domain.serviciosdama.valor.Nombre;

public class ActualizarNombreManicurista extends Command {
    private final IdServicioDama idServicioDama;
    private final IdManicurista idManicurista;
    private final Nombre nombre;

    public ActualizarNombreManicurista(IdServicioDama idServicioDama, IdManicurista idManicurista, Nombre nombre) {
        this.idServicioDama = idServicioDama;
        this.idManicurista = idManicurista;
        this.nombre = nombre;
    }

    public IdServicioDama getIdServicioDama() {
        return idServicioDama;
    }

    public IdManicurista getIdManicurista() {
        return idManicurista;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
