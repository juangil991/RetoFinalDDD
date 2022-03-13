package co.com.sofka.domain.serviciosdama.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.serviciosdama.valor.Esmalte;
import co.com.sofka.domain.serviciosdama.valor.IdManicurista;
import co.com.sofka.domain.serviciosdama.valor.IdServicioDama;

public class AgregarEsmalteManicurista extends Command {
    private final IdServicioDama idServicioDama;
    private final IdManicurista idManicurista;
    private final Esmalte esmalte;

    public AgregarEsmalteManicurista(IdServicioDama idServicioDama, IdManicurista idManicurista, Esmalte esmalte) {
        this.idServicioDama = idServicioDama;
        this.idManicurista = idManicurista;
        this.esmalte = esmalte;
    }

    public IdServicioDama getIdServicioDama() {
        return idServicioDama;
    }

    public IdManicurista getIdManicurista() {
        return idManicurista;
    }

    public Esmalte getEsmalte() {
        return esmalte;
    }
}
