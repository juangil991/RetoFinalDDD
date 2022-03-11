package co.com.sofka.domain.servicioscaballero.valor;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Complejidad implements ValueObject<String> {
    private final String value;

    public Complejidad(String NivelDeComplejidad){
        this.value = Objects.requireNonNull(NivelDeComplejidad);
        if(this.value.isBlank()){
            new IllegalArgumentException("La complejidad no puede estar vacia");
        }
    }

    public String value(){
        return value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Complejidad that = (Complejidad) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
