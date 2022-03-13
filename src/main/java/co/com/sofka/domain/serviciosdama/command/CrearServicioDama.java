package co.com.sofka.domain.serviciosdama.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.serviciosdama.valor.FechaDeServicio;
import co.com.sofka.domain.serviciosdama.valor.IdServicioDama;

public class CrearServicioDama extends Command {
    private final IdServicioDama idServicioDama;
    private final FechaDeServicio fechaDeServicio;

    public CrearServicioDama(IdServicioDama idServicioDama, FechaDeServicio fechaDeServicio) {
        this.idServicioDama = idServicioDama;
        this.fechaDeServicio = fechaDeServicio;
    }

    public IdServicioDama getIdServicioDama() {
        return idServicioDama;
    }

    public FechaDeServicio getFechaDeServicio() {
        return fechaDeServicio;
    }
}
