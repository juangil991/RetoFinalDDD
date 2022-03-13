package co.com.sofka.usecases.serviciosdama;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.serviciosdama.event.ServiciosDamaCreado;
import co.com.sofka.domain.serviciosdama.valor.FechaDeServicio;
import co.com.sofka.domain.serviciosdama.command.CrearServicioDama;
import co.com.sofka.domain.serviciosdama.valor.IdServicioDama;
import co.com.sofka.usecases.serviciosdama.CrearServicioDamaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class ServicioDamaCreadoUseCaseTest {

    @Test
    void ServicioDamaCreadoTest(){
        //arrange
        IdServicioDama idServicioDama= new IdServicioDama();
        FechaDeServicio fechaDeServicio = new FechaDeServicio();
        var command = new CrearServicioDama(idServicioDama,fechaDeServicio);
        var usecase = new CrearServicioDamaUseCase();
        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assert
        var event = (ServiciosDamaCreado)events.get(0);
        Assertions.assertEquals("co.com.sofka.domain.serviciosdama.serviciosdamacreado",event.type);
        Assertions.assertEquals(LocalDate.now(),event.getFechaDeServicio().value());
    }

}