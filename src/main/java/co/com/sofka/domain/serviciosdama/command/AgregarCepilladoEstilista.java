package co.com.sofka.domain.serviciosdama.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.serviciosdama.valor.Cepillado;
import co.com.sofka.domain.serviciosdama.valor.IdEstilista;
import co.com.sofka.domain.serviciosdama.valor.IdServicioDama;

public class AgregarCepilladoEstilista extends Command {
    private final IdServicioDama idServicioDama;
    private final IdEstilista idEstilista;
    private final Cepillado cepillado;

    public AgregarCepilladoEstilista(IdServicioDama idServicioDama, IdEstilista idEstilista, Cepillado cepillado) {
        this.idServicioDama = idServicioDama;
        this.idEstilista = idEstilista;
        this.cepillado = cepillado;
    }

    public IdServicioDama getIdServicioDama() {
        return idServicioDama;
    }

    public IdEstilista getIdEstilista() {
        return idEstilista;
    }

    public Cepillado getCepillado() {
        return cepillado;
    }
}
