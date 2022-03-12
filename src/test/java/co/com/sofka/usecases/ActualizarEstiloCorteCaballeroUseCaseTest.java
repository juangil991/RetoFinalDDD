package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.servicioscaballero.command.ActualizarEstiloCorteCaballero;
import co.com.sofka.domain.servicioscaballero.event.CorteCaballeroAgregado;
import co.com.sofka.domain.servicioscaballero.event.EstiloCorteCaballeroActualizado;
import co.com.sofka.domain.servicioscaballero.event.ServiciosCaballeroCreado;
import co.com.sofka.domain.servicioscaballero.valor.*;
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
class ActualizarEstiloCorteCaballeroUseCaseTest {

    @Mock
    public DomainEventRepository repository;

    @Test
    void ActualizarEstiloCorteCaballeroTest(){

        //arrange
        IdServiciosCaballero idServiciosCaballero= IdServiciosCaballero.of("1");
        IdCorteCaballero idCorteCaballero=IdCorteCaballero.of("1");
        EstiloCorte estiloCorte = new EstiloCorte("moicano","corte sutil");
        var command= new ActualizarEstiloCorteCaballero(idServiciosCaballero,idCorteCaballero,estiloCorte);
        var usecase= new ActualizarEstiloCorteCaballeroUseCase();
        Mockito.when(repository.getEventsBy("1")).thenReturn(history());
        usecase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idServiciosCaballero.value())
                .syncExecutor(usecase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (EstiloCorteCaballeroActualizado)events.get(0);
        Assertions.assertEquals("co.com.sofka.domain.serviciocaballero.estilocortecaballeroactualizado",
                event.type);
        Assertions.assertEquals("moicano",event.getEstiloCorte().value().NombreCorte());
        Assertions.assertEquals("corte sutil",event.getEstiloCorte().value().DescripcionCorte());

    }

    private List<DomainEvent> history() {
        Date Fecha = new Date(2022,03,11);
        FechaDeServicio fechaDeServicio = new FechaDeServicio(Fecha);
        Complejidad complejidad = new Complejidad("baja");
        EstiloCorte estiloCorte = new EstiloCorte("generico","calveada");
        return List.of(
                new ServiciosCaballeroCreado(fechaDeServicio),
                new CorteCaballeroAgregado(IdCorteCaballero.of("1"),complejidad,estiloCorte)
        );
    }
}