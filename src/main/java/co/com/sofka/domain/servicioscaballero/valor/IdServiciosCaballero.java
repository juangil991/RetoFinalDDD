package co.com.sofka.domain.servicioscaballero.valor;

import co.com.sofka.domain.generic.Identity;

public class IdServiciosCaballero extends Identity {
    public IdServiciosCaballero() {
    }

    public IdServiciosCaballero(String id) {
        super(id);
    }

    public static IdServiciosCaballero of(String id){
        return new IdServiciosCaballero(id);
    }
}
