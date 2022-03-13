package co.com.sofka.domain.serviciosdama.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.serviciosdama.valor.Alisado;
import co.com.sofka.domain.serviciosdama.valor.IdEstilista;
import co.com.sofka.domain.serviciosdama.valor.IdServicioDama;

public class AgregarAlisadoEstilista extends Command {
    private final IdServicioDama idServicioDama;
    private final IdEstilista idEstilista;
    private final Alisado alisado;

    public AgregarAlisadoEstilista(IdServicioDama idServicioDama, IdEstilista idEstilista, Alisado alisado) {
        this.idServicioDama = idServicioDama;
        this.idEstilista = idEstilista;
        this.alisado = alisado;
    }

    public IdServicioDama getIdServicioDama() {
        return idServicioDama;
    }

    public IdEstilista getIdEstilista() {
        return idEstilista;
    }

    public Alisado getAlisado() {
        return alisado;
    }
}
