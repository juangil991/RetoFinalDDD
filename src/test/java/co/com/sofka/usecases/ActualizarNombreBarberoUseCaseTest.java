package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.servicioscaballero.command.ActualizarNombreBarbero;
import co.com.sofka.domain.servicioscaballero.event.BarberoAgregado;
import co.com.sofka.domain.servicioscaballero.event.NombreBarberoActualizado;
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
class ActualizarNombreBarberoUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void ActualizarNombreBarberoTest(){
        //arrange
        IdServiciosCaballero idServiciosCaballero= IdServiciosCaballero.of("xxxx");
        IdBarbero idBarbero= IdBarbero.of("xxxxx");
        Nombre nombre = new Nombre("Antonio","Salamanca");
        var command= new ActualizarNombreBarbero(idServiciosCaballero,idBarbero,nombre);
        var usecase= new ActualizarNombreBarberoUseCase();
        Mockito.when(repository.getEventsBy("xxxx")).thenReturn(history());
        usecase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idServiciosCaballero.value())
                .syncExecutor(usecase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (NombreBarberoActualizado)events.get(0);
        Assertions.assertEquals("co.com.sofka.domain.servicioscaballero.nombrebarberoactualizado",
                event.type);
        Assertions.assertEquals("Antonio",event.getNombre().value().Nombre());
        Assertions.assertEquals("Salamanca",event.getNombre().value().apellido());

    }
    private List<DomainEvent> history() {
        Date Fecha = new Date(2022,03,11);
        FechaDeServicio fechaDeServicio = new FechaDeServicio(Fecha);
        Experiencia experiencia = new Experiencia("pocos trabajos",1);
        Nombre nombre = new Nombre("Carlos","Perez");
        return List.of(
                new ServiciosCaballeroCreado(fechaDeServicio),
                new BarberoAgregado(IdBarbero.of("xxxxx"),nombre,experiencia)
        );
    }
}