package co.com.sofka.domain.servicios.valor;

import co.com.sofka.domain.generic.Identity;

public class IdServiciosDama extends Identity {
    public IdServiciosDama() {
    }

    public IdServiciosDama(String id) {
        super(id);
    }

    public static IdServiciosDama of(String id){return new IdServiciosDama(id);}
}
