package co.com.sofka.domain.serviciosdama.valor;

import co.com.sofka.domain.generic.ValueObject;

public class Esmalte implements ValueObject<Esmalte.Props>{
    private final String marca;
    private final String color;

    public Esmalte(String marca, String color) {
        this.marca = marca;
        this.color = color;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String Marca() {
                return marca;
            }

            @Override
            public String Color() {
                return color;
            }
        };
    }

    public interface Props{
        String Marca();
        String Color();
    }
}
