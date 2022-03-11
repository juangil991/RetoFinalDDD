package co.com.sofka.domain.servicioscaballero.valor;

import co.com.sofka.domain.generic.Identity;

public class IdDiseñoBarba extends Identity {
    public IdDiseñoBarba() {
    }

    public IdDiseñoBarba(String id) {
        super(id);
    }

    public static IdDiseñoBarba of(String id){
        return new IdDiseñoBarba(id);
    }
}
