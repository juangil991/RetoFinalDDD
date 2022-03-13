package co.com.sofka.domain.serviciosdama;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.serviciosdama.event.*;
import co.com.sofka.domain.serviciosdama.valor.TipoDeCabello;

public class ServiciosDamaChange extends EventChange {

    public ServiciosDamaChange(ServiciosDama serviciosDama) {

        apply((ServiciosDamaCreado event)->{
            serviciosDama.fechaDeServicio=event.getFechaDeServicio();
        });

        apply((AlisadoEstilistaAgregado event)->{
            serviciosDama.estilista.AgregarAlisado(event.getAlisado());
        });

        apply((CepilladoEstilistaAgregado event)->{
            serviciosDama.estilista.AgregarCepillado(event.getCepillado());
        });

        apply((CorteDamaAgregado event)->{
            serviciosDama.AgregarCorteDama(event.getIdCortesDama(),event.getTipoDeCorte(), event.getTipoDeCabello());
        });

        apply((DepiladoEstilistaAgregado event)->{
            serviciosDama.estilista.AgregarDepilado(event.getDepilacion());
        });

        apply((DiseñoUñasManicuristaActualizado event)->{
            serviciosDama.manicurista.ActualizarDiseñoUñas(event.getDiseñoUñas());
        });

        apply((EsmalteManicuristaAgregado event)->{
            serviciosDama.manicurista.AgregarEsmalte(event.getEsmalte());
        });

        apply((ManicuristaAgregada event)->{
            serviciosDama.AgregarManicurista(event.getIdManicurista(), event.getNombre(), event.getDiseñoUñas());
        });

        apply((EstilistaAgregado event)->{
            serviciosDama.AgregarEstilista(event.getIdEstilista(),event.getNombre());
        });

        apply((NombreDeManicuristaActualizado event)->{
            serviciosDama.manicurista.ActualizarNombre(event.getNombre());
        });

        apply((TipoDeCabelloCorteDamaActualizado event)->{
            serviciosDama.corteDama.ActualizarTipoDeCabello(event.getTipoDeCabello());
        });

        apply((TipoDeCorteDamaActualizado event)->{
            serviciosDama.corteDama.ActualizarTipoDeCorte(event.getTipoDeCorte());
        });
    }
}
