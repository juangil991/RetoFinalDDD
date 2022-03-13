package co.com.sofka.domain.serviciosdama;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.serviciosdama.event.*;
import co.com.sofka.domain.serviciosdama.valor.IdEstilista;
import co.com.sofka.domain.serviciosdama.valor.TipoDeCabello;

public class ServiciosDamaChange extends EventChange {

    public ServiciosDamaChange(ServiciosDama serviciosDama) {

        apply((ServiciosDamaCreado event)->{
            serviciosDama.fechaDeServicio=event.getFechaDeServicio();
        });

        apply((EstilistaAgregado event)->{
            serviciosDama.estilista=new Estilista(event.getIdEstilista(),event.getNombre());
        });

        apply((AlisadoEstilistaAgregado event)->{
            serviciosDama.estilista.AgregarAlisado(event.getAlisado());
        });

        apply((CepilladoEstilistaAgregado event)->{
            serviciosDama.estilista.AgregarCepillado(event.getCepillado());
        });

        apply((CorteDamaAgregado event)->{
            serviciosDama.corteDama=new CorteDama(event.getIdCortesDama(),event.getTipoDeCabello(),event.getTipoDeCorte());
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
            serviciosDama.manicurista= new Manicurista(event.getIdManicurista(),event.getDiseñoUñas(),event.getNombre());
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
