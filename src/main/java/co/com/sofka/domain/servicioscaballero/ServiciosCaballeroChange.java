package co.com.sofka.domain.servicioscaballero;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.servicioscaballero.event.*;

public class ServiciosCaballeroChange extends EventChange {
    public ServiciosCaballeroChange(ServiciosCaballero serviciosCaballero) {
        apply((ServiciosCaballeroCreado event)->{
            serviciosCaballero.fechaDeServicio= event.getFechaDeServicio();
        });

        apply((BarbaCortada event)->{
            serviciosCaballero.corteBarba=event.getCorteBarba();
        });

        apply((BarberoAgregado event)->{
            serviciosCaballero.barbero= new Barbero(event.getIdBarbero(),event.getNombre(),event.getExperiencia());
        });

        apply((ComplejidadCorteCaballeroActualizada event)->{
           serviciosCaballero.corteCaballero.ActualizarComplejidad(event.getComplejidad());
        });

        apply((CorteCaballeroAgregado event)->{
            serviciosCaballero.corteCaballero = new CorteCaballero(event.getIdCorteCaballero(),
                    event.getComplejidad(),event.getEstiloCorte());
        });

        apply((DiseñoBarbaAgregado event)->{
            serviciosCaballero.diseñoBarba = new DiseñoBarba(event.getIdDiseñoBarba(),event.getTipoDeDiseño());
        });

        apply((EstiloCorteCaballeroActualizado event)->{
            serviciosCaballero.corteCaballero.ActualizarEstiloCorte(event.getEstiloCorte());
        });

        apply((ExperienciaBarberoActualizada event)->{
            serviciosCaballero.barbero.ActualizarExperiencia(event.getExperiencia());
        });

        apply((NombreBarberoActualizado event)->{
            serviciosCaballero.barbero.ActualizarNombre(event.getNombre());
        });

        apply((TipoDeDiseñoBarbaActualizado event)->{
            serviciosCaballero.diseñoBarba.ActualizarTipoDeDiseño(event.getTipoDeDiseño());
        });
    }
}
