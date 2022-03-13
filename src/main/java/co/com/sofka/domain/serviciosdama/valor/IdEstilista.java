package co.com.sofka.domain.serviciosdama.valor;

import co.com.sofka.domain.generic.Identity;

public class IdEstilista extends Identity {

    public IdEstilista() {
    }

    public IdEstilista(String id) {
        super(id);
    }

    public static IdEstilista of(String id){return new IdEstilista(id);}
}
