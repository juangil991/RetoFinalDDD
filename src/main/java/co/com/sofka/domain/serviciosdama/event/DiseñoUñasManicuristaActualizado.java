package co.com.sofka.domain.serviciosdama.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.serviciosdama.valor.DiseñoUñas;
import co.com.sofka.domain.serviciosdama.valor.IdManicurista;

public class DiseñoUñasManicuristaActualizado extends DomainEvent {
    private final IdManicurista idManicurista;
    private final DiseñoUñas diseñoUñas;

    public DiseñoUñasManicuristaActualizado(IdManicurista idManicurista, DiseñoUñas diseñoUñas) {
        super("co.com.sofka.domain.serviciosdama.diseñouñasmanicuristaactualizado");
        this.idManicurista = idManicurista;
        this.diseñoUñas = diseñoUñas;
    }

    public IdManicurista getIdManicurista() {
        return idManicurista;
    }

    public DiseñoUñas getDiseñoUñas() {
        return diseñoUñas;
    }
}
