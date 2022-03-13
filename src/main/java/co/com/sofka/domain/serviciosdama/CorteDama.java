package co.com.sofka.domain.serviciosdama;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.serviciosdama.valor.IdCortesDama;
import co.com.sofka.domain.serviciosdama.valor.TipoDeCabello;
import co.com.sofka.domain.serviciosdama.valor.TipoDeCorte;

import java.util.Objects;

public class CorteDama extends Entity<IdCortesDama> {
    private IdCortesDama idCortesDama;
    private TipoDeCabello tipoDeCabello;
    private TipoDeCorte tipoDeCorte;

    public CorteDama(IdCortesDama idCortesDama, TipoDeCabello tipoDeCabello, TipoDeCorte tipoDeCorte) {
        super(idCortesDama);
        this.tipoDeCabello = tipoDeCabello;
        this.tipoDeCorte = tipoDeCorte;
    }

    public void ActualizarTipoDeCorte(TipoDeCorte tipoDeCorte){
        this.tipoDeCorte= Objects.requireNonNull(tipoDeCorte);
    }

    public void ActualizarTipoDeCabello(TipoDeCabello tipoDeCabello){
        this.tipoDeCabello=Objects.requireNonNull(tipoDeCabello);
    }

    public TipoDeCabello TipoDeCabello() {
        return tipoDeCabello;
    }

    public TipoDeCorte TipoDeCorte() {
        return tipoDeCorte;
    }
}

