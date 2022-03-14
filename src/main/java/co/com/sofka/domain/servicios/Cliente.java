package co.com.sofka.domain.servicios;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.servicios.valor.Genero;
import co.com.sofka.domain.servicios.valor.IdCliente;
import co.com.sofka.domain.servicios.valor.Nombre;

import java.util.Objects;

public class Cliente extends Entity<IdCliente> {
    private Nombre nombre;
    private Genero genero;

    public Cliente(IdCliente idCliente, Nombre nombre, Genero genero) {
        super(idCliente);
        this.nombre = nombre;
        this.genero = genero;
    }
    public void ActualizarNombre(Nombre nombre){
        this.nombre= Objects.requireNonNull(nombre);
    }
    public void ActualizarGenero(Genero genero){
        this.genero=Objects.requireNonNull(genero);
    }

    public Nombre Nombre() {
        return nombre;
    }

    public Genero Genero() {
        return genero;
    }
}
