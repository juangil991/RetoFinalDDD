package co.com.sofka.domain.serviciosdama.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.serviciosdama.valor.Depilacion;
import co.com.sofka.domain.serviciosdama.valor.IdEstilista;
import co.com.sofka.domain.serviciosdama.valor.IdServicioDama;

public class AgregarDepiladoEstilista extends Command {
    private final IdServicioDama idServicioDama;
    private final IdEstilista idEstilista;
    private final Depilacion depilacion;

    public AgregarDepiladoEstilista(IdServicioDama idServicioDama, IdEstilista idEstilista, Depilacion depilacion) {
        this.idServicioDama = idServicioDama;
        this.idEstilista = idEstilista;
        this.depilacion = depilacion;
    }

    public IdServicioDama getIdServicioDama() {
        return idServicioDama;
    }

    public IdEstilista getIdEstilista() {
        return idEstilista;
    }

    public Depilacion getDepilacion() {
        return depilacion;
    }
}
