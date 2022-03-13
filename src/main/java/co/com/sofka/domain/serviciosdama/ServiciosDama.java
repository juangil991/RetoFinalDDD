package co.com.sofka.domain.serviciosdama;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.serviciosdama.event.*;
import co.com.sofka.domain.serviciosdama.valor.*;

import java.util.List;
import java.util.Objects;

public class ServiciosDama extends AggregateEvent<IdServicioDama> {
    protected FechaDeServicio fechaDeServicio;
    protected Estilista estilista;
    protected CorteDama corteDama;
    protected Manicurista manicurista;

    public ServiciosDama(IdServicioDama idServicioDama, FechaDeServicio fechaDeServicio) {
        super(idServicioDama);
        appendChange(new ServiciosDamaCreado(fechaDeServicio)).apply();
    }
    private ServiciosDama(IdServicioDama idServicioDama){
        super(idServicioDama);
        subscribe(new ServiciosDamaChange(this));
    }

    public static ServiciosDama from(IdServicioDama idServicioDama,List<DomainEvent> events){
        var serviciosDama=new ServiciosDama(idServicioDama);
        events.forEach(serviciosDama::applyEvent);
        return serviciosDama;
    }

    public void AgregarManicurista(IdManicurista idManicurista, Nombre nombre, DiseñoUñas diseñoUñas){
        Objects.requireNonNull(idManicurista);
        Objects.requireNonNull(diseñoUñas);
        appendChange(new ManicuristaAgregada(idManicurista,nombre,diseñoUñas)).apply();
    }

    public void ActualizarNombreManicurista(IdManicurista idManicurista,Nombre nombre){
        Objects.requireNonNull(idManicurista);
        Objects.requireNonNull(nombre);
        appendChange(new NombreDeManicuristaActualizado(idManicurista,nombre)).apply();
    }

    public void ActualizarDiseñoUñasManicurista(IdManicurista idManicurista, DiseñoUñas diseñoUñas){
        Objects.requireNonNull(idManicurista);
        Objects.requireNonNull(diseñoUñas);
        appendChange(new DiseñoUñasManicuristaActualizado(idManicurista, diseñoUñas)).apply();
    }

    public void AgregarEsmalteManicurista(Esmalte esmalte){
        Objects.requireNonNull(esmalte);
        appendChange(new EsmalteManicuristaAgregado(esmalte)).apply();
    }

    public void AgregarAlisadoEstilista(Alisado alisado){
        Objects.requireNonNull(alisado);
        appendChange(new AlisadoEstilistaAgregado(alisado)).apply();
    }

    public void AgregarCepilladoEstilista(Cepillado cepillado){
        Objects.requireNonNull(cepillado);
        appendChange(new CepilladoEstilistaAgregado(cepillado)).apply();
    }

    public void AgregarDepiladoEstilista(Depilacion depilacion){
        Objects.requireNonNull(depilacion);
        appendChange(new DepiladoEstilistaAgregado(depilacion)).apply();
    }

    public void ActualizarNombreEstilista(IdEstilista idEstilista, Nombre nombre){
        Objects.requireNonNull(idEstilista);
        Objects.requireNonNull(nombre);
        appendChange(new NombreEstilistaActualizado(idEstilista,nombre)).apply();
    }

    public void ActualizarTipoDeCorteDama(TipoDeCorte tipoDeCorte){
        Objects.requireNonNull(tipoDeCorte);
        appendChange(new TipoDeCorteDamaActualizado(tipoDeCorte)).apply();
    }

    public void ActualizarTipoDeCabelloCorteDama(TipoDeCabello tipoDeCabello){
        Objects.requireNonNull(tipoDeCabello);
        appendChange(new TipoDeCabelloCorteDamaActualizado(tipoDeCabello)).apply();
    }

    public void AgregarEstilista(IdEstilista idEstilista, Nombre nombre){
        Objects.requireNonNull(idEstilista);
        Objects.requireNonNull(nombre);
        appendChange(new EstilistaAgregado(idEstilista,nombre)).apply();
    }

    public void AgregarCorteDama(IdCortesDama idCortesDama, TipoDeCorte tipoDeCorte, TipoDeCabello tipoDeCabello){
        Objects.requireNonNull(idCortesDama);
        Objects.requireNonNull(tipoDeCorte);
        Objects.requireNonNull(tipoDeCabello);
        appendChange(new CorteDamaAgregado(idCortesDama,tipoDeCorte,tipoDeCabello)).apply();
    }


}
