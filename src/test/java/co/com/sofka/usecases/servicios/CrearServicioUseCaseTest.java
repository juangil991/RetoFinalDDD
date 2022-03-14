package co.com.sofka.usecases.servicios;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.servicios.command.CrearServicio;
import co.com.sofka.domain.servicios.event.ServiciosAgregado;
import co.com.sofka.domain.servicios.valor.FechaDeServicio;
import co.com.sofka.domain.servicios.valor.IdServicios;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CrearServicioUseCaseTest {

    @Test
    void CrearServicios(){
        //arrange
        IdServicios idServicios= new IdServicios();
        FechaDeServicio fechaDeServicio= new FechaDeServicio();
        var command = new CrearServicio(idServicios,fechaDeServicio);
        var usecase = new CrearServicioUseCase();
        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assert
        var event=(ServiciosAgregado)events.get(0);
        Assertions.assertEquals("co.com.sofka.domain.servicios.servicioscreado",event.type);
        Assertions.assertEquals(LocalDate.now(),event.getFechaDeServicio().value());
    }

}