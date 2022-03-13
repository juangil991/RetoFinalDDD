package co.com.sofka.usecases.servicioscaballero;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.servicioscaballero.command.ActualizarExperienciaBarbero;
import co.com.sofka.domain.servicioscaballero.event.BarberoAgregado;
import co.com.sofka.domain.servicioscaballero.event.ExperienciaBarberoActualizada;
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

@ExtendWith(MockitoExtension.class)
class ActualizarExperienciaBarberoUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void ActualizarExperienciaBarberoTest(){
        //arrange
        IdServiciosCaballero idServiciosCaballero= IdServiciosCaballero.of("xxxx");
        IdBarbero idBarbero= IdBarbero.of("xxxxx");
        Experiencia experiencia = new Experiencia("Muchos",4);
        Nombre nombre = new Nombre("Carlos","Perez");
        var command= new ActualizarExperienciaBarbero(idServiciosCaballero,idBarbero,experiencia);
        var usecase= new ActualizarExperienciaBarberoUseCase();
        Mockito.when(repository.getEventsBy("xxxx")).thenReturn(history());
        usecase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idServiciosCaballero.value())
                .syncExecutor(usecase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (ExperienciaBarberoActualizada)events.get(0);
        Assertions.assertEquals("co.com.sofka.domain.servicioscaballero.experienciabarberoactualizada",
                event.type);
        Assertions.assertEquals("Muchos",event.getExperiencia().value().TrabajosRealizados());
        Assertions.assertEquals(4,event.getExperiencia().value().AñosExperiencia());

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