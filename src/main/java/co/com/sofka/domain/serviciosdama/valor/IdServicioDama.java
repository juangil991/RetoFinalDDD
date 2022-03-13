package co.com.sofka.domain.serviciosdama.valor;

import co.com.sofka.domain.generic.Identity;

public class IdServicioDama extends Identity {
    public IdServicioDama() {
    }

    public IdServicioDama(String id) {
        super(id);
    }

    public static IdServicioDama of(String id){return new IdServicioDama(id);}
}
