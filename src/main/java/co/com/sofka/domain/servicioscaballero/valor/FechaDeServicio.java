package co.com.sofka.domain.servicioscaballero.valor;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Date;

public class FechaDeServicio implements ValueObject<Date> {
    private final Date value;

    public FechaDeServicio(Date value) {
        this.value = value;
    }

    public FechaDeServicio() {
        this(new Date());
    }

    @Override
    public Date value() {
        return value;
    }
}
