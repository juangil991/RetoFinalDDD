package co.com.sofka.domain.serviciosdama.valor;

import co.com.sofka.domain.generic.ValueObject;

public class Cepillado implements ValueObject<Cepillado.Props> {
    private final String descripcionCepillado;
    private final String tamañodelCabello;

    public Cepillado(String descripcionCepillado, String tamañodelCabello) {
        this.descripcionCepillado = descripcionCepillado;
        this.tamañodelCabello = tamañodelCabello;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String DescripcionCepillado() {
                return descripcionCepillado;
            }

            @Override
            public String TamañoDelCabello() {
                return tamañodelCabello;
            }
        };
    }

    public interface Props{
        String DescripcionCepillado();
        String TamañoDelCabello();
    }
}
