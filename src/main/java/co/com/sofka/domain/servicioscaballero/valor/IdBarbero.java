package co.com.sofka.domain.servicioscaballero.valor;

import co.com.sofka.domain.generic.Identity;

public class IdBarbero extends Identity {
    public IdBarbero() {
    }

    public IdBarbero(String id) {
        super(id);
    }

    public static IdBarbero of(String id){
        return new IdBarbero(id);
    }
}
