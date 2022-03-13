package co.com.sofka.usecases.servicioscaballero;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.servicioscaballero.ServiciosCaballero;
import co.com.sofka.domain.servicioscaballero.command.AgregarCorteCaballero;
import co.com.sofka.domain.servicioscaballero.event.CorteCaballeroAgregado;
import co.com.sofka.domain.servicioscaballero.event.ServiciosCaballeroCreado;
import co.com.sofka.domain.servicioscaballero.valor.*;
import co.com.sofka.usecases.AgregarCorteCaballeroUseCase;
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
class AgregarCorteCaballeroUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void AgregarcorteCaballero(){
        //arrange
        IdServiciosCaballero idServiciosCaballero= IdServiciosCaballero.of("xxxx");
        IdCorteCaballero idCorteCaballero= IdCorteCaballero.of("xxxxx");
        Complejidad complejidad= new Complejidad("alta");
        EstiloCorte estiloCorte= new EstiloCorte("generico","corte a los lados");
        var command = new AgregarCorteCaballero(idServiciosCaballero,idCorteCaballero,complejidad,estiloCorte);
        var usecase = new AgregarCorteCaballeroUseCase();
        Mockito.when(repository.getEventsBy("xxxx")).thenReturn(history());
        usecase.addRepository(repository);
        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idServiciosCaballero.value())
                .syncExecutor(usecase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assert
        var event = (CorteCaballeroAgregado)events.get(0);
        Assertions.assertEquals("co.com.sofka.domain.serviciocaballero.serviciocaballerocreado",event.type);
        Assertions.assertEquals("alta",event.getComplejidad().value());
        Assertions.assertEquals("generico", event.getEstiloCorte().value().NombreCorte());
        Assertions.assertEquals("corte a los lados",event.getEstiloCorte().value().DescripcionCorte());
    }
    private List<DomainEvent> history() {
        Date Fecha = new Date(2022,03,11);
        FechaDeServicio fechaDeServicio = new FechaDeServicio(Fecha);
        return List.of(
               new ServiciosCaballeroCreado(fechaDeServicio)
        );
    }
}