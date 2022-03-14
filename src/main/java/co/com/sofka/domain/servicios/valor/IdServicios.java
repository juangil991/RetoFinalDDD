package co.com.sofka.domain.servicios.valor;

import co.com.sofka.domain.generic.Identity;

public class IdServicios extends Identity {
    public IdServicios() {
    }

    public IdServicios(String id) {
        super(id);
    }

    public static IdServicios of(String id){return new IdServicios(id);}
}
