package co.com.sofka.domain.serviciosdama.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.serviciosdama.valor.Cepillado;

public class CepilladoEstilistaAgregado extends DomainEvent {
    private final Cepillado cepillado;

    public CepilladoEstilistaAgregado(Cepillado cepillado) {
        super("co.com.sofka.domain.serviciosdama.cepilladoestilistaagregado");
        this.cepillado = cepillado;
    }

    public Cepillado getCepillado() {
        return cepillado;
    }
}
