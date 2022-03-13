package co.com.sofka.domain.serviciosdama.valor;

import co.com.sofka.domain.generic.Identity;

public class IdCortesDama extends Identity {

    public IdCortesDama(){
    }

    public IdCortesDama(String id) {
        super(id);
    }

    public static IdCortesDama of(String id){return new IdCortesDama(id);}
}
