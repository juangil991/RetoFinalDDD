package co.com.sofka.domain.serviciosdama.valor;

import co.com.sofka.domain.generic.Identity;

public class IdManicurista extends Identity {
    public IdManicurista() {
    }

    public IdManicurista(String id) {
        super(id);
    }

    public static IdManicurista of(String id){return new IdManicurista(id);}
}
