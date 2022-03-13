package co.com.sofka.usecases.servicioscaballero;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.servicioscaballero.CorteCaballero;
import co.com.sofka.domain.servicioscaballero.ServiciosCaballero;
import co.com.sofka.domain.servicioscaballero.command.ActualizarComplejidadCorteCaballero;
import co.com.sofka.domain.servicioscaballero.command.AgregarCorteCaballero;
import co.com.sofka.domain.servicioscaballero.event.ComplejidadCorteCaballeroActualizada;
import co.com.sofka.domain.servicioscaballero.event.CorteCaballeroAgregado;
import co.com.sofka.domain.servicioscaballero.event.ServiciosCaballeroCreado;
import co.com.sofka.domain.servicioscaballero.valor.*;
import co.com.sofka.usecases.ActualizarComplejidadCorteCaballeroUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ActualizarComplejidadCorteCaballeroUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void ActualizarComplejidad(){

        //arrange
        IdServiciosCaballero idServiciosCaballero=IdServiciosCaballero.of("xxxx");
        IdCorteCaballero idCorteCaballero= IdCorteCaballero.of("xxxxx");
        Complejidad complejidad = new Complejidad("alta");
        var command = new ActualizarComplejidadCorteCaballero(idServiciosCaballero,idCorteCaballero,complejidad);
        var usecase = new ActualizarComplejidadCorteCaballeroUseCase();
        Mockito.when(repository.getEventsBy("xxxx")).thenReturn(history());
        usecase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idServiciosCaballero.value())
                .syncExecutor(usecase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assert
        var event =(ComplejidadCorteCaballeroActualizada)events.get(0);
        Assertions.assertEquals("co.com.sofka.domain.serviciocaballero.complejidadcortecaballeroactualizada",
                event.type);
        Assertions.assertEquals("alta",event.getComplejidad().value());

    }
    private List<DomainEvent> history() {
        Date Fecha = new Date(2022,03,11);
        FechaDeServicio fechaDeServicio = new FechaDeServicio(Fecha);
        Complejidad complejidad = new Complejidad("baja");
        EstiloCorte estiloCorte = new EstiloCorte("generico","calveada");
        return List.of(
                new ServiciosCaballeroCreado(fechaDeServicio),
                new CorteCaballeroAgregado(IdCorteCaballero.of("x"),complejidad,estiloCorte)
        );
    }
}