package co.com.sofka.domain.servicioscaballero;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.servicioscaballero.valor.Experiencia;
import co.com.sofka.domain.servicioscaballero.valor.IdBarbero;
import co.com.sofka.domain.servicioscaballero.valor.Nombre;

import java.util.Objects;

public class Barbero extends Entity<IdBarbero> {

    private  Nombre nombre;
    private  Experiencia experiencia;

    public Barbero(IdBarbero idBarbero, Nombre nombre, Experiencia experiencia) {
        super(idBarbero);
        this.nombre=nombre;
        this.experiencia=experiencia;
    }
    public void ActualizarNombre(Nombre nombre){
        this.nombre= Objects.requireNonNull(nombre);
    }
    public void ActualizarExperiencia(Experiencia experiencia){
        this.experiencia=Objects.requireNonNull(experiencia);
    }

    public Nombre Nombre() {
        return nombre;
    }

    public Experiencia Experiencia() {
        return experiencia;
    }
}
