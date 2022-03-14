package co.com.sofka.domain.servicios.valor;

import co.com.sofka.domain.generic.ValueObject;

public class Nombre implements ValueObject<Nombre.Props> {
    private final String nombre;
    private final String apellido;

    public Nombre(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String Nombre() {
                return nombre;
            }

            @Override
            public String apellido() {
                return apellido;
            }
        };
    }

    public interface Props{
        String Nombre();
        String apellido();
    }
}
