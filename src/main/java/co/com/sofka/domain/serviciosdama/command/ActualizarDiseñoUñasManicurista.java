package co.com.sofka.domain.serviciosdama.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.serviciosdama.valor.DiseñoUñas;
import co.com.sofka.domain.serviciosdama.valor.IdManicurista;
import co.com.sofka.domain.serviciosdama.valor.IdServicioDama;

public class ActualizarDiseñoUñasManicurista extends Command {
    private final IdServicioDama idServicioDama;
    private final IdManicurista idManicurista;
    private final DiseñoUñas diseñoUñas;

    public ActualizarDiseñoUñasManicurista(IdServicioDama idServicioDama, IdManicurista idManicurista, DiseñoUñas diseñoUñas) {
        this.idServicioDama = idServicioDama;
        this.idManicurista = idManicurista;
        this.diseñoUñas = diseñoUñas;
    }

    public IdServicioDama getIdServicioDama() {
        return idServicioDama;
    }

    public IdManicurista getIdManicurista() {
        return idManicurista;
    }

    public DiseñoUñas getDiseñoUñas() {
        return diseñoUñas;
    }
}
