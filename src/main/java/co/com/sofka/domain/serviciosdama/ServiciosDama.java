package co.com.sofka.domain.serviciosdama;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.serviciosdama.command.AgregarAlisadoEstilista;
import co.com.sofka.domain.serviciosdama.event.*;
import co.com.sofka.domain.serviciosdama.valor.*;

import java.time.LocalDate;

public class ServiciosDama extends AggregateEvent<IdServicioDama> {
    protected FechaDeServicio fechaDeServicio;
    protected Estilista estilista;
    protected CorteDama corteDama;
    protected Manicurista manicurista;

    public ServiciosDama(IdServicioDama idServicioDama, FechaDeServicio fechaDeServicio) {
        super(idServicioDama);
        appendChange(new ServiciosDamaCreado(fechaDeServicio)).apply();
    }

    public void AgregarManicurista(IdManicurista idManicurista, Nombre nombre, DiseñoUñas diseñoUñas){
        appendChange(new ManicuristaAgregada(idManicurista,nombre,diseñoUñas)).apply();
    }

    public void ActualizarNombreManicurista(IdManicurista idManicurista,Nombre nombre){
        appendChange(new NombreDeManicuristaActualizado(idManicurista,nombre)).apply();
    }

    public void ActualizarDiseñoUñasManicurista(IdManicurista idManicurista, DiseñoUñas diseñoUñas){
        appendChange(new DiseñoUñasManicuristaActualizado(idManicurista, diseñoUñas)).apply();
    }

    public void AgregarEsmalteManicurista(Esmalte esmalte){
        appendChange(new EsmalteManicuristaAgregado(esmalte)).apply();
    }

    public void AgregarAlisadoEstilista(Alisado alisado){
        appendChange(new AlisadoEstilistaAgregado(alisado)).apply();
    }

    public void AgregarCepilladoEstilista(Cepillado cepillado){
        appendChange(new CepilladoEstilistaAgregado(cepillado)).apply();
    }

    public void AgregarDepiladoEstilista(Depilacion depilacion){
        appendChange(new DepiladoEstilistaAgregado(depilacion)).apply();
    }

    public void ActualizarNombreEstilista(IdEstilista idEstilista, Nombre nombre){
        appendChange(new NombreEstilistaActualizado(idEstilista,nombre)).apply();
    }

    public void ActualizarTipoDeCorteDama(CorteDama corteDama){
        appendChange(new TipoDeCorteDamaActualizado(corteDama)).apply();
    }

    public void ActualizarTipoDeCabelloCorteDama(TipoDeCabello tipoDeCabello){
        appendChange(new TipoDeCabelloCorteDamaActualizado(tipoDeCabello)).apply();
    }

    public void AgregarEstilista(IdEstilista idEstilista, Nombre nombre){
        appendChange(new EstilistaAgregado(idEstilista,nombre)).apply();
    }


}
