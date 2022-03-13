package co.com.sofka.domain.serviciosdama;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.serviciosdama.valor.DiseñoUñas;
import co.com.sofka.domain.serviciosdama.valor.Esmalte;
import co.com.sofka.domain.serviciosdama.valor.IdManicurista;
import co.com.sofka.domain.serviciosdama.valor.Nombre;

import java.util.List;
import java.util.Objects;

public class Manicurista extends Entity<IdManicurista> {
    private IdManicurista idManicurista;
    private DiseñoUñas diseñoUñas;
    private Nombre nombre;
    private List<Esmalte> esmaltes;

    public Manicurista(IdManicurista idManicurista, DiseñoUñas diseñoUñas, Nombre nombre) {
        super(idManicurista);
        this.diseñoUñas = diseñoUñas;
        this.nombre = nombre;
    }

    public void ActualizarNombre(Nombre nombre){
        this.nombre= Objects.requireNonNull(nombre);
    }

    public void ActualizarDiseñoUñas(DiseñoUñas diseñoUñas){
        this.diseñoUñas=Objects.requireNonNull(diseñoUñas);
    }

    public void AgregarEsmalte(Esmalte esmalte){
        this.esmaltes.add(Objects.requireNonNull(esmalte));
    }


    public DiseñoUñas DiseñoUñas() {
        return diseñoUñas;
    }

    public Nombre Nombre() {
        return nombre;
    }
}
