package co.com.sofka.domain.servicios.valor;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;

public class FechaDeServicio implements ValueObject<LocalDate> {
    private final LocalDate value;

    public FechaDeServicio(LocalDate value) {
        this.value = value;
    }

    public FechaDeServicio() {
        this(LocalDate.now());
    }

    @Override
    public LocalDate value() {
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
