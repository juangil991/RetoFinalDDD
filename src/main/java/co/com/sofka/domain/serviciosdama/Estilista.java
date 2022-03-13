package co.com.sofka.domain.serviciosdama;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.serviciosdama.valor.*;

import java.util.Objects;

public class Estilista extends Entity<IdEstilista> {
    private IdEstilista idEstilista;
    private Nombre nombre;
    private Cepillado cepillado;
    private Alisado alisado;
    private Depilacion depilacion;

    public Estilista(IdEstilista entityId, IdEstilista idEstilista, Nombre nombre) {
        super(entityId);
        this.idEstilista = idEstilista;
        this.nombre = nombre;
    }
    public void AgregarAlisado(Alisado alisado){
        this.alisado= Objects.requireNonNull(alisado);
    }
    public void AgregarCepillado(Cepillado cepillado){
        this.cepillado=Objects.requireNonNull(cepillado);
    }
    public void AgregarDepilado(Depilacion depilacion){
        this.depilacion=Objects.requireNonNull(depilacion);
    }
    public void ActualizarNombre(Nombre nombre){
        this.nombre=Objects.requireNonNull(nombre);
    }


    public IdEstilista IdEstilista() {
        return idEstilista;
    }

    public Nombre Nombre() {
        return nombre;
    }

    public Cepillado Cepillado() {
        return cepillado;
    }
}
