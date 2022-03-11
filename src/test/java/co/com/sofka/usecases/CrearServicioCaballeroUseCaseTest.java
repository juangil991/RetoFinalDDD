package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.servicioscaballero.ServiciosCaballero;
import co.com.sofka.domain.servicioscaballero.command.CrearServicioCaballero;
import co.com.sofka.domain.servicioscaballero.event.ServiciosCaballeroCreado;
import co.com.sofka.domain.servicioscaballero.valor.FechaDeServicio;
import co.com.sofka.domain.servicioscaballero.valor.IdServiciosCaballero;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CrearServicioCaballeroUseCaseTest {

    @Test
    void CrearServicioCaballero(){
        //arrange
        Date Fecha = new Date(2022,11,03);
        IdServiciosCaballero idServiciosCaballero = new IdServiciosCaballero();
        FechaDeServicio fechaDeServicio = new FechaDeServicio(Fecha);
         var command = new CrearServicioCaballero(idServiciosCaballero,fechaDeServicio);
         var usecase = new CrearServicioCaballeroUseCase();
        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assert
        var event = (ServiciosCaballeroCreado)events.get(0);
        Assertions.assertEquals("co.com.sofka.domain.serviciocaballero.serviciocaballerocreado",event.type);
        Assertions.assertEquals(new Date(2022,11,03),event.getFechaDeServicio().value());
    }
}