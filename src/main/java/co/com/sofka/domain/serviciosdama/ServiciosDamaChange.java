package co.com.sofka.domain.serviciosdama;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.serviciosdama.event.AlisadoEstilistaAgregado;
import co.com.sofka.domain.serviciosdama.event.EstilistaAgregado;
import co.com.sofka.domain.serviciosdama.event.ServiciosDamaCreado;

public class ServiciosDamaChange extends EventChange {

    public ServiciosDamaChange(ServiciosDama serviciosDama) {

        apply((ServiciosDamaCreado event)->{
            serviciosDama.fechaDeServicio=event.getFechaDeServicio();
        });

        apply((AlisadoEstilistaAgregado event)->{
            serviciosDama.estilista.AgregarAlisado(event.getAlisado());
        });

        apply((EstilistaAgregado event)->{
            serviciosDama.AgregarEstilista(event.getIdEstilista(),event.getNombre());
        });
    }
}
