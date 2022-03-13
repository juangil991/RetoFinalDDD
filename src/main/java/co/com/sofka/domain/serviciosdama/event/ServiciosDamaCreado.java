package co.com.sofka.domain.serviciosdama.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.serviciosdama.valor.FechaDeServicio;

import java.time.LocalDate;

public class ServiciosDamaCreado extends DomainEvent {
    private final FechaDeServicio fechaDeServicio;

    public ServiciosDamaCreado(FechaDeServicio fechaDeServicio) {
        super("co.com.sofka.domain.serviciosdama.serviciosdamacreado");
        this.fechaDeServicio = fechaDeServicio;
    }

    public FechaDeServicio getFechaDeServicio() {
        return fechaDeServicio;
    }
}
