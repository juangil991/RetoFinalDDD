package co.com.sofka.domain.servicios;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.servicios.event.*;

import java.util.ArrayList;


public class ServiciosChange extends EventChange {

    public ServiciosChange(Servicios servicios) {
        apply((ServiciosAgregado event)->{
            servicios.fechaDeServicio=event.getFechaDeServicio();
            servicios.idServiciosCaballero=new ArrayList<>();
            servicios.idServiciosDama=new ArrayList<>();
        });
        apply((ClienteCreado event)->{
            servicios.cliente= new Cliente(event.getIdCliente(),event.getNombre(),event.getGenero());
        });

        apply((NombreClienteActualizado event)->{
            servicios.cliente.ActualizarNombre(event.getNombre());
        });

        apply((GeneroClienteActualizado event)->{
            servicios.cliente.ActualizarGenero(event.getGenero());
        });

        apply((ServicioCaballeroAdicionado event)->{
            servicios.idServiciosCaballero.add(event.getIdServiciosCaballero());
        });

        apply((ServicioDamaAdicionado event)->{
            servicios.idServiciosDama.add(event.getIdServiciosDama());
        });
    }
}
