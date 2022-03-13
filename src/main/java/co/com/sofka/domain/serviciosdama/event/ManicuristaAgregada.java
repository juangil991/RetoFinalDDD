package co.com.sofka.domain.serviciosdama.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.serviciosdama.valor.DiseñoUñas;
import co.com.sofka.domain.serviciosdama.valor.IdManicurista;
import co.com.sofka.domain.serviciosdama.valor.Nombre;

public class ManicuristaAgregada extends DomainEvent {
    private final IdManicurista idManicurista;
    private final DiseñoUñas diseñoUñas;
    private final Nombre nombre;

    public ManicuristaAgregada(IdManicurista idManicurista, Nombre nombre, DiseñoUñas diseñoUñas) {
        super("co.com.sofka.domain.serviciosdama.manicuristaagregada");
        this.idManicurista = idManicurista;
        this.diseñoUñas = diseñoUñas;
        this.nombre = nombre;
    }

    public IdManicurista getIdManicurista() {
        return idManicurista;
    }

    public DiseñoUñas getDiseñoUñas() {
        return diseñoUñas;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
