package co.com.sofka.domain.servicios;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.servicios.event.*;
import co.com.sofka.domain.servicios.valor.*;


import java.util.List;

public class Servicios extends AggregateEvent<IdServicios> {
    protected List<IdServiciosCaballero> idServiciosCaballero;
    protected List<IdServiciosDama> idServiciosDama;
    protected Cliente cliente;
    protected FechaDeServicio fechaDeServicio;

    public Servicios(IdServicios idServicios, FechaDeServicio fechaDeServicio) {
        super(idServicios);
        appendChange(new ServiciosAgregado(fechaDeServicio)).apply();
    }

    private Servicios(IdServicios idServicios){
        super(idServicios);
        subscribe(new ServiciosChange(this));
    }

    public void AdicionarServiciosCaballero(IdServiciosCaballero idServiciosCaballero){
        appendChange(new ServicioCaballeroAdicionado(idServiciosCaballero)).apply();
    }

    public void AdicionarServicioDama(IdServiciosDama idServiciosDama){
        appendChange(new ServicioDamaAdicionado(idServiciosDama)).apply();
    }

    public void AgregarCiente(IdCliente idCliente,Nombre nombre,Genero genero){
        appendChange(new ClienteCreado(idCliente,nombre,genero)).apply();
    }

    public void ActualizarNombreCliente(IdCliente idCliente, Nombre nombre){
        appendChange(new NombreClienteActualizado(idCliente, nombre)).apply();
    }

    public void ActualizarGeneroCliente(IdCliente idCliente,Genero genero){
        appendChange(new GeneroClienteActualizado(idCliente,genero)).apply();
    }
}
