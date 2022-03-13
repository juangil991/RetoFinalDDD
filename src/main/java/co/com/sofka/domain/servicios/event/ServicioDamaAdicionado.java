package co.com.sofka.domain.servicios.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.servicios.valor.IdServiciosDama;

public class ServicioDamaAdicionado extends DomainEvent {
    IdServiciosDama idServiciosDama;

    public ServicioDamaAdicionado(IdServiciosDama idServiciosDama) {
        super("co.com.sofka.domain.serviciosdama.serviciodamaadicionado");
        this.idServiciosDama = idServiciosDama;
    }

    public IdServiciosDama getIdServiciosDama() {
        return idServiciosDama;
    }
}
