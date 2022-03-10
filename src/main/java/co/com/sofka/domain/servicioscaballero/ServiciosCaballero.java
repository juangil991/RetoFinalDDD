package co.com.sofka.domain.servicioscaballero;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.servicioscaballero.event.BarberoAgregado;
import co.com.sofka.domain.servicioscaballero.event.ExperienciaBarberoActualizada;
import co.com.sofka.domain.servicioscaballero.event.NombreBarberoActualizado;
import co.com.sofka.domain.servicioscaballero.event.ServiciosCaballeroCreado;
import co.com.sofka.domain.servicioscaballero.valor.*;

import java.util.Objects;

public class ServiciosCaballero extends AggregateEvent<IdServiciosCaballero> {
    protected CorteBarba corteBarba;

    public ServiciosCaballero(IdServiciosCaballero entityId) {
        super(entityId);
        appendChange(new ServiciosCaballeroCreado()).apply();
    }

    public void AgregarBarbero(IdBarbero idBarbero, Nombre nombre, Experiencia experiencia){
        Objects.requireNonNull(idBarbero);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(experiencia);
        appendChange(new BarberoAgregado(idBarbero,nombre,experiencia)).apply();
    }
    public void ActualizarNombreBarbero(IdBarbero idBarbero, Nombre nombre){
        Objects.requireNonNull(idBarbero);
        Objects.requireNonNull(nombre);
        appendChange(new NombreBarberoActualizado(idBarbero,nombre)).apply();
    }
    public void ActualizarExperienciaBarbero(IdBarbero idBarbero, Experiencia experiencia){
        Objects.requireNonNull(idBarbero);
        Objects.requireNonNull(experiencia);
        appendChange(new ExperienciaBarberoActualizada(idBarbero, experiencia)).apply();
    }
    public void AgregarCorteCaballero(IdCorteCaballero idCorteCaballero, Complejidad complejidad, EstiloCorte estiloCorte){
        Objects.requireNonNull(idCorteCaballero);
    }

}
