package co.com.sofka.domain.servicios.valor;

import co.com.sofka.domain.generic.ValueObject;

public class Genero implements ValueObject<String> {
    private final String genero;

    public Genero(String genero) {
        this.genero = genero;
    }
    @Override
    public String value() {
        return genero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Genero genero1 = (Genero) o;

        return genero.equals(genero1.genero);
    }

    @Override
    public int hashCode() {
        return genero.hashCode();
    }
}
