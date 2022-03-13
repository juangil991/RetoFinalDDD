package co.com.sofka.domain.serviciosdama.valor;

import co.com.sofka.domain.generic.ValueObject;

public class Depilacion implements ValueObject<String> {
    private final String descripcionDepilado;

    public Depilacion(String descripcionDepilado) {
        this.descripcionDepilado = descripcionDepilado;
    }

    @Override
    public String value() {
        return descripcionDepilado;
    }
}
