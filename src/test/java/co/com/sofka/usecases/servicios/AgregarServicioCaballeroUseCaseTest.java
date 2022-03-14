package co.com.sofka.usecases.servicios;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.servicios.command.AdicionarServicioCaballero;
import co.com.sofka.domain.servicios.command.AdicionarServicioDama;
import co.com.sofka.domain.servicios.event.ServicioCaballeroAdicionado;
import co.com.sofka.domain.servicios.event.ServicioDamaAdicionado;
import co.com.sofka.domain.servicios.event.ServiciosAgregado;
import co.com.sofka.domain.servicios.valor.FechaDeServicio;
import co.com.sofka.domain.servicios.valor.IdServicios;
import co.com.sofka.domain.servicios.valor.IdServiciosCaballero;
import co.com.sofka.domain.servicios.valor.IdServiciosDama;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AgregarServicioCaballeroUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void AgregarServicioCaballeroTest(){
        IdServicios idServicios = IdServicios.of("xxxx");
        IdServiciosCaballero idServiciosCaballero= IdServiciosCaballero.of("xxx");
        var command =new AdicionarServicioCaballero(idServicios,idServiciosCaballero);
        var usecase= new AdicionarServicioCaballeroUseCase();
        Mockito.when(repository.getEventsBy("xxxx")).thenReturn(history());
        usecase.addRepository(repository);
        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idServicios.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assert
        var event=(ServicioCaballeroAdicionado)events.get(0);
        Assertions.assertEquals("co.com.sofka.domain.serviciosdama.serviciocaballeroadicionado",event.type);
        Assertions.assertEquals("xxx",event.getIdServiciosCaballero().value());

    }
    private List<DomainEvent> history() {
        FechaDeServicio fechaDeServicio= new FechaDeServicio();
        return List.of(
                new ServiciosAgregado(fechaDeServicio)
        );
    }

}