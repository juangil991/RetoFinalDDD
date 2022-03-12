package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.servicioscaballero.command.AgregarDiseñoBarba;
import co.com.sofka.domain.servicioscaballero.event.DiseñoBarbaAgregado;
import co.com.sofka.domain.servicioscaballero.event.ServiciosCaballeroCreado;
import co.com.sofka.domain.servicioscaballero.valor.FechaDeServicio;
import co.com.sofka.domain.servicioscaballero.valor.IdDiseñoBarba;
import co.com.sofka.domain.servicioscaballero.valor.IdServiciosCaballero;
import co.com.sofka.domain.servicioscaballero.valor.TipoDeDiseño;
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
class AgregarDiseñoBarbaUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void AgregarDiseñoBarbaTest(){
    //arrange
    IdServiciosCaballero idServiciosCaballero= IdServiciosCaballero.of("xxxx");
    IdDiseñoBarba idDiseñoBarba= IdDiseñoBarba.of("xxxxx");
    TipoDeDiseño tipoDeDiseño = new TipoDeDiseño("Fractal","Diseño Detallado");
    var command= new AgregarDiseñoBarba(idServiciosCaballero,idDiseñoBarba,tipoDeDiseño);
    var usecase= new AgregarDiseñoBarbaUseCase();
        Mockito.when(repository.getEventsBy("xxxx")).thenReturn(history());
        usecase.addRepository(repository);

    //act
    var events = UseCaseHandler.getInstance()
            .setIdentifyExecutor(idServiciosCaballero.value())
            .syncExecutor(usecase,new RequestCommand<>(command))
            .orElseThrow()
            .getDomainEvents();

    //assert
    var event = (DiseñoBarbaAgregado)events.get(0);
        Assertions.assertEquals("co.com.sofka.domain.serviciocaballero.diseñobarbaagregado",
    event.type);
        Assertions.assertEquals("Fractal",event.getTipoDeDiseño().value().NombreDiseño());
        Assertions.assertEquals("Diseño Detallado",event.getTipoDeDiseño().value().DescripcionDiseño());

}
    private List<DomainEvent> history() {
        Date Fecha = new Date(2022,03,11);
        FechaDeServicio fechaDeServicio = new FechaDeServicio(Fecha);
        return List.of(
                new ServiciosCaballeroCreado(fechaDeServicio)
        );
    }
}