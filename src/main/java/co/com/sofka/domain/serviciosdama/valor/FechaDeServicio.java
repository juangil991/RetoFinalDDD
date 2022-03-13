package co.com.sofka.domain.serviciosdama.valor;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FechaDeServicio that = (FechaDeServicio) o;

        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
