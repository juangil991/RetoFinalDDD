package co.com.sofka.usecases.serviciosdama;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.serviciosdama.command.ActualizarNombreEstilista;
import co.com.sofka.domain.serviciosdama.command.AgregarEstilista;
import co.com.sofka.domain.serviciosdama.event.EstilistaAgregado;
import co.com.sofka.domain.serviciosdama.event.NombreEstilistaActualizado;
import co.com.sofka.domain.serviciosdama.event.ServiciosDamaCreado;
import co.com.sofka.domain.serviciosdama.valor.FechaDeServicio;
import co.com.sofka.domain.serviciosdama.valor.IdEstilista;
import co.com.sofka.domain.serviciosdama.valor.IdServicioDama;
import co.com.sofka.domain.serviciosdama.valor.Nombre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ActualizarNombreEstilistaUseCaseTest {

    @Mock
    public DomainEventRepository repository;

    @Test
    void ActualizarNombreEstilista(){
        //arrange
        IdServicioDama idServicioDama= IdServicioDama.of("xxxx");
        IdEstilista idEstilista= IdEstilista.of("xxx");
        Nombre nombre = new Nombre("louise","valencia");
        var command =new ActualizarNombreEstilista(idServicioDama,idEstilista,nombre);
        var usecase= new ActualizarNombreEstilistaUseCase();
        Mockito.when(repository.getEventsBy("xxxx")).thenReturn(history());
        usecase.addRepository(repository);
        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idServicioDama.value())
                .syncExecutor(usecase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assert
        var event=(NombreEstilistaActualizado)events.get(0);
        Assertions.assertEquals("co.com.sofka.domain.serviciosdama.nombreestilistaactualizado",event.type);
        Assertions.assertEquals("louise",event.getNombre().value().Nombre());
        Assertions.assertEquals("valencia",event.getNombre().value().apellido());
    }

    private List<DomainEvent> history() {
        FechaDeServicio fechaDeServicio= new FechaDeServicio();
        Nombre nombre = new Nombre("luis","yepes");
        return List.of(
                new ServiciosDamaCreado(fechaDeServicio),
                new EstilistaAgregado(IdEstilista.of("xxx"),nombre)
        );
    }
}