package co.com.sofka.domain.servicioscaballero.valor;

import co.com.sofka.domain.generic.Identity;

public class IdCorteCaballero extends Identity {
    public IdCorteCaballero() {
    }

    public IdCorteCaballero(String id) {
        super(id);
    }

    public static IdCorteCaballero of(String id){
        return new IdCorteCaballero(id);
    }
}
