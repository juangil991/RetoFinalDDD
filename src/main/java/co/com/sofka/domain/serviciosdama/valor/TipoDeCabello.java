package co.com.sofka.domain.serviciosdama.valor;

import co.com.sofka.domain.generic.ValueObject;

public class TipoDeCabello implements ValueObject<TipoDeCabello.Props> {
    private final String  descripcionTipoDeCabello;
    private final String tamañoCabello;

    public TipoDeCabello(String descripcionTipoDeCabello, String tamañoCabello) {
        this.descripcionTipoDeCabello = descripcionTipoDeCabello;
        this.tamañoCabello = tamañoCabello;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String DescripcionTipoDeCabello() {
                return descripcionTipoDeCabello;
            }

            @Override
            public String TamañoCabello() {
                return tamañoCabello;
            }
        };
    }

    public interface Props{
        String DescripcionTipoDeCabello();
        String TamañoCabello();
    }
}
