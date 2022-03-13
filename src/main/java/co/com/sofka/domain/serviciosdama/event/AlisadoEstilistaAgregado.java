package co.com.sofka.domain.serviciosdama.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.serviciosdama.valor.Alisado;

public class AlisadoEstilistaAgregado extends DomainEvent {
    private final Alisado alisado;

    public AlisadoEstilistaAgregado(Alisado alisado) {
        super("co.com.sofka.domain.serviciosdama.alisadoestilistaagregado");
        this.alisado = alisado;
    }

    public Alisado getAlisado() {
        return alisado;
    }
}
