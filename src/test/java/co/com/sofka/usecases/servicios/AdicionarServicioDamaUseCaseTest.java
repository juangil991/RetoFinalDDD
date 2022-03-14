package co.com.sofka.usecases.servicios;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.servicios.command.ActualizarNombreCliente;
import co.com.sofka.domain.servicios.command.AdicionarServicioDama;
import co.com.sofka.domain.servicios.event.NombreClienteActualizado;
import co.com.sofka.domain.servicios.event.ServicioDamaAdicionado;
import co.com.sofka.domain.servicios.event.ServiciosAgregado;
import co.com.sofka.domain.servicios.valor.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AdicionarServicioDamaUseCaseTest {
    @Mock
    private DomainEventRepository repository;

    @Test
    void AdicionarServicioDamaTest(){
        IdServicios idServicios = IdServicios.of("xxxx");
        IdServiciosDama idServiciosDama= IdServiciosDama.of("xxx");
        var command =new AdicionarServicioDama(idServicios,idServiciosDama);
        var usecase= new AdicionarServicioDamaUseCase();
        Mockito.when(repository.getEventsBy("xxxx")).thenReturn(history());
        usecase.addRepository(repository);
        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idServicios.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assert
        var event=(ServicioDamaAdicionado)events.get(0);
        Assertions.assertEquals("co.com.sofka.domain.serviciosdama.serviciodamaadicionado",event.type);
        Assertions.assertEquals("xxx",event.getIdServiciosDama().value());
    }

    private List<DomainEvent> history() {
        FechaDeServicio fechaDeServicio= new FechaDeServicio();
        IdServiciosDama idServiciosDama= IdServiciosDama.of("xxxxxx");
        return List.of(
                new ServiciosAgregado(fechaDeServicio),
                new ServicioDamaAdicionado(idServiciosDama)

        );
    }

}