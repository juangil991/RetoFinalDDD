package co.com.sofka.domain.servicioscaballero;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.servicioscaballero.event.*;
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
        Objects.requireNonNull(complejidad);
        Objects.requireNonNull(estiloCorte);
        appendChange(new CorteCaballeroAgregado(idCorteCaballero,complejidad,estiloCorte)).apply();
    }
    public void ActualizarEstiloCorteCaballero(EstiloCorte estiloCorte){
        Objects.requireNonNull(estiloCorte);
        appendChange(new EstiloCorteCaballeroActualizado(estiloCorte)).apply();
    }
    public void ActualizarComplejidadCorteCaballero(Complejidad complejidad){
        Objects.requireNonNull(complejidad);
        appendChange(new ComplejidadCorteCaballeroActualizada(complejidad)).apply();
    }
    public void AgregarDiseñoBarba(IdDiseñoBarba idDiseñoBarba,TipoDeDiseño tipoDeDiseño){
        Objects.requireNonNull(idDiseñoBarba);
        Objects.requireNonNull(tipoDeDiseño);
        appendChange(new DiseñoBarbaAgregado(idDiseñoBarba,tipoDeDiseño)).apply();
    }
    private void ActualizarTipoDeDiseñoBarba(TipoDeDiseño tipoDeDiseño){
        Objects.requireNonNull(tipoDeDiseño);
        appendChange(new TipoDeDiseñoBarbaActualizado(tipoDeDiseño)).apply();
    }
    public void CortarBarba(CorteBarba corteBarba){
        Objects.requireNonNull(corteBarba);
        appendChange(new BarbaCortada(corteBarba)).apply();
    }

}