package co.com.sofka.usecases.servicioscaballero;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.servicioscaballero.command.ActualizarTipoDeDiseñoBarba;
import co.com.sofka.domain.servicioscaballero.event.*;
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
class ActualizarTipoDeDiseñoBarbaUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void ActualizarTipoDeDiseñoBarbaTest(){
        //arrange
        IdServiciosCaballero idServiciosCaballero= IdServiciosCaballero.of("xxxx");
        IdDiseñoBarba idDiseñoBarba= IdDiseñoBarba.of("xxxxx");
        TipoDeDiseño tipoDeDiseño = new TipoDeDiseño("Fractal","Diseño Detallado");
        var command= new ActualizarTipoDeDiseñoBarba(idServiciosCaballero,idDiseñoBarba,tipoDeDiseño);
        var usecase= new ActualizarTipoDeDiseñoBarbaUseCase();
        Mockito.when(repository.getEventsBy("xxxx")).thenReturn(history());
        usecase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idServiciosCaballero.value())
                .syncExecutor(usecase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (TipoDeDiseñoBarbaActualizado)events.get(0);
        Assertions.assertEquals("co.com.sofka.domain.serviciocaballero.tipodediseñobarbaactualizado",
                event.type);
        Assertions.assertEquals("Fractal",event.getTipoDeDiseño().value().NombreDiseño());
        Assertions.assertEquals("Diseño Detallado",event.getTipoDeDiseño().value().DescripcionDiseño());

    }
    private List<DomainEvent> history() {
        Date Fecha = new Date(2022,03,11);
        FechaDeServicio fechaDeServicio = new FechaDeServicio(Fecha);
        TipoDeDiseño tipoDeDiseño = new TipoDeDiseño("Generico","Diseño Simple");
        return List.of(
                new ServiciosCaballeroCreado(fechaDeServicio),
                new DiseñoBarbaAgregado(IdDiseñoBarba.of("xxxxx"),tipoDeDiseño)
        );
    }
}