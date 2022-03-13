package co.com.sofka.domain.serviciosdama.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.serviciosdama.valor.DiseñoUñas;
import co.com.sofka.domain.serviciosdama.valor.IdManicurista;
import co.com.sofka.domain.serviciosdama.valor.IdServicioDama;
import co.com.sofka.domain.serviciosdama.valor.Nombre;

public class AgregarManicurista extends Command {
    private final IdServicioDama idServicioDama;
    private final IdManicurista idManicurista;
    private final Nombre nombre;
    private final DiseñoUñas diseñoUñas;

    public AgregarManicurista(IdServicioDama idServicioDama,
                              IdManicurista idManicurista, Nombre nombre, DiseñoUñas diseñoUñas) {
        this.idServicioDama = idServicioDama;
        this.idManicurista = idManicurista;
        this.nombre = nombre;
        this.diseñoUñas = diseñoUñas;
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

    public DiseñoUñas getDiseñoUñas() {
        return diseñoUñas;
    }
}
